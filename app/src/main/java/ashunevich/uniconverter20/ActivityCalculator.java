package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import ashunevich.uniconverter20.databinding.CalculatorActivityBinding;


public class ActivityCalculator extends AppCompatActivity {


    private CalculatorActivityBinding binding;
    private final String VALUE_STRING = "valueString";
    private final String RESULT_STRING = "resultString";

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
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
        View view = binding.getRoot();
        setContentView(view);
        binding.correction.setOnClickListener(v -> Utils.correctValue(binding.calcValue,binding.calcResult));
       setUtils();
    }

    private void setUtils(){
        binding.calcValue.setCursorVisible(true);
        binding.calcValue.setInputType(InputType.TYPE_NULL);
        binding.correction.setOnClickListener(v -> Utils.correctValue(binding.calcValue,binding.calcResult));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        binding.calcValue.setText(savedInstanceState.getString(VALUE_STRING));
        binding.calcResult.setText(savedInstanceState.getString(RESULT_STRING));
        super.onRestoreInstanceState(savedInstanceState);
    }
    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe()
    public void getText (BusEventPOJONumber event) {
        if (event.getNumber().contains("brackets") |
                event.getNumber().contains("clear")|   event.getNumber().contains("solve")){
            switch (event.getNumber()){
                case "brackets": Utils.checkBrackets(binding.calcValue); break;
                case "solve": Utils.readAndSolve(binding.calcValue,binding.calcResult);break;
                case "clear": Utils.clearView(binding.calcValue,binding.calcResult);break;
            }
        }
        else{
            binding.calcValue.append(event.getNumber());
        }
    }

}
