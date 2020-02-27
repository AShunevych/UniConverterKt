package ashunevich.uniconverter20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
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

import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConverterActivity  extends AppCompatActivity {

    @BindView(R.id.spinner_value)
    Spinner spinnerValue;
    @BindView(R.id.spinner_result)
    Spinner spinnerResult;
    @BindView(R.id.valueEdit)
    EditText valueEdit;
    @BindView(R.id.resultView)
    TextView resultView;
    @BindView(R.id.valueName)
    TextView valueName;
     @BindView(R.id.keybordChanger)
     Switch aSwitch;
     @BindView(R.id.clearButton)
    Button clearButton;
     @BindView(R.id.exitButton)
     ImageButton finishThisActivity;
     @BindView(R.id.valueUnit)
     TextView valueUnit;
     @BindView(R.id.resultUnit)
     TextView resultUnit;

    protected double getEnteredValue;
    protected String getValueSpinnerFrom, getValueSpinnerTo;
    protected HashMap<String, String> hm;
    private String SAVED_INTENT_NAME = "intentName";
    private final String SAVED_VALUE = "savedValue";
    private final String SAVED_RESULT = "saveResult";
    protected String stringOff, stringOn;
    private String  sDefSystemLanguage ;
    Context mContext = this;

    @Override
    public void onStart(){
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(SAVED_INTENT_NAME,valueName.getText().toString());
        savedInstanceState.putString(SAVED_VALUE,valueEdit.getText().toString());
        savedInstanceState.putString(SAVED_RESULT,resultView.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_activity_alt);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String GET_NAME = intent.getStringExtra("getName");
        sDefSystemLanguage = Locale.getDefault().getDisplayLanguage();
        hm = new HashMap<String, String>();
        valueName.setText(GET_NAME);

        setClicksListener();
        setSpinnersAdapters();
        addTextWatcher();
        setSpinnersListeners();
        setUnitMeasurments();
        //switch listener
        ConverterUtils.changeSwitch(aSwitch,valueEdit,getResources().getString(R.string.keyboardOff),
                getResources().getString(R.string.keyboardOn),mContext);
    }

    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.custom_spinner_item,array);
        spinnerValue.setAdapter(adapter);
        spinnerResult.setAdapter(adapter);
    }

    private void setClicksListener(){
        //Listeners for finish activity and clear buttons
        finishThisActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConverterUtils.clearView(valueEdit,resultView);
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        valueName.setText(savedInstanceState.getString(SAVED_INTENT_NAME));
        valueEdit.setText(savedInstanceState.getString(SAVED_VALUE));
        resultView.setText(savedInstanceState.getString(SAVED_RESULT));
        setSpinnersAdapters();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe()
    public void getText (KeyboardPOJO event) {
        valueEdit.append(event.getNumber());
    }

    //Filling spinners with values
    private void setSpinnersAdapters() {
        String activeValue = valueName.getText().toString();

        if (activeValue.equals(getResources().getString(R.string.mass_button))){
            setAdapter(getResources().getStringArray(R.array.weight));
        }
        else if (activeValue.equals(getResources().getString(R.string.area_button))){
            setAdapter(getResources().getStringArray(R.array.area));
        }
        else if (activeValue.equals(getResources().getString(R.string.time_button))){
            setAdapter(getResources().getStringArray(R.array.time_array));
        }
        else if (activeValue.equals(getResources().getString(R.string.distance_button))){
            setAdapter(getResources().getStringArray(R.array.length));
        }
        else if (activeValue.equals(getResources().getString(R.string.volume_button))){
            setAdapter(getResources().getStringArray(R.array.volume));
        }
        else if (activeValue.equals(getResources().getString(R.string.temperature_button))){
            setAdapter(getResources().getStringArray(R.array.temperature_array));
        }
        else if (activeValue.equals(getResources().getString(R.string.force_button))){
            setAdapter(getResources().getStringArray(R.array.force));
        }
        else if (activeValue.equals(getResources().getString(R.string.currency_button))){
            getJsonOnlineData();
            setAdapter(getResources().getStringArray(R.array.currency));
        }
        else if (activeValue.equals(getResources().getString(R.string.speed_button))){
            setAdapter(getResources().getStringArray(R.array.speed));
        }
    }

    //if user changes unit - it will change mesaurments and will automatically recalculate result
    private void setSpinnersListeners(){
        spinnerValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertAndShowValues(sDefSystemLanguage);
                setUnitMeasurments();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        spinnerResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurments();
                convertAndShowValues(sDefSystemLanguage);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }});

    }
    //Auto convertion mecahnism when user add number to value for convert
    private void addTextWatcher() {

        valueEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                convertAndShowValues(sDefSystemLanguage);
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

    //retrieve online API data for currency convertion
    private void getJsonOnlineData() {
        String url = "https://api.exchangeratesapi.io/latest";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("Tag", response.toString());
                //USD,GBP,IDR,PLN,NZD,RUB
                try {
                    JSONObject phone = response.getJSONObject("rates");
                    String USD = phone.getString("USD");
                    String GBP = phone.getString("GBP");
                    String IDR = phone.getString("IDR");
                    String PLN = phone.getString("PLN");
                    String NZD = phone.getString("NZD");
                    String RUB = phone.getString("RUB");
                   if(sDefSystemLanguage.equals("русский")){
                       hm.put("Доллар США/USD", USD);
                       hm.put("Великобританський фунт/GBP", GBP);
                       hm.put("Індозенійська Рупія/IPR", IDR);
                       hm.put("Польский Злотий/PLN", PLN);
                       hm.put("Доллар НЗ/NZD", NZD);
                       hm.put("Рубль/RUB", RUB);
                   }
                   else{
                       hm.put("United States Dollar/USD", USD );
                       hm.put("Great Britain Pound/GBP",GBP);
                       hm.put("Indonesian rupiah/IPR", IDR );
                       hm.put("Polish złoty/PLN",PLN);
                       hm.put("New Zealand dollar/NZD", NZD );
                       hm.put("Russian Ruble/RUB",RUB);
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

    //set units of mesaurments for value
    private void setUnitMeasurments(){
        getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
        getValueSpinnerTo = spinnerResult.getSelectedItem().toString();

        ConverterLogic.setUnitsView(getValueSpinnerFrom,valueUnit);
        ConverterLogic.setUnitsView(getValueSpinnerTo,resultUnit );
    }

    //convertion mechanism
    private void convertAndShowValues(String activeLocale){
        if (TextUtils.isEmpty(valueEdit.getText().toString())) {
            resultView.setText("");
        }
        else {
            getEnteredValue = Double.parseDouble(valueEdit.getText().toString());
            getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
            getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
            if (valueName.getText().toString().equals(getResources().getString(R.string.currency_button))) {
                ConverterLogic.convertCurrencyData(getValueSpinnerFrom, getValueSpinnerTo, getEnteredValue, resultView, hm);
            } else {
                //"русский" //"українська"
                 if (activeLocale.equals("русский")){
                     ConverterLogic.ConvertValues_Ukr(getValueSpinnerFrom, getValueSpinnerTo, getEnteredValue, resultView);
                }
                else{
                     ConverterLogic.ConvertValues(getValueSpinnerFrom, getValueSpinnerTo, getEnteredValue, resultView);
                 }
            }
        }
    }


}
