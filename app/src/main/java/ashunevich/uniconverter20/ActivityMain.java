package ashunevich.uniconverter20;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayoutMediator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import ashunevich.uniconverter20.databinding.MainActivityBinding;

@SuppressWarnings("ConstantConditions")
public class ActivityMain extends AppCompatActivity {

   private MainActivityBinding binding;
   EventBus bus;
   private final List<String> mFragmentTitleList = new ArrayList<> ();
   public TabPositionViewModel model;


    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mFragmentTitleList.addAll(Arrays.asList(getResources().getStringArray(R.array.units)));
        setViewPage();
        setTabLayoutMediator ();
        setButtonBindings();

        binding.currencyCalculator.setVisibility (View.GONE);//temporary
        bus = EventBus.getDefault();
        getTabPosition(binding.viewPager);
        model = new ViewModelProvider (this).get(TabPositionViewModel.class);

        alphaButtonState(false,0.5f);
    }



    static class ViewPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        private ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return mFragmentList.size();
        }


    }

    private void getTabPosition(final ViewPager2 viewPager){
        viewPager.registerOnPageChangeCallback (new ViewPager2.OnPageChangeCallback () {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled (position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                model.select (position);
                setAlpha(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged (state);
            }
        });
    }

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
        ViewPagerAdapter adapter = new ViewPagerAdapter (getSupportFragmentManager (),
               getLifecycle ());

        for(int i = 0; i<getResources ().getIntArray (R.array.units).length;i++){
            adapter.addFragment (new ActivityConverter ());
        }

      binding.viewPager.setAdapter(adapter);
    }

    private void setTabLayoutMediator(){
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) ->
                tab.setText(mFragmentTitleList.get(position)));
        tabLayoutMediator.attach();
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
        binding.butCorrectValue.setOnClickListener
                (v -> sendValue("correction"));
        binding.buttonDecimal.setOnClickListener
                (v -> sendValue(getResources().getString(R.string.decimal)));
        binding.calculatorButton.setOnClickListener
                (v -> startActivity(new Intent(ActivityMain.this, ActivityCalculator.class),
                        ActivityOptions.makeSceneTransitionAnimation(ActivityMain.this).toBundle()));
        /*
        binding.currencyCalculator.setOnClickListener
                (v -> startActivity(new Intent(ActivityMain.this, ActivityConverterCurrency.class),
                        ActivityOptions.makeSceneTransitionAnimation(ActivityMain.this).toBundle()));
         */
    }

    public void sendValue(String value) {
        bus.post(new BusEventPOJONumber (value));
    }
    }


