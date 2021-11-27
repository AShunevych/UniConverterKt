package ashunevich.uniconverter20

import ashunevich.uniconverter20.ui.AppViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.google.android.material.tabs.TabLayout
import android.content.Intent
import android.app.ActivityOptions
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ashunevich.uniconverter20.databinding.MainActivityBinding
import java.util.*

class ActivityMain constructor() : AppCompatActivity() {
    private var binding: MainActivityBinding? = null
    private val mFragmentTitleList: MutableList<String> = ArrayList()
    private var tabPositionModel: AppViewModel? = null
    private var keyboardModel: AppViewModel? = null
    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(getLayoutInflater())
        setContentView(binding!!.getRoot())
        initViewModels()
        mFragmentTitleList.addAll(Arrays.asList(*getResources().getStringArray(R.array.units)))
        initViewPager()
        initTabLayoutMediator()
        initOnClickListeners()
        setTabPositionListener()
        enableButtonOnPositionChange(binding!!.tabLayout.getSelectedTabPosition())
    }

    private fun initViewModels() {
        tabPositionModel = Utils.generateViewModel(this)
        keyboardModel = Utils.generateViewModel(this)
    }

    private fun setTabPositionListener() {
        binding!!.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            public override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            public override fun onPageSelected(position: Int) {
                tabPositionModel!!.select(position)
                enableButtonOnPositionChange(position)
            }

            public override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }

    private fun enableButtonOnPositionChange(pos: Int) {
        if (pos == 5) {
            binding!!.buttonPlusMinus.setEnabled(true)
            binding!!.buttonPlusMinus.setAlpha(1f)
        } else {
            binding!!.buttonPlusMinus.setEnabled(false)
            binding!!.buttonPlusMinus.setAlpha(0.5f)
        }
    }

    private fun initViewPager() {
        val adapter: ViewPagerAdapter = ViewPagerAdapter(
            getSupportFragmentManager(),
            getLifecycle()
        )
        for (i in getResources().getIntArray(R.array.units).indices) {
            adapter.addFragment(ActivityConverter())
        }
        binding!!.viewPager.setAdapter(adapter)
    }

    private fun initTabLayoutMediator() {
        val tabLayoutMediator: TabLayoutMediator = TabLayoutMediator(
            binding!!.tabLayout,
            binding!!.viewPager,
            TabConfigurationStrategy({ tab: TabLayout.Tab, position: Int ->
                tab.setText(mFragmentTitleList.get(position))
            })
        )
        tabLayoutMediator.attach()
    }

    private fun initOnClickListeners() {
        Utils.postTextOnClick(keyboardModel, binding!!.butOne)
        Utils.postTextOnClick(keyboardModel, binding!!.butTwo)
        Utils.postTextOnClick(keyboardModel, binding!!.butThree)
        Utils.postTextOnClick(keyboardModel, binding!!.butFour)
        Utils.postTextOnClick(keyboardModel, binding!!.butFive)
        Utils.postTextOnClick(keyboardModel, binding!!.butSix)
        Utils.postTextOnClick(keyboardModel, binding!!.butSeven)
        Utils.postTextOnClick(keyboardModel, binding!!.buttonEight)
        Utils.postTextOnClick(keyboardModel, binding!!.butNine)
        Utils.postTextOnClick(keyboardModel, binding!!.buttonPlusMinus)
        Utils.postTextOnClick(keyboardModel, binding!!.butClear)
        Utils.postTextOnClick(keyboardModel, binding!!.buttonDecimal)
        Utils.postTextOnClick(keyboardModel, binding!!.butCorrectValue)
        binding!!.calculatorButton.setOnClickListener(View.OnClickListener({ v: View? ->
            startActivity(
                Intent(this@ActivityMain, ActivityCalculator::class.java),
                ActivityOptions.makeSceneTransitionAnimation(this@ActivityMain).toBundle()
            )
        }))
        binding!!.currencyCalculator.setOnClickListener(View.OnClickListener({ v: View? ->
            startActivity(
                Intent(
                    this@ActivityMain,
                    ashunevich.uniconverter20.currencyapi.CurrencyConverter::class.java
                ),
                ActivityOptions.makeSceneTransitionAnimation(this@ActivityMain).toBundle()
            )
        }))
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        fun addFragment(fragment: Fragment) {
            mFragmentList.add(fragment)
        }

        public override fun createFragment(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        public override fun getItemCount(): Int {
            return mFragmentList.size
        }
    }
}