package ashunevich.uniconverter20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import ashunevich.uniconverter20.databinding.CalculatorKeyboardBinding;

import static ashunevich.uniconverter20.Utils.postTextOnClick;


public class FragmentKeyboard extends Fragment {
    private CalculatorKeyboardBinding binding;
    AppViewModel model;

    public FragmentKeyboard() {
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
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        model = new ViewModelProvider (requireActivity ()).get (AppViewModel.class);
        setButtonBindingsCalcKeyboard();
        super.onViewCreated (view, savedInstanceState);
    }

    private void setButtonBindingsCalcKeyboard(){
        postTextOnClick (model,binding.butOne);
        postTextOnClick (model,binding.butTwo);
        postTextOnClick (model,binding.butThree);
        postTextOnClick (model,binding.butFour);
        postTextOnClick (model,binding.butFive);
        postTextOnClick (model,binding.butSix);
        postTextOnClick (model,binding.butSeven);
        postTextOnClick (model,binding.buttonEight);
        postTextOnClick (model,binding.butNine);
        postTextOnClick (model,binding.buttonZero);
        postTextOnClick (model,binding.buttonDzero);
        postTextOnClick (model,binding.buttonDecimal);
        postTextOnClick (model,binding.butDuzhky);
        postTextOnClick (model,binding.butPercent);
        postTextOnClick (model,binding.butDivide);
        postTextOnClick (model,binding.butMultiply);
        postTextOnClick (model,binding.butMinus);
        postTextOnClick (model,binding.butPlus);
        postTextOnClick (model,binding.butSolve);
        postTextOnClick (model,binding.butClearView);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
