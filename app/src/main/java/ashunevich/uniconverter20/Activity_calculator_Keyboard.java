package ashunevich.uniconverter20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_calculator_Keyboard extends Fragment {
    EventBus bus;

    public Activity_calculator_Keyboard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.calculator_keyboard,container,false);
        bus = EventBus.getDefault();
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.button_decimal, R.id.but_one,
            R.id.but_two, R.id.but_three,
            R.id.but_four, R.id.but_five,
            R.id.but_six, R.id.but_seven,
            R.id.button_eight, R.id.but_nine,
            R.id.button_zero,R.id.button_dzero,
            R.id.but_duzhky,R.id.but_percent,
            R.id.but_divide,R.id.but_multiply,
            R.id.but_minus,R.id.but_plus,
            R.id.but_equal,R.id.but_clearView
    })
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            //numbers buttons
            case R.id.but_one: postValue(getResources().getString(R.string.one));break;
            case R.id.but_two: postValue(getResources().getString(R.string.two));break;
            case R.id.but_three: postValue(getResources().getString(R.string.three));break;
            case R.id.but_four: postValue(getResources().getString(R.string.four));break;
            case R.id.but_five: postValue(getResources().getString(R.string.five));break;
            case R.id.but_six: postValue(getResources().getString(R.string.six));break;
            case R.id.but_seven: postValue(getResources().getString(R.string.seven));break;
            case R.id.button_eight: postValue(getResources().getString(R.string.eight));break;
            case R.id.but_nine: postValue(getResources().getString(R.string.nine));break;
            case R.id.button_zero: postValue(getResources().getString(R.string.zero));break;
            case R.id.button_decimal: postValue(getResources().getString(R.string.decimal));break;
            case R.id.button_dzero: postValue(getResources().getString(R.string.dzero));break;
            case R.id.but_duzhky: postValue("brackets");break;
            case R.id.but_percent: postValue(getResources().getString(R.string.percent));break;
            case R.id.but_divide: postValue(getResources().getString(R.string.divide_symbol));break;
            case R.id.but_multiply: postValue(getResources().getString(R.string.multiply));break;
            case R.id.but_minus: postValue(getResources().getString(R.string.minus));break;
            case R.id.but_plus: postValue(getResources().getString(R.string.plus));break;
            case R.id.but_equal: postValue("solve");break;
            case R.id.but_clearView: postValue("clear");
        }
    }

    public void postValue(String number) {
        bus.post(new BusPost_Number(number));
        Log.d("Number",number);
    }
}
