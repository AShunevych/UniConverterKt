package ashunevich.uniconverter20;

import android.content.Context;
import android.text.InputType;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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

