package ashunevich.uniconverter20;

import android.os.Bundle;
import android.text.InputType;

import androidx.appcompat.app.AppCompatActivity;
import ashunevich.uniconverter20.databinding.CalculatorActivityBinding;
import ashunevich.uniconverter20.ui.AppViewModel;

import static ashunevich.uniconverter20.Utils.SYMBOL_BRACKETS;
import static ashunevich.uniconverter20.Utils.SYMBOL_CLEAR;
import static ashunevich.uniconverter20.Utils.SYMBOL_SOLVE;
import static ashunevich.uniconverter20.Utils.checkBrackets;
import static ashunevich.uniconverter20.Utils.clearView;
import static ashunevich.uniconverter20.Utils.generateViewModel;
import static ashunevich.uniconverter20.Utils.readAndSolve;


public class ActivityCalculator extends AppCompatActivity {

    private CalculatorActivityBinding binding;
    private final String VALUE_STRING = "valueString";
    private final String RESULT_STRING = "resultString";

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(VALUE_STRING,binding.calcValue.getText().toString());
        savedInstanceState.putString(RESULT_STRING,binding.calcResult.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = CalculatorActivityBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    setUtils();
    initViewModel();
    }

    private void setUtils(){
        binding.calcValue.setCursorVisible(true);
        binding.calcValue.setInputType(InputType.TYPE_NULL);
    }

    private void initViewModel(){
        AppViewModel model = generateViewModel(this);
        model.getPostedNumber ().observe (this, this::getText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        binding.calcValue.setText(savedInstanceState.getString(VALUE_STRING));
        binding.calcResult.setText(savedInstanceState.getString(RESULT_STRING));
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void getText (String event) {
        if(event.equals (SYMBOL_BRACKETS)|| event.equals (SYMBOL_SOLVE)|| event.equals (SYMBOL_CLEAR)){
            switch (event){
                case SYMBOL_BRACKETS: checkBrackets(binding.calcValue);break;
                case SYMBOL_SOLVE: readAndSolve(binding.calcValue,binding.calcResult);break;
                case SYMBOL_CLEAR: clearView(binding.calcValue,binding.calcResult);break;
            }
        }
        else{
            binding.calcValue.append(event);
        }
    }
}
