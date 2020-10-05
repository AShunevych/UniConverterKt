package ashunevich.uniconverter20;


import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.concurrent.TimeUnit;

public abstract class Activity_converter_Utils extends Activity_converter {

    private static final String TAG = "ERROR-" ;

    public Activity_converter_Utils(EditText resultView, EditText valueEdit ){
        this.resultView = resultView;
        this.valueEdit = valueEdit;
    }



    protected static void clearView (EditText valueEdit,TextView resultView){
        resultView.setText("");
        valueEdit.setText("");
    }

    protected static void readAndSolve (EditText valueEdit, TextView resultView){
        if (TextUtils.isEmpty(valueEdit.getText().toString())) {
            resultView.setText("");
        }
         else {
            String getValue = valueEdit.getText().toString();
            Expression value = new Expression(getValue);
            String getResult = Double.toString(value.calculate());
            resultView.setText(getResult);
        }
    }



    protected static void checkBrackets (EditText valueEdit){
        if (valueEdit.getText().toString().contains("(")){
            valueEdit.append(")");
        }
        else{
            valueEdit.append("(");
        }
    }


    protected static void appendMinusPlus(EditText valueEdit){
      int x = valueEdit.getText().length();
       if (x != 15 | valueEdit.getText().toString().contains("-")){
            StringBuilder sb = new StringBuilder();
            if (valueEdit.getText().toString().contains("-")) {
                sb.append(valueEdit.getText().toString());
                sb.deleteCharAt(0);
                valueEdit.setText(sb.toString());
            }
            else {
                valueEdit.setText("-"+valueEdit.getText());
            }
        }
       else {
          
       }

    }

    protected static void correctValue(EditText valueEdit, TextView resultEdit){
        int x = valueEdit.getText().length();
        if (x >0) {
            valueEdit.setText(removeLastChar(valueEdit.getText().toString()));
        }
        else{
            Log.d(TAG,"INVALID INPUT");
            clearView(valueEdit,resultEdit);
        }
    }

    public static String removeLastChar(String str) {
        return removeLastChars(str, 1);
    }

    public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }





}

