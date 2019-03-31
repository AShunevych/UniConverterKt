package ashunevich.uniconverter20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.temp_button, R.id.area_button, R.id.length_button, R.id.speed_button,
            R.id.time_button, R.id.volume_button, R.id.currency_button, R.id.mass_button,
            R.id.calculator_button, R.id.force_button,R.id.info_button})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.temp_button:
                toConvertor(getResources().getString(R.string.temperature_button));
                break;
            case R.id.area_button:
                toConvertor(getResources().getString(R.string.area_button));
                break;
            case R.id.length_button:
                toConvertor(getResources().getString(R.string.distance_button));
                break;
            case R.id.speed_button:
                toConvertor(getResources().getString(R.string.speed_button));
                break;
            case R.id.time_button:
                toConvertor(getResources().getString(R.string.time_button));
                break;
            case R.id.volume_button:
                toConvertor(getResources().getString(R.string.volume_button));
                break;
            case R.id.currency_button:
                toConvertor(getResources().getString(R.string.currency_button));
                break;
            case R.id.mass_button:
                toConvertor(getResources().getString(R.string.mass_button));
                break;
            case R.id.calculator_button:
                Intent calcInternt = new Intent(MainActivity.this,CalculatorActivity.class);
                startActivity(calcInternt);
                break;
            case R.id.force_button:
                toConvertor(getResources().getString(R.string.force_button));
                break;
            case R.id.info_button:
                Intent infoIntent = new Intent(MainActivity.this,info.class);
                startActivity(infoIntent);
                break;
        }
    }

    protected void toConvertor(String getNameForSend){
        Intent intent = new Intent(MainActivity.this,ConverterActivity.class);
        intent.putExtra("getName",getNameForSend);
        startActivity(intent);
    }

}
