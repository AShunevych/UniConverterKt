
package ashunevich.uniconverter20;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;
import org.mariuszgromada.math.mxparser.Expression;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Objects;

import ashunevich.uniconverter20.databinding.CurrencyActivityBinding;

import static ashunevich.uniconverter20.Utils.getSpinnerValueString;

public class Activity_converter_Currency  extends AppCompatActivity {

     
     private CurrencyActivityBinding binding;
    private SharedPreferences mPrefs;
    protected double getEnteredValue;
    protected HashMap<String, String> hm;
    private final String SAVED_VALUE = "savedValue";
    private final String SAVED_RESULT = "saveResult";
    private final String SAVED_DATE = "saveDate";
    private final String SAVED_HMAP = "CurrencyHMAP";

    @Override
    public void onStart(){
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPrefs
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        if (mPrefs != null){
            binding.dateView.setText(mPrefs.getString(SAVED_DATE,""));
            Type typeOfHashMap = new TypeToken<HashMap<String, String>>() { }.getType();
            String JSONHash = mPrefs.getString(SAVED_HMAP,"");
            hm = new Gson().fromJson(JSONHash, typeOfHashMap);
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(SAVED_VALUE,binding.valueCurrency.getText().toString());
        savedInstanceState.putString(SAVED_RESULT,binding.resultCurrency.getText().toString());
        savedInstanceState.putString(SAVED_DATE,binding.dateView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CurrencyActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButtonBindings_ConverterCurrency();
        setAdapter((getResources().getStringArray(R.array.currency)));
        setUnitMeasurments();
        setSpinnersListeners();
        checkConnection();
        addTextWatcher();
        binding.valueCurrency.setInputType(InputType.TYPE_NULL);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        binding.valueCurrency.setText(savedInstanceState.getString(SAVED_VALUE));
        binding.resultCurrency.setText(savedInstanceState.getString(SAVED_RESULT));
        binding.dateView.setText(savedInstanceState.getString(SAVED_DATE));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onPause() {
        super.onPause();
        mPrefs = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit = mPrefs.edit();
        myEdit.putString(SAVED_DATE,binding.dateView.getText().toString());
        String hashMapString = new Gson().toJson(hm);
        myEdit.putString(SAVED_HMAP,hashMapString);
        myEdit.commit();
    }

    private void checkConnection(){
        if(InternetConnection.checkConnection(this)){
             getJsonDate();
        }
        else{
            Snackbar.make(binding.currencyLayout, getResources().getString(R.string.NoInternetConnection),Snackbar.LENGTH_SHORT).show();
        }
    }

    @Subscribe()
    public void getText (BusPost_Number event) {
        if (event.getNumber().contains("brackets") |
                event.getNumber().contains("clear")|
                event.getNumber().contains("solve")){
            switch (event.getNumber()){
                case "brackets": Utils.checkBrackets(binding.valueCurrency); break;
                case "solve": convertOnDemand();break;
                case "clear": Utils.clearView(binding.valueCurrency,binding.resultCurrency);break;
            }
        }
        else{
            binding.valueCurrency.append(event.getNumber());
        }
    }

    //app Listeners work
    private void setButtonBindings_ConverterCurrency(){
        binding.refreshJSONData.setOnClickListener(v ->
                checkConnection());
        binding.correction.setOnClickListener(v -> Utils.correctValue(binding.valueCurrency,binding.resultCurrency));
    }

             //if user changes unit - it will change measurements and will automatically recalculate result
    private void setSpinnersListeners(){
        binding.spinnerFromCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurments();
                convertOnDemand();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        binding.spinnerToCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurments();
                convertOnDemand();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }});

    }

             //Auto conversion  when user add number to value for convert
    private void addTextWatcher() {
        binding.valueCurrency.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                    if (binding.valueCurrency.getText().toString().contains("+") |
                            binding.valueCurrency.getText().toString().contains("-") |
                            binding.valueCurrency.getText().toString().contains("/") |
                            binding.valueCurrency.getText().toString().contains("*")|
                            binding.valueCurrency.getText().toString().contains("(") |
                            binding.valueCurrency.getText().toString().contains(")")|
                            TextUtils.isEmpty(binding.valueCurrency.getText().toString())){
                        Log.d("valueCurrency ","occurred exception");
                }
                    else{
                        convertOnTextChange();
                    }

                }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
    }



    //set units of measurements for value
    private void setUnitMeasurments(){
        Utils.measurementUnitsHandler(getSpinnerValueString(binding.spinnerFromCurrency),binding.currencyFROMShort);
        Utils.measurementUnitsHandler(getSpinnerValueString(binding.spinnerToCurrency),binding.currencyToShort );
    }

    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item,array);
        binding.spinnerFromCurrency.setAdapter(adapter);
        binding.spinnerToCurrency.setAdapter(adapter);
    }

    private void setStringFormat(double resultDouble){
        NumberFormat formatter = new DecimalFormat("###.####");
        binding.resultCurrency.setText(String.valueOf(formatter.format(resultDouble)));
    }


    // app conversion work
    private void convertOnTextChange(){
        getEnteredValue = Double.parseDouble(binding.valueCurrency.getText().toString());
        try {
            double initRate = Double.parseDouble(Objects.requireNonNull(hm.get(getSpinnerValueString(binding.spinnerFromCurrency))));
            double targetRate = Double.parseDouble(Objects.requireNonNull(hm.get(getSpinnerValueString(binding.spinnerToCurrency))));
            setStringFormat(Utils.currencyConverter(getEnteredValue,targetRate,initRate));
        }
        catch (Exception e){
            Log.d(" Exception","exeption catched") ;
        }
    }

    private void convertOnDemand(){
        if (TextUtils.isEmpty(binding.valueCurrency.getText().toString())) {
            binding.resultCurrency.setText("");
        }
        else {
            try { //get JSON received values
                double initRate = Double.parseDouble(Objects.requireNonNull(hm.get(getSpinnerValueString(binding.spinnerFromCurrency))));
                double targetRate = Double.parseDouble(Objects.requireNonNull(hm.get(getSpinnerValueString(binding.spinnerToCurrency))));
                //use MathParser to calculate value
                Expression value = new Expression(binding.valueCurrency.getText().toString());
                //use calculated value
                setStringFormat(Utils.currencyConverter(value.calculate(), targetRate, initRate));
            }
            catch (Exception e){
                Log.d(" Exception","exeption catched") ;
            }

        }
    }



    // app JSON retrieving work

    private void getJsonDate() {
        String url = "https://api.exchangeratesapi.io/latest";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, response -> {
                    if (response != null){
                        Log.d("Tag", "Response is null");
                    }
                    //USD,GBP,IDR,PLN,NZD,RUB
                    try {
                        assert response != null;
                        String date = response.getString("date");
                        // if user starts new activity and there is no saved data
                         if (TextUtils.isEmpty(binding.dateView.getText().toString())){
                            binding.dateView.setText(date);
                            getJsonOnlineData();
                        }
                         // if user wants to update data, and data on source is equals to data in the phone. so data was already saved before.
                        else if (binding.dateView.getText().equals(date)){
                            Snackbar.make(binding.currencyLayout, getResources().getString(R.string.SameDate),Snackbar.LENGTH_SHORT).show();
                        }
                        // if user wants to update, and data is different on the source
                        else {
                             binding.dateView.setText(date);
                             Snackbar.make(binding.currencyLayout, getResources().getString(R.string.UpdateSuccessful),Snackbar.LENGTH_SHORT).show();
                             getJsonOnlineData();
                         }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> VolleyLog.d("TAG", "Error: " + error.getMessage()));
        RequestQueue queue = Volley.newRequestQueue(this);
        // Adding request to request queue
        queue.add(jsonObjReq);
    }

    private void getJsonOnlineData() {
        String url = "https://api.exchangeratesapi.io/latest";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, response -> {
                    //USD,GBP,IDR,PLN,NZD,RUB
                    try {
                            JSONObject phone = response.getJSONObject("rates");
                                hm = new HashMap<>();
                                hm.put(getResources().getString(R.string.USD), phone.getString("USD"));
                                hm.put(getResources().getString(R.string.GBP), phone.getString("GBP"));
                                hm.put(getResources().getString(R.string.IDR), phone.getString("IDR"));
                                hm.put(getResources().getString(R.string.PLN), phone.getString("PLN"));
                                hm.put(getResources().getString(R.string.NZD), phone.getString("NZD"));
                                hm.put(getResources().getString(R.string.RUB), phone.getString("RUB"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, error -> VolleyLog.d("TAG", "Error: " + error.getMessage()));
        RequestQueue queue = Volley.newRequestQueue(this);
        // Adding request to request queue
        queue.add(jsonObjReq);
    }

    }





