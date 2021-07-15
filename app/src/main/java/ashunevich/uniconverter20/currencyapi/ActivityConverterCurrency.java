
package ashunevich.uniconverter20.currencyapi;


import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import ashunevich.uniconverter20.R;
import ashunevich.uniconverter20.Utils;
import ashunevich.uniconverter20.databinding.CurrencyActivityBinding;
import ashunevich.uniconverter20.ui.AppViewModel;

import static ashunevich.uniconverter20.Utils.SAVED_RESULT;
import static ashunevich.uniconverter20.Utils.SAVED_VALUE;
import static ashunevich.uniconverter20.Utils.SYMBOL_BRACKETS;
import static ashunevich.uniconverter20.Utils.SYMBOL_CLEAR;
import static ashunevich.uniconverter20.Utils.SYMBOL_SOLVE;
import static ashunevich.uniconverter20.Utils.checkBrackets;
import static ashunevich.uniconverter20.Utils.clearView;
import static ashunevich.uniconverter20.Utils.correctValue;
import static ashunevich.uniconverter20.Utils.currencyUnitHandler;
import static ashunevich.uniconverter20.Utils.generateViewModel;
import static ashunevich.uniconverter20.Utils.getSpinnerValueString;
import static ashunevich.uniconverter20.Utils.returnDateString;

public class ActivityConverterCurrency extends AppCompatActivity implements CurrencyContract.CurrencyView {

     
     private CurrencyActivityBinding binding;
    protected double getEnteredValue;
    protected HashMap<String, Double> hm;

    @Override
    public void onStart(){
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
        setButtonBindings_ConverterCurrency();
        setAdapter((getResources().getStringArray(R.array.currency)));
        setUnitMeasurements();
        setSpinnersListeners(binding.spinnerFromCurrency);
        setSpinnersListeners(binding.spinnerToCurrency);
        if(TextUtils.isEmpty(returnDateString(binding.dateView))){
            checkConnection();
        }


        AppViewModel model = generateViewModel (this);
        model.getPostedNumber ().observe (this, this::getText);



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
        super.onStop();
    }

    private void checkConnection(){
        if(!CurrencyInternetService.checkConnection(this)){
            Snackbar.make(binding.currencyLayout, getResources().getString(R.string.NoInternetConnection),Snackbar.LENGTH_SHORT).show();
        }
        else{
            Snackbar.make(binding.currencyLayout, getResources().getString(R.string.PostitiveInternetConnection),Snackbar.LENGTH_SHORT).show();
            CurrencyContract.CurrencyPresenter presenter = new CurrencyPresenterImp (this, new CurrencyInteractorImpl ());
            presenter.requestDataFromServer ();
        }
    }

    protected void getText (String event) {
        if(event.equals (SYMBOL_BRACKETS)|| event.equals (SYMBOL_SOLVE)|| event.equals (SYMBOL_CLEAR)){
            switch (event){
                case SYMBOL_BRACKETS: checkBrackets (binding.valueCurrency); break;
                case SYMBOL_SOLVE: convertOnDemand();break;
                case SYMBOL_CLEAR: clearView (binding.valueCurrency,binding.resultCurrency);break;
            }
        }
        else{
            binding.valueCurrency.append(event);
        }
    }

    //app Listeners
    private void setButtonBindings_ConverterCurrency(){
        binding.refreshJSONData.setOnClickListener(v -> checkConnection());
        binding.correction.setOnClickListener(v -> correctValue (binding.valueCurrency,binding.resultCurrency));
    }

    //if user changes unit - it will change measurements and will automatically recalculate result
    private void setSpinnersListeners(Spinner spinner) {
        spinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurements ();
                convertOnDemand ();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
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
                e.printStackTrace ();
                Log.d(" Exception","Exception cached") ;
            }

        }
    }

    private void makeSnackBar(String snackText){
        Snackbar.make(binding.currencyLayout, snackText,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        makeSnackBar("Response Failed!");
    }

    @Override
    public void parseDataFromResponseToHashmap(CurrencyResponseObject receivedObj) {
        binding.dateView.setText (receivedObj.date);

        hm = new HashMap<> ();
        hm.put (getResources ().getString (R.string.USD), receivedObj.object.getRate ("USD"));
        hm.put (getResources ().getString (R.string.GBP), receivedObj.object.getRate ("GBP"));
        hm.put (getResources ().getString (R.string.IDR), receivedObj.object.getRate ("IDR"));
        hm.put (getResources ().getString (R.string.PLN), receivedObj.object.getRate ("PLN"));
        hm.put (getResources ().getString (R.string.NZD), receivedObj.object.getRate ("NZD"));
        hm.put (getResources ().getString (R.string.RUB), receivedObj.object.getRate ("RUB"));
        if(hm.isEmpty ()){
            makeSnackBar("Fail!");
        }
        else {
            makeSnackBar("Success!");
        }
    }
}





