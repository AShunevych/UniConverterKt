package ashunevich.uniconverter20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Main extends AppCompatActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    EventBus bus;
    @BindView((R.id.button_plus_minus)) Button plusMinus;

    @BindView(R.id.calculator_button)
    Button calc;
    @BindView(R.id.currency_calculator)
    Button currency;

    @Override

    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activty_new);
        ButterKnife.bind(this);
        String [] tabNames = new String[] {getResources().getString(R.string.mass_button),
                getResources().getString(R.string.distance_button), getResources().getString(R.string.volume_button),
                getResources().getString(R.string.sq),getResources().getString(R.string.force_button),
                getResources().getString(R.string.temperature_button),getResources().getString(R.string.time_button),
                getResources().getString(R.string.speed_button)}; //getResources().getString(R.string.circleSphere_button
        bus = EventBus.getDefault();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (String tabName : tabNames) {
            adapter.addFragment(new Activity_converter(), tabName);
        }
        plusMinus.setEnabled(false);
        plusMinus.setAlpha(0.5f);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        getTabPostion(viewPager);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }

    private void getTabPostion(final  ViewPager viewPager){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int pos = tabLayout.getSelectedTabPosition();
                Log.d("TAB NUMBER ----", String.valueOf(pos));
                bus.post(new BusPost_Tab_Position(pos));
                setButtonStatus(pos);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void setButtonStatus(int pos){
        if (pos == 5){
            plusMinus.setEnabled(true);
            plusMinus.setAlpha(1.0f);
        }
        else{
            plusMinus.setEnabled(false);
            plusMinus.setAlpha(0.5f);
        }
    }

    //R.id.currency_calculator
    @OnClick({R.id.button_plus_minus, R.id.but_one, R.id.but_two, R.id.but_three,
            R.id.but_four, R.id.but_five, R.id.but_six, R.id.but_seven,
            R.id.button_eight, R.id.but_nine,R.id.button_decimal,
            R.id.button_zero,R.id.but_clear,R.id.but_correct,R.id.calculator_button})
    public void setViewOnClickEvent(View view) {
        switch (view.getId()) {
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
            case R.id.button_plus_minus:
                setValue("check");
                break;
            case R.id.but_clear:
                setValue("correct");
                break;
            case R.id.but_correct:
                setValue("clear");
                break;
            case R.id.button_decimal:
                setValue(getResources().getString(R.string.decimal));
                break;
            case R.id.calculator_button:
                Intent intentCalc = new Intent(Activity_Main.this, Activity_calculator.class);
                startActivity(intentCalc);
        }
    }

        @OnClick({R.id.currency_calculator})
        public void setViewvClick(View view) {
            if (view.getId() == R.id.currency_calculator) {
                Intent intentCurrency = new Intent(Activity_Main.this, Activity_converter_Currency.class);
                startActivity(intentCurrency);
            }
    }

    public void setValue(String number) {
        bus.post(new BusPost_Number(number));
    }




    }


