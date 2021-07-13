package ashunevich.uniconverter20;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import ashunevich.uniconverter20.databinding.MainActivityBinding;
import ashunevich.uniconverter20.ui.AppViewModel;

import static ashunevich.uniconverter20.Utils.generateViewModel;
import static ashunevich.uniconverter20.Utils.postTextOnClick;


public class ActivityMain extends AppCompatActivity {

   private MainActivityBinding binding;
   private final List<String> mFragmentTitleList = new ArrayList<> ();
   private AppViewModel tabPositionModel,keyboardModel;


    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViewModels();
        mFragmentTitleList.addAll(Arrays.asList(getResources().getStringArray(R.array.units)));
        initViewPager ();
        initTabLayoutMediator();
        initOnClickListeners ();

        binding.currencyCalculator.setVisibility (View.GONE);//temporary
        setTabPositionListener ();

        enableButtonOnPositionChange(binding.tabLayout.getSelectedTabPosition ());
    }

    private void initViewModels(){
        tabPositionModel = generateViewModel (this);
        keyboardModel = generateViewModel (this);
    }

    private void setTabPositionListener(){
        binding.viewPager.registerOnPageChangeCallback (new ViewPager2.OnPageChangeCallback () {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled (position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                tabPositionModel.select (position);
                enableButtonOnPositionChange (position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged (state);
            }
        });
    }

    private void enableButtonOnPositionChange(int pos){
        if (pos == 5){
            binding.buttonPlusMinus.setEnabled(true);
            binding.buttonPlusMinus.setAlpha(1);
        }
        else{
            binding.buttonPlusMinus.setEnabled(false);
            binding.buttonPlusMinus.setAlpha(0.5f);
        }
    }

    private void initViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter (getSupportFragmentManager (),
               getLifecycle ());

        for(int i = 0; i<getResources ().getIntArray (R.array.units).length;i++){
            adapter.addFragment (new ActivityConverter ());
        }

      binding.viewPager.setAdapter(adapter);
    }

    private void initTabLayoutMediator(){
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) ->
                tab.setText(mFragmentTitleList.get(position)));
        tabLayoutMediator.attach();
    }

    private void initOnClickListeners(){
        postTextOnClick (keyboardModel,binding.butOne);
        postTextOnClick (keyboardModel,binding.butTwo);
        postTextOnClick (keyboardModel,binding.butThree);
        postTextOnClick (keyboardModel,binding.butFour);
        postTextOnClick (keyboardModel,binding.butFive);
        postTextOnClick (keyboardModel,binding.butSix);
        postTextOnClick (keyboardModel,binding.butSeven);
        postTextOnClick (keyboardModel,binding.buttonEight);
        postTextOnClick (keyboardModel,binding.butNine);
        postTextOnClick (keyboardModel,binding.buttonPlusMinus);
        postTextOnClick (keyboardModel,binding.butClear);
        postTextOnClick (keyboardModel,binding.buttonDecimal);
        postTextOnClick (keyboardModel,binding.butCorrectValue);

        binding.calculatorButton.setOnClickListener
                (v -> startActivity(new Intent(ActivityMain.this, ActivityCalculator.class),
                        ActivityOptions.makeSceneTransitionAnimation(ActivityMain.this).toBundle()));
        /*
        binding.currencyCalculator.setOnClickListener
                (v -> startActivity(new Intent(ActivityMain.this, ActivityConverterCurrency.class),
                        ActivityOptions.makeSceneTransitionAnimation(ActivityMain.this).toBundle()));
         */
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

    }


