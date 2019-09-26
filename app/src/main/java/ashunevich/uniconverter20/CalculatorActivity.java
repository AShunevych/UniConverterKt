package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.mariuszgromada.math.mxparser.*;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    @BindView(R.id.calcValue)  TextView calcValue;
    @BindView(R.id.calcResult) TextView resultSet;

  //  private static final String TAG = "myLogs"
    private final String VALUE_STRING = "valueString";
    private final String RESULT_STRING = "resultString";

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putString(VALUE_STRING,calcValue.getText().toString());
        savedInstanceState.putString(RESULT_STRING,resultSet.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        ButterKnife.bind(this);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        calcValue.setText(savedInstanceState.getString(VALUE_STRING));
        resultSet.setText(savedInstanceState.getString(RESULT_STRING));
        super.onRestoreInstanceState(savedInstanceState);
    }
    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe()
    public void getText (KeyboardPOJO event) {
        calcValue.append(event.getNumber());
    }

    @OnClick({R.id.rightBracket,R.id.leftBracket,
            R.id.calculateResult,R.id.logButton,R.id.percentButton,
            R.id.minusButton,R.id.plusButton,R.id.divideButton,R.id.multiplyButton,
            R.id.sqrRoot,R.id.pov,R.id.exitButton,R.id.clearCalcValue})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.plusButton:
                readAndSetText(getResources().getString(R.string.plus));break;
            case R.id.minusButton:
                readAndSetText(getResources().getString(R.string.minus));break;
            case R.id.divideButton:
                readAndSetText(getResources().getString(R.string.divide_symbol));break;
            case R.id.multiplyButton:
                readAndSetText(getResources().getString(R.string.multiply));break;
            case R.id.calculateResult:
                readAndSolve();break;
            case R.id.clearCalcValue:
                clearText();break;
            case R.id.logButton:
                readAndSetText(getResources().getString(R.string.logStr));break;
            case R.id.pov:
                readAndSetText(getResources().getString(R.string.Exponent));break;
            case R.id.sqrRoot:
                readAndSetText(getResources().getString(R.string.square_root));break;
            case R.id.percentButton:
                readAndSetText((getResources().getString(R.string.percent)));break;
            case R.id.leftBracket:
                readAndSetText((getResources().getString(R.string.leftBracket)));break;
            case R.id.rightBracket:
            readAndSetText((getResources().getString(R.string.rightBracket)));break;
            case R.id.exitButton:
                finish();break;
        }
    }

    private void readAndSetText(String toSet){
        //get text from textView
        String readText = calcValue.getText().toString();
        //add readed text to text that exist
        readText =readText+toSet;
        calcValue.setText(readText);
    }

    private void clearText(){
        resultSet.setText("");
        calcValue.setText("");
    }

    private void readAndSolve(){
      String getValue = calcValue.getText().toString();
      Expression value = new Expression(getValue);
      String getResult = Double.toString(value.calculate());
        resultSet.setText(getResult);
    }



}
