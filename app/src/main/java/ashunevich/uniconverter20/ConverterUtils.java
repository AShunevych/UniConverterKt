package ashunevich.uniconverter20;

import android.content.Context;
import android.text.InputType;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public abstract class ConverterUtils extends ConverterActivity {

    public ConverterUtils(TextView resultView, EditText valueEdit, Switch aSwitch, Context mContext,
                          String stringOff, String stringOn ){

        this.resultView = resultView;
        this.valueEdit = valueEdit;
        this.aSwitch = aSwitch;
        this.mContext= mContext;
        this.stringOff = stringOff;
        this.stringOn = stringOn;
    }

    protected static void changeSwitch (Switch aSwitch, final EditText valueEdit, final String stringOff, final String stringOn,
                                        final Context mContext){

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast univesalToast = Toast.makeText(mContext,stringOff,Toast.LENGTH_SHORT);
                    delayAction();
                    univesalToast.show();
                    valueEdit.setInputType(InputType.TYPE_NULL);
                }
                else{
                    Toast  univesalToast = Toast.makeText(mContext,stringOn,Toast.LENGTH_SHORT);
                    univesalToast.show();
                    //valueEdit.setEnabled(true);
                    rebootEditText(valueEdit);
                    valueEdit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL| InputType.TYPE_NUMBER_FLAG_SIGNED);
                }
            }
        });
    }

    private static void rebootEditText(EditText editText){
            editText.setEnabled(false);
            delayAction();
            editText.setEnabled(true);
            editText.setFocusable(true);
    }

    private static void delayAction(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    protected static void clearView (EditText valueEdit,TextView resultView){
        resultView.setText("");
        valueEdit.setText("");
    }



}

