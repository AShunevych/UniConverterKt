package ashunevich.uniconverter20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DecimalScientificConverter extends AppCompatActivity {

    @BindView(R.id.eplusDecValue)
    EditText eplusDecValue;
    @BindView(R.id.eplusExponent)
    EditText eplusExponent;
    @BindView(R.id.eminusExponent)
    EditText eminusExponent;
    @BindView(R.id.epminusDecValue)
    EditText eminusDecValue;
    @BindView(R.id.decimalValue)
    EditText decimalValue;
    @BindView(R.id.eplusResult)
    TextView eplusResult;
    @BindView(R.id.eMinusResult)
    TextView eMinusResult;
    @BindView(R.id.scientificDecResult)
    TextView scientificDecResult;
    @BindView(R.id.eMinusText)
    TextView eMinusText;
    @BindView(R.id.ePlusText)
    TextView ePlusText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sciecedecimal_activity);
        ButterKnife.bind(this);
        eplusTextWatcher();
        eminusWatcher();
        decimalConvWatcher();
    }

    @OnClick({R.id.clearEPlus, R.id.clearEMinus, R.id.clearDecimal,R.id.exitButton})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.clearEPlus:
                setClear(eplusResult, eplusExponent,eplusDecValue);
                break;
            case R.id.clearEMinus:
                setClear(eMinusResult,eminusExponent,eminusDecValue);
                break;
            case R.id.clearDecimal:
                scientificDecResult.setText("");
                decimalValue.setText("");
                break;
            case R.id.exitButton:
                finish();break;
        }

    }

    private void setClear (TextView textView,EditText editText, EditText editText2){
        textView.setText("");
        editText.setText("");
        editText2.setText("");
    }

    private void eplusTextWatcher() {
        eplusExponent.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                formatEplus(eplusResult,eplusExponent,eplusDecValue);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
}
    private void eminusWatcher() {
        eminusExponent.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                formatEMinus(eMinusResult,eminusExponent,eminusDecValue);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }

    private void decimalConvWatcher() {
        decimalValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                formatDecimalScienc(decimalValue,scientificDecResult);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }


    private  void formatEMinus (TextView resultText,EditText exponentText, EditText decimalText){
        NumberFormat eMinusFormatter = new DecimalFormat("###.##############");

        String eMinusToFormat= decimalText.getText().toString()+
                eMinusText.getText().toString()+
                exponentText.getText().toString();


        try {
            resultText.setText(String.valueOf(eMinusFormatter.format(Double.valueOf(eMinusToFormat))));
            Log.e("eMinus = ",eMinusToFormat);
        }
       catch (Exception e ){
            Log.e("Exception caught", "eMinus exception");
       }
    }

    private void formatEplus (TextView resultText,EditText exponentText, EditText decimalText){
        NumberFormat ePlusFormatter = new DecimalFormat("#########.#");
        String ePlusToFormat = decimalText.getText().toString()+
                ePlusText.getText().toString()+
                exponentText.getText().toString();

        try {
            Log.d("ePlus = ", ePlusToFormat);
            resultText.setText(String.valueOf(ePlusFormatter.format(Double.valueOf(ePlusToFormat))));
        }
        catch (Exception e ){
            Log.e("Exception caught", "ePlue exception");
        }
    }
    private void formatDecimalScienc ( EditText decimalText,TextView resultText){
        NumberFormat decimalToScienceFormatter = new DecimalFormat("0.######E0");

        try {
            Log.d("ePlus = ", decimalText.getText().toString());
            resultText.setText(String.valueOf(decimalToScienceFormatter.format(Double.valueOf(decimalText.getText().toString()))));
        }
        catch (Exception e ){
            Log.e("Exception caught", "decToScience exception");
        }
    }


}

