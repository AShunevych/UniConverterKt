package ashunevich.uniconverter20;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
                    univesalToast.show();
                    valueEdit.setEnabled(false);
                }
                else{
                    Toast  univesalToast = Toast.makeText(mContext,stringOn,Toast.LENGTH_SHORT);
                    univesalToast.show();
                    valueEdit.setEnabled(true);
                }
            }
        });
    }
    protected static void clearView (EditText valueEdit,TextView resultView){
        resultView.setText("");
        valueEdit.setText("");
    }



}

