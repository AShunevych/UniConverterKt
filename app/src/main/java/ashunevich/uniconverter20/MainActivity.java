package ashunevich.uniconverter20;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
      //  SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
    //    SharedPreferences.Editor editor = pref.edit();
    }

    @OnClick({R.id.temp_button, R.id.area_button, R.id.length_button, R.id.speed_button,
            R.id.time_button, R.id.volume_button, R.id.currency_button, R.id.mass_button,
            R.id.calculator_button, R.id.force_button,R.id.decScience_button,R.id.sphere_button})
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
            case R.id.decScience_button:
                Intent infoIntent = new Intent(MainActivity.this, DecimalScientificConverter.class);
                startActivity(infoIntent);
                break;
            case R.id.sphere_button:
                Intent sphereIntent = new Intent(MainActivity.this,SphereActivity.class);
                sphereIntent.putExtra("getName",getResources().getString(R.string.circleSphere_button));
                startActivity(sphereIntent);
                break;
        }
    }

    protected void toConvertor(String getNameForSend){
        Intent intent = new Intent(MainActivity.this,ConverterActivity.class);
        intent.putExtra("getName",getNameForSend);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.about_id:
               infoDialog();
               return true;
           case R.id.themeSelector:
              // infoDialog();
               return true;
           case R.id.exit_but:
                finish();
               return true;
           default:
               return super.onOptionsItemSelected(item);

       }
    }

    private void infoDialog(){
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
       String API_Provided =getResources().getString(R.string.api_info);
   String Calc_Provided = getResources().getString(R.string.calc_info);
         String API_URL = "OpenRates.io";
         String CALC_URL = "mathparser.org";

        builder.setTitle(getResources().getString(R.string.about)).
                setMessage(API_Provided+":"+"\n" +
                        API_URL+"\n"
                        + Calc_Provided+
                        ":"+ "\n"+CALC_URL )
                .setCancelable(false)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
