
package ashunevich.uniconverter20;

import android.support.constraint.ConstraintLayout;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;
import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class Activity_converter_Currency  extends AppCompatActivity {

    @BindView(R.id.spinnerFromCurrency)
    Spinner spinnerValue;
    @BindView(R.id.spinnerToCurrency)
    Spinner spinnerResult;
    @BindView(R.id.valueCurrency)
    EditText valueEdit;
    @BindView(R.id.resultCurrency)
    TextView resultView;
    @BindView(R.id.dateView)
    TextView date;
     @BindView(R.id.currency_FROM_short)
     TextView valueUnit;
     @BindView(R.id.currency_to_short)
     TextView resultUnit;
     @BindView(R.id.currencyLayout)
    ConstraintLayout curLay;

    protected double getEnteredValue;
    protected String getValueSpinnerFrom, getValueSpinnerTo;
    protected HashMap<String, String> hm;
    private final String SAVED_VALUE = "savedValue";
    private final String SAVED_RESULT = "saveResult";
    private String  sDefSystemLanguage ;

    @Override
    public void onStart(){
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(SAVED_VALUE,valueEdit.getText().toString());
        savedInstanceState.putString(SAVED_RESULT,resultView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        ButterKnife.bind(this);
        sDefSystemLanguage = Locale.getDefault().getDisplayLanguage();
        hm = new HashMap<>();
        setAdapter((getResources().getStringArray(R.array.currency)));
        setUnitMeasurement();
        setSpinnersListeners();
        checkConnection();
        addTextWatcher();
        valueEdit.setInputType(InputType.TYPE_NULL);
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        valueEdit.setText(savedInstanceState.getString(SAVED_VALUE));
        resultView.setText(savedInstanceState.getString(SAVED_RESULT));

        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private void checkConnection(){
        if(InternetConnection.checkConnection(this)){
            getJsonDate();
        }
        else{
            Snackbar.make(curLay, getResources().getString(R.string.NoInternetConnection),Snackbar.LENGTH_SHORT).show();
        }
    }

    @Subscribe()
    public void getText (BusPost_Number event) {
        if (event.getNumber().contains("brackets") |
                event.getNumber().contains("clear")|
                event.getNumber().contains("solve")){
            switch (event.getNumber()){
                case "brackets": Activity_converter_Utils.checkBrackets(valueEdit); break;
                case "solve": convertOnDemand();break;
                case "clear": Activity_converter_Utils.clearView(valueEdit,resultView);break;
            }
        }
        else{
            valueEdit.append(event.getNumber());
        }
    }

    @OnClick({R.id.refreshJSONData, R.id.correction})
    public void setViewvClick(View view) {
        switch (view.getId()) {
            case R.id.refreshJSONData:
                checkConnection();break;
            case R.id.correction:
                Activity_converter_Utils.correctValue(valueEdit,resultView);
                break;
        }
    }


    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item,array);
        spinnerValue.setAdapter(adapter);
        spinnerResult.setAdapter(adapter);
    }

    private void setUnitMeasurement(){
        getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
        getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
        Activity_converter_Logic.setUnitsView(getValueSpinnerFrom,valueUnit);
        Activity_converter_Logic.setUnitsView(getValueSpinnerTo,resultUnit );
    }

    //if user changes unit - it will change mesaurments and will automatically recalculate result
    private void setSpinnersListeners(){
        spinnerValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurments();
                convertOnDemand();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        spinnerResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        valueEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                    if (valueEdit.getText().toString().contains("+") |
                            valueEdit.getText().toString().contains("-") |
                            valueEdit.getText().toString().contains("/") |
                            valueEdit.getText().toString().contains("*")|
                            valueEdit.getText().toString().contains("(") |
                            valueEdit.getText().toString().contains(")")|
                            TextUtils.isEmpty(valueEdit.getText().toString())){
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
        getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
        getValueSpinnerTo = spinnerResult.getSelectedItem().toString();

        Activity_converter_Logic.setUnitsView(getValueSpinnerFrom,valueUnit);
        Activity_converter_Logic.setUnitsView(getValueSpinnerTo,resultUnit );
    }

    private void convertOnTextChange(){
        getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
        getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
        getEnteredValue = Double.parseDouble(valueEdit.getText().toString());
        try {
            double initRate = Double.parseDouble(Objects.requireNonNull(hm.get(getValueSpinnerFrom)));
            double targetRate = Double.parseDouble(Objects.requireNonNull(hm.get(getValueSpinnerTo)));
            double resultFinal = ((targetRate * getEnteredValue) / initRate);
            setStringFormat(resultFinal);
        }
        catch (Exception e){
            Log.d(" Exception","exeption catched") ;
        }
    }

    private void convertOnDemand(){
        if (TextUtils.isEmpty(valueEdit.getText().toString())) {
            resultView.setText("");
        }
        else {
            getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
            getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
            try{ //get JSON received values
                   double initRate = Double.parseDouble(Objects.requireNonNull(hm.get(getValueSpinnerFrom)));
                   double targetRate = Double.parseDouble(Objects.requireNonNull(hm.get(getValueSpinnerTo)));
                   //use MathParser to calculate value
                   String getValue = valueEdit.getText().toString();
                   Expression value = new Expression(getValue);
                   double resultDouble = value.calculate();
                   //use calculated value
                   double resultFinal = ((targetRate * resultDouble) / initRate);
                   setStringFormat(resultFinal); }
            catch (Exception e){
                Log.d(" Exception","exeption catched") ;
            }

        }
    }

    private void setStringFormat(double resultDouble){
        NumberFormat formatter = new DecimalFormat("###.####");
        resultView.setText(String.valueOf(formatter.format(resultDouble)));
    }

    private void getJsonDate() {
        String url = "https://api.exchangeratesapi.io/latest";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null){
                    Log.d("Tag", "Response is null");
                }
                //USD,GBP,IDR,PLN,NZD,RUB
                try {
                    assert response != null;
                    String data = response.getString("date");
                    if (date.getText().equals(data)){
                        Snackbar.make(curLay, getResources().getString(R.string.SameDate),Snackbar.LENGTH_SHORT).show();
                    }
                    else{
                        date.setText(data);
                        Snackbar.make(curLay, getResources().getString(R.string.UpdateSuccessful),Snackbar.LENGTH_SHORT).show();
                        getJsonOnlineData();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
            }

        });
        RequestQueue queue = Volley.newRequestQueue(this);
        // Adding request to request queue
        queue.add(jsonObjReq);

    }

    private void getJsonOnlineData() {
        String url = "https://api.exchangeratesapi.io/latest";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //USD,GBP,IDR,PLN,NZD,RUB
                try {
                    JSONObject phone = response.getJSONObject("rates");
                    String USD = phone.getString("USD");
                    String GBP = phone.getString("GBP");
                    String IDR = phone.getString("IDR");
                    String PLN = phone.getString("PLN");
                    String NZD = phone.getString("NZD");
                    String RUB = phone.getString("RUB");
                    //"русский"
                    if(sDefSystemLanguage.equals("українcький")){
                        hm.put("Доллар США", USD);
                        hm.put("Великобританський фунт", GBP);
                        hm.put("Індозенійська Рупія", IDR);
                        hm.put("Польский Злотий", PLN);
                        hm.put("Доллар НЗ", NZD);
                        hm.put("Рубль", RUB);
                    }
                    else{
                        hm.put("United States Dollar", USD );
                        hm.put("Great Britain Pound",GBP);
                        hm.put("Indonesian rupiah", IDR );
                        hm.put("Polish złoty",PLN);
                        hm.put("New Zealand dollar", NZD );
                        hm.put("Russian Ruble",RUB);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        // Adding request to request queue
        queue.add(jsonObjReq);
    }
    }





