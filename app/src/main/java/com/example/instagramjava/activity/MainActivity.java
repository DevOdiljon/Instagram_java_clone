package com.example.instagramjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.instagramjava.R;
import com.example.instagramjava.adapter.ViewPagerAdapter;
import com.example.instagramjava.fragment.FavoriteFragment;
import com.example.instagramjava.fragment.HomeFragment;
import com.example.instagramjava.fragment.ProfileFragment;
import com.example.instagramjava.fragment.SearchFragment;
import com.example.instagramjava.fragment.UploadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Contoins view pager with 5 fragments in MainActivity
 * and pages can be controlled by ButtomNavigationView
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private Integer index = 0;
    HomeFragment homeFragment;
    UploadFragment uploadFragment;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_search:
                    viewPager.setCurrentItem(1);
                case R.id.navigation_upload:
                    viewPager.setCurrentItem(2);
                case R.id.navigation_favorite:
                    viewPager.setCurrentItem(3);
                case R.id.navigation_profile:
                    viewPager.setCurrentItem(4);
            }
            return true;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                index = position;
                bottomNavigationView.getMenu().getItem(index).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

       //Home and Upload Fragments are global for communication purpose
       homeFragment = new HomeFragment();
       uploadFragment = new UploadFragment();
       setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment);
        adapter.addFragment(new SearchFragment());
        adapter.addFragment(uploadFragment);
        adapter.addFragment(new FavoriteFragment());
        adapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(adapter);
    }
}