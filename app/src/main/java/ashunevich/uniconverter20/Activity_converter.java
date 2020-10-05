package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;

import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;

import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_converter extends Fragment {

    @BindView(R.id.spinner_value)
    Spinner spinnerValue;
    @BindView(R.id.spinner_result)
    Spinner spinnerResult;
    @BindView(R.id.valueEdit)
    EditText valueEdit;
    @BindView(R.id.resultView)
    EditText resultView;
     @BindView(R.id.valueUnit)
     TextView valueUnit;
     @BindView(R.id.resultUnit)
     TextView resultUnit;

    protected double getEnteredValue;
    protected String getValueSpinnerFrom, getValueSpinnerTo;
    private final String SAVED_VALUE = "savedValue";
    private final String SAVED_RESULT = "saveResult";
    private String  sDefSystemLanguage;
    private int tabPos;
    protected HashMap<String, String> hm;

    EventBus bus;
    public Activity_converter() {
        // Required empty public constructor
    }

    @Override
    public void onStart(){
        if (!EventBus.getDefault().isRegistered(this)) { EventBus.getDefault().register(this); }
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @Subscribe
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.converter_activity_alt, container, false);
        sDefSystemLanguage = Locale.getDefault().getDisplayLanguage();
        bus = EventBus.getDefault();
        ButterKnife.bind(this, view);
        blockInput(valueEdit,resultView);
        setAdapter(getResources().getStringArray(R.array.weight));
        addTextWatcher();
        setSpinnersListeners();
        setUnitMeasurement();
        return view;
    }





    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.custom_spinner_item,array);
        spinnerValue.setAdapter(adapter);
        spinnerResult.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void getText (BusPost_Tab_Position event) {
            setSpinnerAdapterOnBusEvent(event.getPos());
            Activity_converter_Utils.clearView(valueEdit,resultView);
    }

    @Subscribe()
    public void getCalculatorNumber(BusPost_Number event) {
        if (event.getNumber().contains("check") | event.getNumber().contains("correct") |
               event.getNumber().contains("clear")){
           switch (event.getNumber()){
               case "check":
                       Activity_converter_Utils.appendMinusPlus(valueEdit);break;
               case "correct": Activity_converter_Utils.correctValue(valueEdit,resultView);break;
               case "clear": Activity_converter_Utils.clearView(valueEdit,resultView);break;
           }
       }
         else{
                valueEdit.append(event.getNumber());
            }
        }


    //Filling spinners with values
    private void setSpinnerAdapterOnBusEvent(int activeValue) {
            switch (activeValue) {
                case 0: tabPos=0;setAdapter(getResources().getStringArray(R.array.weight));  break;
                case 1: tabPos=1;setAdapter(getResources().getStringArray(R.array.length)); break;
                case 2: tabPos=2;setAdapter(getResources().getStringArray(R.array.volume)); break;
                case 3: tabPos=3;setAdapter(getResources().getStringArray(R.array.area)); break;
                case 4: tabPos=4;setAdapter(getResources().getStringArray(R.array.force)); break;
                case 5: tabPos=5;setAdapter(getResources().getStringArray(R.array.temperature_array)); break;
                case 6: tabPos=6;setAdapter(getResources().getStringArray(R.array.time_array)); break;
                case 7: tabPos=7;setAdapter(getResources().getStringArray(R.array.speed)); break;
                case 8: tabPos=7;setAdapter(getResources().getStringArray(R.array.circlesAndSpheres)); break;
        }

        }

    //if user changes unit - it will change mesaurments and will automatically recalculate result
    private void setSpinnersListeners(){
        spinnerValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertAndShowValues(sDefSystemLanguage);
                setUnitMeasurement();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        spinnerResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurement();
                convertAndShowValues(sDefSystemLanguage);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }});

    }



    //Auto convertion when user add number to value for convert
    private void addTextWatcher() {
            valueEdit.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    if(valueEdit.getText().toString().trim().length() > 15){
                        valueEdit.setText(s.toString().substring(0, 15));
                        valueEdit.setSelection(s.length()-1);
                        showToast();
                    }
                    else{
                        convertAndShowValues(sDefSystemLanguage);
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


        protected void showToast(){
            Toast.makeText(getActivity(), getResources().getString(R.string.maxNumberReached), Toast.LENGTH_SHORT).show();
        }

    //set units of mesaurments for value
   private void setUnitMeasurement(){
        getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
        getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
        Activity_converter_Logic.setUnitsView(getValueSpinnerFrom,valueUnit);
        Activity_converter_Logic.setUnitsView(getValueSpinnerTo,resultUnit );
    }

    private void blockInput( EditText first, EditText second){
        first.setInputType(InputType.TYPE_NULL);
        second.setInputType(InputType.TYPE_NULL);
    }

    private void convertAndShowValues(String activeLocale){

        if (TextUtils.isEmpty(valueEdit.getText().toString()) | valueEdit.getText().toString().equals("-")) {
            resultView.setText("");
        }
        else {
            getEnteredValue = Double.parseDouble(valueEdit.getText().toString());
            getValueSpinnerFrom = spinnerValue.getSelectedItem().toString();
            getValueSpinnerTo = spinnerResult.getSelectedItem().toString();
            //activeLocale.equals("русский") |
               if (activeLocale.equals("українcький")){
                   Activity_converter_Logic.ConvertValues_Ukr(getValueSpinnerFrom, getValueSpinnerTo, getEnteredValue, resultView);
               }
               else{
                   Activity_converter_Logic.ConvertValues(getValueSpinnerFrom, getValueSpinnerTo, getEnteredValue, resultView);
               }
           }

        }





    @Override
    public void onDetach() {
        if (EventBus.getDefault().isRegistered(this)) { EventBus.getDefault().unregister(this); }
        super.onDetach();
    }
}

