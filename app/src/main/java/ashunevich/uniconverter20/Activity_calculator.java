package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.mariuszgromada.math.mxparser.Expression;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_calculator extends AppCompatActivity {

    @BindView(R.id.calcValue) EditText calcValue;
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
        calcValue.setCursorVisible(true);

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
    public void getText (BusPost_Number event) {
        if (event.getNumber().contains("brackets") |
                event.getNumber().contains("clear")|   event.getNumber().contains("solve")){
            switch (event.getNumber()){
                case "brackets": Activity_converter_Utils.checkBrackets(calcValue); break;
                case "solve": Activity_converter_Utils.readAndSolve(calcValue,resultSet);break;
                case "clear": Activity_converter_Utils.clearView(calcValue,resultSet);break;
            }
        }
        else{
            calcValue.append(event.getNumber());
        }
    }

    public void checkBrackets (EditText valueEdit){
        if (valueEdit.getText().toString().contains("(")){
            valueEdit.append(")");
        }
        else{
            valueEdit.append("(");
        }
    }

    @OnClick({R.id.correction})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.correction:
                Activity_converter_Utils.correctValue(calcValue,resultSet);break;
        }
    }



    private void readAndSolve(){
      String getValue = calcValue.getText().toString();
      Expression value = new Expression(getValue);
      String getResult = Double.toString(value.calculate());
        resultSet.setText(getResult);
    }



}
