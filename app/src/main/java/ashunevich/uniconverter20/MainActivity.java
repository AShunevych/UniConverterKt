package ashunevich.uniconverter20;


import android.content.Intent;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainActivity) ConstraintLayout mainActivity;
 //7c8483 //color 274156
    public static boolean mIsNightMode = false;
    DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogFragment = new DialogActivity();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.temp_button, R.id.area_button, R.id.length_button, R.id.speed_button,
            R.id.time_button, R.id.volume_button, R.id.currency_button, R.id.mass_button,
            R.id.calculator_button, R.id.force_button,R.id.sphere_button,R.id.pipe_button})
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
                /*
            case R.id.decScience_button:
                Intent infoIntent = new Intent(MainActivity.this, DecimalScientificConverter.class);
                startActivity(infoIntent);
                break;
                */
            case R.id.sphere_button:
                Intent sphereIntent = new Intent(MainActivity.this, CalculatorSphereActivity.class);
                sphereIntent.putExtra("getName",getResources().getString(R.string.circleSphere_button));
                startActivity(sphereIntent);
                break;
            case R.id.pipe_button:
                Intent intent = new Intent(MainActivity.this, PipeRecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }

    protected void toConvertor(String setIntentName){
        Intent intent = new Intent(MainActivity.this,ConverterActivity.class);
        intent.putExtra("getName",setIntentName);
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
              dialogFragment.show(getSupportFragmentManager(),"Dialog");
               return true;
           case R.id.exit_but:
                finish();
               return true;
            case R.id.themeSet:
                lightOffOn();
                return  true;
           default:
               return super.onOptionsItemSelected(item);
       }
    }

    private void lightOffOn(){
        if(!mIsNightMode){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            mIsNightMode = true;
        }
        else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            mIsNightMode= false;
        }
    }
}




