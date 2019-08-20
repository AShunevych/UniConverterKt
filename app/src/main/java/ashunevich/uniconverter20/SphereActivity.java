package ashunevich.uniconverter20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SphereActivity extends AppCompatActivity {

    @BindView(R.id.circleAreaValue)  TextView circleArea;
    @BindView(R.id.diamValue)  TextView circleDiameter;
    @BindView(R.id.circValue)  TextView circleCirc;
    @BindView(R.id.radValue) TextView circleRad;
    @BindView(R.id.sphereAreaValue) TextView sphereArea;
    @BindView(R.id.sphereVolumeValue) TextView sphereVolume;
    @BindView(R.id.hemiAreaValue) TextView hemiArea;
    @BindView(R.id.hemiVolumeValue) TextView hemiVolume;
    @BindView(R.id.value_spinner) Spinner sphereSpinner;
    @BindView(R.id.valSpinner) Spinner valSpinner;
    @BindView(R.id.valueEdit) EditText value;
    @BindView(R.id.valueName) TextView valueName;
    @BindView(R.id.clearButton) Button clear;
    @BindView(R.id.exitButton) Button exit;
    @BindView(R.id.areaID) TextView areaID;
    @BindView(R.id.diamID) TextView diamID;
    @BindView(R.id.circID) TextView circID;
    @BindView(R.id.radiusID) TextView radiusID;
    @BindView(R.id.sphAreaID) TextView sphAreaID;
    @BindView(R.id.hmareaID) TextView hmareaID;
    @BindView(R.id.volumeSID) TextView volumeSID;
    @BindView(R.id.volumehsID) TextView volumehsID;

    protected ArrayAdapter<String> dataParam, valParam;
    protected String SPINNER_STRING,VAL_SPINNER_STRING ,
            SAVED_VALUE,SAVED_VALUE_SPINNER,SAVED_VALUE_PARAM,
            SAVED_LOCALE_PARAM, sDefSystemLanguage;
    protected double getEnteredValue;


    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putDouble(SAVED_VALUE,Double.valueOf(value.getText().toString()));
        savedInstanceState.putInt(SAVED_VALUE_SPINNER,sphereSpinner.getSelectedItemPosition());
        savedInstanceState.putInt(SAVED_VALUE_PARAM,valSpinner.getSelectedItemPosition());
        savedInstanceState.putString(SAVED_LOCALE_PARAM,sDefSystemLanguage);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angle_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String GET_NAME = intent.getStringExtra("getName");
        sDefSystemLanguage = Locale.getDefault().getDisplayLanguage();
        valueName.setText(GET_NAME);
        dataParam = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.circlesAndSpheres));
        sphereSpinner.setAdapter(dataParam);
        valParam= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.valuess));
        valSpinner.setAdapter(valParam);
        spinnerListener();
        valSpinnerListener();
        addTextWatcher();


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
            value.setText(String.valueOf(savedInstanceState.getDouble(SAVED_VALUE)));
            sphereSpinner.setSelection(savedInstanceState.getInt(SAVED_VALUE_SPINNER));
            valSpinner.setSelection(savedInstanceState.getInt(SAVED_VALUE_PARAM));
            sDefSystemLanguage = savedInstanceState.getString(SAVED_LOCALE_PARAM);
        super.onRestoreInstanceState(savedInstanceState);
    }


    private void valSpinnerListener(){
        valSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                VAL_SPINNER_STRING = valSpinner.getSelectedItem().toString();
                if(VAL_SPINNER_STRING.equals(areaID.getText().toString())){
                    setValuesAccViews(VAL_SPINNER_STRING);
                }
                else{
                    setValuesAccViews(VAL_SPINNER_STRING);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
    }



    private void spinnerListener(){
        sphereSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (TextUtils.isEmpty(value.getText().toString())){
                    clear();
                }
                else {
                    convertValues();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

    }

    private void addTextWatcher() {

        value.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(value.getText().toString())){
                    clear();
                }
                else {
                    convertValues();
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


    private void clear (){
        circleRad.setText("");
        circleDiameter.setText("");
        circleArea.setText("");
        circleCirc.setText("");
        sphereArea.setText("");
        sphereVolume.setText("");
        hemiArea.setText("");
        hemiVolume.setText("");
    }

    private void setValuesAccViews(String string){

        String two = getResources().getString(R.string.top2);
        String three = getResources().getString(R.string.top3);

            areaID.setText(String.valueOf(string+two));
            diamID.setText(string);
            circID.setText(string);
            radiusID.setText(string);
            sphAreaID.setText(String.valueOf(string+two));
            hmareaID.setText(String.valueOf(string+two));
            volumeSID.setText(String.valueOf(string+three));
            volumehsID.setText(String.valueOf(string+three));
    }

    private void convertValues() {
        switch (sDefSystemLanguage) {
           //"русский"
            //"українська"
            case "русский":
                if (TextUtils.isEmpty(value.getText().toString())) {
                    Log.d("Value:","Empty");
                    clear();
                }
                else {
                    getEnteredValue = Double.parseDouble(value.getText().toString());
                    SPINNER_STRING = sphereSpinner.getSelectedItem().toString();
                    SphereAdapter_ukr.findParam(getEnteredValue, SPINNER_STRING, circleArea, circleDiameter, circleCirc, circleRad, sphereArea, sphereVolume,
                            hemiArea, hemiVolume);
                }
                break;
            case "English":
                if (TextUtils.isEmpty(value.getText().toString())) {
                    Log.d("Value:","Empty");
                }
                else {
                    getEnteredValue = Double.parseDouble(value.getText().toString());
                    SPINNER_STRING = sphereSpinner.getSelectedItem().toString();
                    SphereAdapter.findParam(getEnteredValue, SPINNER_STRING, circleArea, circleDiameter, circleCirc, circleRad, sphereArea, sphereVolume,
                            hemiArea, hemiVolume);
                    break;
                }
        }
    }
    }




