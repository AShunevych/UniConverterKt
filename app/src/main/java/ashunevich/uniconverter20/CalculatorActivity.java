package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

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


    @OnClick({R.id.decimal, R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six, R.id.seven,
            R.id.eight, R.id.nine, R.id.dzero,R.id.clearCalcValue,
            R.id.zero,R.id.rightBracket,R.id.leftBracket,
            R.id.calculateResult,R.id.logButton,R.id.percentButton,
            R.id.minusButton,R.id.plusButton,R.id.divideButton,R.id.multiplyButton,
            R.id.sqrRoot,R.id.pov,R.id.exitButton})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            //numbers buttons
            case R.id.one:
                readAndSetText(getResources().getString(R.string.one));break;
            case R.id.two:
                readAndSetText(getResources().getString(R.string.two));break;
            case R.id.three:
                readAndSetText(getResources().getString(R.string.three));break;
            case R.id.four:
                readAndSetText(getResources().getString(R.string.four));break;
            case R.id.five:
                readAndSetText(getResources().getString(R.string.five));break;
            case R.id.six:
                readAndSetText(getResources().getString(R.string.six));break;
            case R.id.seven:
                readAndSetText(getResources().getString(R.string.seven));break;
            case R.id.eight:
                readAndSetText(getResources().getString(R.string.eight));break;
            case R.id.nine:
                readAndSetText(getResources().getString(R.string.nine));break;
            case R.id.zero:
                readAndSetText(getResources().getString(R.string.zero));break;
            case R.id.dzero:
                readAndSetText(getResources().getString(R.string.dzero));break;
                //math operation buttons
            case R.id.decimal:
                readAndSetText(getResources().getString(R.string.decimal));break;
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
