package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Editable;


import android.text.TextUtils;
import android.text.TextWatcher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Locale;

import ashunevich.uniconverter20.databinding.ConverterActivityBinding;

import static ashunevich.uniconverter20.Activity_converter_Utils.blockInput;

public class Activity_converter extends Fragment {

    private ConverterActivityBinding binding;
    private String  sDefSystemLanguage;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ConverterActivityBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        sDefSystemLanguage = Locale.getDefault().getDisplayLanguage();
        bus = EventBus.getDefault();
        blockInput(binding.resultView,binding.valueEdit);
        setAdapter(getResources().getStringArray(R.array.weight));
        addTextWatcher();
        setSpinnersListeners();
        setUnitMeasurement();
        return view;
    }

    private void setAdapter( String [] array ){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.custom_spinner_item,array);
        binding.spinnerValue.setAdapter(adapter);
        binding.spinnerResult.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    @Subscribe
    public void getText (BusPost_Tab_Position event) {
            setSpinnerAdapterOnBusEvent(event.getPos());
            Activity_converter_Utils.clearView(binding.valueEdit,binding.resultView);
    }

    @Subscribe()
    public void getCalculatorNumber(BusPost_Number event) {
        if (event.getNumber().contains("check") | event.getNumber().contains("correction") |
               event.getNumber().contains("clear")){
           switch (event.getNumber()){
               case "check": Activity_converter_Utils.appendMinusPlus(binding.valueEdit);break;
               case "correction": Activity_converter_Utils.correctValue(binding.valueEdit,binding.resultView);break;
               case "clear": Activity_converter_Utils.clearView(binding.valueEdit,binding.resultView);break;
           }
       }
         else{
            binding.valueEdit.append(event.getNumber());
            }
        }

    //Filling spinners with values
    private void setSpinnerAdapterOnBusEvent(int activeValue) {
            switch (activeValue) {
                case 0: setAdapter(getResources().getStringArray(R.array.weight));  break;
                case 1: setAdapter(getResources().getStringArray(R.array.length)); break;
                case 2: setAdapter(getResources().getStringArray(R.array.volume)); break;
                case 3: setAdapter(getResources().getStringArray(R.array.area)); break;
                case 4: setAdapter(getResources().getStringArray(R.array.force)); break;
                case 5: setAdapter(getResources().getStringArray(R.array.temperature_array)); break;
                case 6: setAdapter(getResources().getStringArray(R.array.time_array)); break;
                case 7: setAdapter(getResources().getStringArray(R.array.speed)); break;
                case 8: setAdapter(getResources().getStringArray(R.array.circlesAndSpheres)); break;
        } }

    //if user changes unit - it will change mesaurments and will automatically recalculate result
    private void setSpinnersListeners(){
        binding.spinnerValue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertAndShowValues(sDefSystemLanguage);
                setUnitMeasurement();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        binding.spinnerResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setUnitMeasurement();
                convertAndShowValues(sDefSystemLanguage);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }});

    }

    //Auto conversion when user add number to value for convert
    private void addTextWatcher() {
        binding.valueEdit.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    if(binding.valueEdit.getText().toString().trim().length() > 15){
                        binding.valueEdit.setText(s.toString().substring(0, 15));
                        binding.valueEdit.setSelection(s.length()-1);
                        showToast();
                    }
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

    protected void showToast(){
            Toast.makeText(getActivity(), getResources().getString(R.string.maxNumberReached), Toast.LENGTH_SHORT).show();
        }

    //set units of mesaurments for value
    private void setUnitMeasurement(){
        Activity_converter_Logic.setUnitsView(binding.spinnerValue.getSelectedItem().toString(),binding.valueUnit);
        Activity_converter_Logic.setUnitsView(binding.spinnerResult.getSelectedItem().toString(),binding.resultUnit );
    }

    private void convertAndShowValues(String activeLocale){

        if(TextUtils.isEmpty(binding.valueEdit.getText().toString()) | binding.valueEdit.getText().toString().equals("-")){
            binding.resultView.setText("");
        }
        else {
               if (activeLocale.equals("українська")){
                   Activity_converter_Logic.ConvertValues_Ukr(binding.spinnerValue.getSelectedItem().toString(),
                           binding.spinnerResult.getSelectedItem().toString(),
                           Double.parseDouble(binding.valueEdit.getText().toString()),
                           binding.resultView);
               }
               else{
                   Activity_converter_Logic.ConvertValues(binding.spinnerValue.getSelectedItem().toString(),
                           binding.spinnerResult.getSelectedItem().toString(),
                           Double.parseDouble(binding.valueEdit.getText().toString()),
                           binding.resultView);
               }
           }

        }

    @Override
    public void onDetach() {
        if (EventBus.getDefault().isRegistered(this)) { EventBus.getDefault().unregister(this); }
        super.onDetach();
    }
}

