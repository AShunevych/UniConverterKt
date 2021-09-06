package ashunevich.uniconverter20;

import static ashunevich.uniconverter20.Utils.SYMBOL_CHECK;
import static ashunevich.uniconverter20.Utils.SYMBOL_CLEAR;
import static ashunevich.uniconverter20.Utils.SYMBOL_CORRECT;
import static ashunevich.uniconverter20.Utils.appendMinusPlus;
import static ashunevich.uniconverter20.Utils.blockInput;
import static ashunevich.uniconverter20.Utils.clearView;
import static ashunevich.uniconverter20.Utils.correctValue;
import static ashunevich.uniconverter20.Utils.generateViewModel;
import static ashunevich.uniconverter20.Utils.getSpinnerValueString;
import static ashunevich.uniconverter20.Utils.measurementUnitsHandler;
import static ashunevich.uniconverter20.Utils.returnLocale;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ashunevich.conversionlibrary.UnitConverter;

import ashunevich.uniconverter20.databinding.ConverterActivityBinding;
import ashunevich.uniconverter20.ui.AppViewModel;

public class ActivityConverter extends Fragment {

    private ConverterActivityBinding binding;
    private static final int DEFAULT_POS = 0;

    public ActivityConverter() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = ConverterActivityBinding.inflate(inflater, container, false);
        setSpinnerOnTabPositionChange(DEFAULT_POS);
        setUnitMeasurement();
        blockInput(binding.resultView, binding.valueEdit);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initTabPositionViewModel();
        initKeyBoardViewModel();
        setSpinnerListener(binding.spinnerValue);
        setSpinnerListener(binding.spinnerResult);
        addTextWatcher();
        super.onViewCreated(view, savedInstanceState);

    }

    private void initTabPositionViewModel() {
        AppViewModel tabPositionViewModel = generateViewModel(requireActivity());
        tabPositionViewModel.getSelected().observe(getViewLifecycleOwner(), this::setSpinnerOnTabPositionChange);
    }

    private void initKeyBoardViewModel() {
        AppViewModel keyboardViewModel = generateViewModel(requireActivity());
        keyboardViewModel.getPostedNumber().observe(getViewLifecycleOwner(), this::setViewModelTextReceiver);
    }

    private void setAdapter(String[] array) {
        binding.spinnerValue.setAdapter(new ArrayAdapter<>(getContext(),
                R.layout.custom_spinner_item, array));
        binding.spinnerResult.setAdapter(new ArrayAdapter<>(getContext(),
                R.layout.custom_spinner_item, array));
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }


    public void setViewModelTextReceiver(String event) {
        if (event.equals(SYMBOL_CORRECT) || event.equals(SYMBOL_CLEAR) || event.equals(SYMBOL_CHECK)) {
            switch (event) {
                case SYMBOL_CORRECT:
                    correctValue(binding.valueEdit, binding.resultView);
                    break;
                case SYMBOL_CLEAR:
                    clearView(binding.valueEdit, binding.resultView);
                    break;
                case SYMBOL_CHECK:
                    appendMinusPlus(binding.valueEdit);
                    break;
            }
        } else {
            binding.valueEdit.append(event);
        }
    }

    //Filling spinners with values
    private void setSpinnerOnTabPositionChange(int tabPos) {
        switch (tabPos) {
            case 0:
                setAdapter(getResources().getStringArray(R.array.weight));
                break;
            case 1:
                setAdapter(getResources().getStringArray(R.array.length));
                break;
            case 2:
                setAdapter(getResources().getStringArray(R.array.volume));
                break;
            case 3:
                setAdapter(getResources().getStringArray(R.array.area));
                break;
            case 4:
                setAdapter(getResources().getStringArray(R.array.force));
                break;
            case 5:
                setAdapter(getResources().getStringArray(R.array.temperature_array));
                break;
            case 6:
                setAdapter(getResources().getStringArray(R.array.time_array));
                break;
            case 7:
                setAdapter(getResources().getStringArray(R.array.speed));
                break;
        }
    }

    //if user changes unit - it will change measurements and will automatically recalculate result
    private void setSpinnerListener(Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertAndShowValues(returnLocale());
                setUnitMeasurement();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }

    //Auto conversion when user add number to value for convert
    private void addTextWatcher() {
        binding.valueEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (binding.valueEdit.getText().toString().trim().length() > 15) {
                    binding.valueEdit.setText(s.toString().substring(0, 15));
                    binding.valueEdit.setSelection(s.length() - 1);
                    showToast();
                }
                convertAndShowValues(returnLocale());
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

    protected void showToast() {
        Toast.makeText(getActivity(), getResources().getString(R.string.maxNumberReached), Toast.LENGTH_SHORT).show();
    }

    //set units of measurements for value
    private void setUnitMeasurement() {
        measurementUnitsHandler(getSpinnerValueString(binding.spinnerValue), binding.valueUnit);
        measurementUnitsHandler(getSpinnerValueString(binding.spinnerResult), binding.resultUnit);
    }

    private void convertAndShowValues(String activeLocale) {

        if (TextUtils.isEmpty(binding.valueEdit.getText().toString()) | binding.valueEdit.getText().toString().equals("-")) {
            binding.resultView.setText("");
        } else {
            if (activeLocale.equals("українська")) {
                binding.resultView.setText(UnitConverter.ConvertValues_Ukr
                        (getSpinnerValueString(binding.spinnerValue),
                                getSpinnerValueString(binding.spinnerResult),
                                stringToDouble()));
            } else {
                binding.resultView.setText(UnitConverter.ConvertValues
                        (getSpinnerValueString(binding.spinnerValue),
                                getSpinnerValueString(binding.spinnerResult),
                                stringToDouble()));
            }
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private double stringToDouble() {
        return Double.parseDouble(binding.valueEdit.getText().toString());
    }
}

