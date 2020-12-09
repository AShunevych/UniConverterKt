package ashunevich.uniconverter20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.List;

import ashunevich.uniconverter20.databinding.MainActivityBinding;

@SuppressWarnings("ConstantConditions")
public class Activity_Main extends AppCompatActivity {

    private MainActivityBinding binding;
    EventBus bus;

    protected void onStart() {
        super.onStart();
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setViewPage();
        setButtonBindings();
        bus = EventBus.getDefault();
        alphaButtonState(false,0.5f);
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
                int pos = binding.tabLayout.getSelectedTabPosition();
                Log.d("TAB NUMBER ----", String.valueOf(pos));
                bus.post(new BusPost_Tab_Position(pos));
                setAlpha(pos);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @SuppressWarnings("ConstantConditions")
    private void alphaButtonState(Boolean buttonStatus,float alpha){
     binding.buttonPlusMinus.setEnabled(buttonStatus);
       binding.buttonPlusMinus.setAlpha(alpha);
    }

    private void setAlpha(int pos){
        if (pos == 5){
            alphaButtonState(true,1.0f);
        }
        else{
            alphaButtonState(false,0.5f);
        }
    }

    private void setViewPage(){
        String [] tabNames = new String[] {getResources().getString(R.string.mass_button),
                getResources().getString(R.string.distance_button), getResources().getString(R.string.volume_button),
                getResources().getString(R.string.sq),getResources().getString(R.string.force_button),
                getResources().getString(R.string.temperature_button),getResources().getString(R.string.time_button),
                getResources().getString(R.string.speed_button)}; //getResources().getString(R.string.circleSphere_button)
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (String tabName : tabNames) {
            adapter.addFragment(new Activity_converter(), tabName);
        }
      binding.viewPager.setAdapter(adapter);
     binding.tabLayout.setupWithViewPager(binding.viewPager);
        getTabPostion(binding.viewPager);
    }

    private void setButtonBindings(){
        binding.butOne.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.one)));
        binding.butTwo.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.two)));
        binding.butThree.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.three)));
        binding.butFour.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.four)));
        binding.butFive.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.five)));
        binding.butSix.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.six)));
        binding.butSeven.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.seven)));
        binding.buttonEight.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.eight)));
        binding.butNine.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.nine)));
        binding.buttonZero.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.zero)));
        binding.buttonPlusMinus.setOnClickListener
                (v -> sendValue("check"));
        binding.butClear.setOnClickListener
                (v -> sendValue("clear"));
        binding.butCorrect.setOnClickListener
                (v -> sendValue("correction"));
        binding.buttonDecimal.setOnClickListener
                (v -> sendValue("correction"));
        binding.calculatorButton.setOnClickListener
                (v -> startActivity(new Intent(Activity_Main.this, Activity_calculator.class)));
        binding.currencyCalculator.setOnClickListener
                (v -> startActivity(new Intent(Activity_Main.this, Activity_converter_Currency.class)));
    }

    public void sendValue(String value) {
        bus.post(new BusPost_Number(value));
    }
    }


