package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import ashunevich.uniconverter20.databinding.CalculatorKeyboardBinding;


public class Activity_calculator_Keyboard extends Fragment {
    EventBus bus;
    private CalculatorKeyboardBinding binding;

    public Activity_calculator_Keyboard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        assert inflater != null;
        binding = CalculatorKeyboardBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        bus = EventBus.getDefault();
        setButtonBindingsCalcKeyboard();
        return view;
    }

    @SuppressWarnings("ConstantConditions")
    private void setButtonBindingsCalcKeyboard(){
        binding.butOne.setOnClickListener
                (v -> postValue(getResources().getString(R.string.one)));
        binding.butTwo.setOnClickListener
                (v -> postValue(getResources().getString(R.string.two)));
        binding.butThree.setOnClickListener
                (v -> postValue(getResources().getString(R.string.three)));
        binding.butFour.setOnClickListener
                (v -> postValue(getResources().getString(R.string.four)));
        binding.butFive.setOnClickListener
                (v -> postValue(getResources().getString(R.string.five)));
        binding.butSix.setOnClickListener
                (v -> postValue(getResources().getString(R.string.six)));
        binding.butSeven.setOnClickListener
                (v -> postValue(getResources().getString(R.string.seven)));
        binding.buttonEight.setOnClickListener
                (v -> postValue(getResources().getString(R.string.eight)));
        binding.butNine.setOnClickListener
                (v -> postValue(getResources().getString(R.string.nine)));
        binding.buttonZero.setOnClickListener
                (v -> postValue(getResources().getString(R.string.zero)));
        binding.buttonDzero.setOnClickListener
                (v -> postValue(getResources().getString(R.string.dzero)));
        binding.buttonDecimal.setOnClickListener
                (v -> postValue(getResources().getString(R.string.decimal)));
        binding.butDuzhky.setOnClickListener
                (v -> postValue("brackets"));
        binding.butPercent.setOnClickListener
                (v -> postValue(getResources().getString(R.string.percent)));
        binding.butDivide.setOnClickListener
                (v -> postValue(getResources().getString(R.string.divide_symbol)));
        binding.butMultiply.setOnClickListener
                (v -> postValue(getResources().getString(R.string.multiply)));
        binding.butMinus.setOnClickListener
                (v -> postValue(getResources().getString(R.string.minus)));
        binding.butPlus.setOnClickListener
                (v -> postValue(getResources().getString(R.string.plus)));
        binding.butEqual.setOnClickListener
                (v -> postValue("solve"));
        binding.butClearView.setOnClickListener
                (v -> postValue("clear"));

    }

    public void postValue(String number) {
        bus.post(new BusPost_Number(number));
        Log.d("Number",number);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
