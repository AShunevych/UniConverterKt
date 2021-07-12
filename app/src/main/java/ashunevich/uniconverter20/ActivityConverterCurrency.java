
package ashunevich.uniconverter20;


import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ashunevich.uniconverter20.databinding.CurrencyActivityBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static ashunevich.uniconverter20.Utils.HASH_MAP;
import static ashunevich.uniconverter20.Utils.PREFERENCE_NAME;
import static ashunevich.uniconverter20.Utils.SAVED_DATE;
import static ashunevich.uniconverter20.Utils.SAVED_RESULT;
import static ashunevich.uniconverter20.Utils.SAVED_VALUE;
import static ashunevich.uniconverter20.Utils.currencyUnitHandler;
import static ashunevich.uniconverter20.Utils.getSpinnerValueString;
import static ashunevich.uniconverter20.Utils.returnDateString;

public class ActivityConverterCurrency extends AppCompatActivity {

     
     private CurrencyActivityBinding binding;
    private SharedPreferenceManager prefManager;
    protected double getEnteredValue;
    public HashMap<String, Double> hm;




    @Override
    public void onStart(){
        EventBus.getDefault().register(this);
        super.onStart();
    }



    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(SAVED_VALUE,binding.valueCurrency.getText().toString());
        savedInstanceState.putString(SAVED_RESULT,binding.resultCurrency.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CurrencyActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefManager = new SharedPreferenceManager(this, PREFERENCE_NAME);
        getSharedPref();
        setButtonBindings_ConverterCurrency();
        setAdapter((getResources().getStringArray(R.array.currency)));
        setUnitMeasurements();
        setSpinnersListeners();
        if(TextUtils.isEmpty(returnDateString(binding.dateView))){
            checkConnection();
        }
        addTextWatcher();
        binding.valueCurrency.setInputType(InputType.TYPE_NULL);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        binding.valueCurrency.setText(savedInstanceState.getString(SAVED_VALUE));
        binding.resultCurrency.setText(savedInstanceState.getString(SAVED_RESULT));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void getSharedPref(){
      binding.dateView.setText(prefManager.getValue(SAVED_DATE,""));
        hm = new HashMap<> ();
      hm = prefManager.getHashMap(HASH_MAP);
    }

    private void checkConnection(){
        if(UtilsInternetService.checkConnection(this)){
          checkDate ();
        }
        else{
            Snackbar.make(binding.currencyLayout, getResources().getString(R.string.NoInternetConnection),Snackbar.LENGTH_SHORT).show();
        }
    }

    @Subscribe()
    public void getText (BusEventPOJONumber event) {
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
                setUnitMeasurements();
                convertOnDemand();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        binding.spinnerToCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurements();
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
    private void setUnitMeasurements(){
        currencyUnitHandler(getSpinnerValueString(binding.spinnerFromCurrency),binding.currencyFROMShort);
        currencyUnitHandler(getSpinnerValueString(binding.spinnerToCurrency),binding.currencyToShort );
    }

    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item,array);
        binding.spinnerFromCurrency.setAdapter(adapter);
        binding.spinnerToCurrency.setAdapter(adapter);
    }

    private void setStringFormat(double resultDouble){
        NumberFormat formatter = new DecimalFormat("###.####");

        binding.resultCurrency.setText((formatter.format(resultDouble)));
    }


    // app conversion work
    private void convertOnTextChange(){
        getEnteredValue = Double.parseDouble(binding.valueCurrency.getText().toString());
        try {
            if(hm != null){
                Double initRate = hm.get(getSpinnerValueString(binding.spinnerFromCurrency));
                Double targetRate = hm.get(getSpinnerValueString(binding.spinnerToCurrency));
                setStringFormat(Utils.currencyConverter(getEnteredValue,targetRate,initRate));
            }
        }
        catch (Exception e){
            Log.d(" Exception","Exception cached") ;
        }
    }

    private void convertOnDemand(){
        if (TextUtils.isEmpty(binding.valueCurrency.getText().toString())) {
            binding.resultCurrency.setText("");
        }
        else {
            try { //get JSON received values
                Double initRate = hm.get(getSpinnerValueString(binding.spinnerFromCurrency));
                Double targetRate = hm.get(getSpinnerValueString(binding.spinnerToCurrency));
                //use MathParser to calculate value
                Expression value = new Expression(binding.valueCurrency.getText().toString());
                //use calculated value
                setStringFormat(Utils.currencyConverter(value.calculate(), targetRate, initRate));
            }
            catch (Exception e){
                Log.d(" Exception","Exception cached") ;
            }

        }
    }

    private void makeSnackBar(String snackText){
        Snackbar.make(binding.currencyLayout, snackText,Snackbar.LENGTH_SHORT).show();
    }



    // JSON retrieving work

    private void checkDate(){
        UtilsInternetService.getInstance().getJSONApi().getRates().enqueue(new Callback<CurrencyResponseObject>() {
            @Override
            public void onResponse(@NonNull Call<CurrencyResponseObject> call, @NonNull Response<CurrencyResponseObject> response) {
                Log.d("CALLBACK","OK");
                CurrencyResponseObject pojo = response.body ();
                assert pojo != null;
                String date = pojo.date;
                // if user wants to update data, and data on source is equals to data in the phone == data was already saved before
                if (TextUtils.isEmpty(returnDateString(binding.dateView)) || !returnDateString(binding.dateView).equals(date)) {
                    binding.dateView.setText (date);
                    prefManager.setValue (SAVED_DATE, returnDateString (binding.dateView));
                    getCurrencyRates(pojo);
                }
                else if(returnDateString(binding.dateView).equals(date)) {
                    makeSnackBar(getResources().getString(R.string.SameDate));
                }

            }
            @Override
            public void onFailure(@NonNull Call<CurrencyResponseObject> call, @NonNull Throwable t) {
                Log.d("CALLBACK","FAILED");
                t.printStackTrace();
            }
        });
    }

    private void getCurrencyRates(CurrencyResponseObject pojo){
        hm = new HashMap<> ();
        hm.put(getResources().getString(R.string.USD), pojo.object.getRate("USD"));
        hm.put(getResources().getString(R.string.GBP), pojo.object.getRate("GBP"));
        hm.put(getResources().getString(R.string.IDR), pojo.object.getRate("IDR"));
        hm.put(getResources().getString(R.string.PLN), pojo.object.getRate("PLN"));
        hm.put(getResources().getString(R.string.NZD), pojo.object.getRate("NZD"));
        hm.put(getResources().getString(R.string.RUB), pojo.object.getRate("RUB"));
        if(hm != null){
            makeSnackBar (getResources ().getString (R.string.UpdateSuccessful));
        }

        String hashMapString = new Gson ().toJson(hm);
        prefManager.setValue (HASH_MAP,hashMapString);

    }




    }





