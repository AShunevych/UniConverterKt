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

public class KeyboardFragment extends Fragment {
    EventBus bus;

    public KeyboardFragment() {
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
        View view = inflater.inflate(R.layout.keyboard_fragment, container, false);
        bus = EventBus.getDefault();
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.button_decimal, R.id.but_one, R.id.but_two, R.id.but_three,
            R.id.but_four, R.id.but_five, R.id.but_six, R.id.but_seven,
            R.id.button_eight, R.id.but_nine, R.id.button_dzero,
            R.id.button_zero})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
            //numbers buttons
            case R.id.but_one:
                setValue(getResources().getString(R.string.one));
                break;
            case R.id.but_two:
                setValue(getResources().getString(R.string.two));
                break;
            case R.id.but_three:
                setValue(getResources().getString(R.string.three));
                break;
            case R.id.but_four:
                setValue(getResources().getString(R.string.four));
                break;
            case R.id.but_five:
                setValue(getResources().getString(R.string.five));
                break;
            case R.id.but_six:
                setValue(getResources().getString(R.string.six));
                break;
            case R.id.but_seven:
                setValue(getResources().getString(R.string.seven));
                break;
            case R.id.button_eight:
                setValue(getResources().getString(R.string.eight));
                break;
            case R.id.but_nine:
                setValue(getResources().getString(R.string.nine));
                break;
            case R.id.button_zero:
                setValue(getResources().getString(R.string.zero));
                break;
            case R.id.button_dzero:
                setValue(getResources().getString(R.string.dzero));
                break;
            case R.id.button_decimal:
                setValue(getResources().getString(R.string.decimal));
                break;
        }

    }


    public void setValue(String number) {
        bus.post(new KeyboardPOJO(number));
        Log.d("Number",number);
    }
}

