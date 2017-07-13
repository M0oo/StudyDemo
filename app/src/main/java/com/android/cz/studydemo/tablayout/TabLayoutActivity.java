package com.android.cz.studydemo.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.android.cz.studydemo.R;

public class TabLayoutActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

       viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String title[] = new String[]{"第一页","第二页","第三页"};

            @Override
            public Fragment getItem(int position) {
                FirstFrament frament =  new FirstFrament();
                Bundle bundle = new Bundle();
                switch (position){
                    case 0:
                        bundle.putString("content","第一页");
                        frament.setArguments(bundle);
                        return  frament;
                    case 1:
                        bundle.putString("content","第2页");
                        frament.setArguments(bundle);
                        return  frament;
                    case 2:
                        bundle.putString("content","第3页");
                        frament.setArguments(bundle);
                        return frament;
                }
                return frament;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }

            @Override
            public int getCount() {
                return title.length;
            }
        });

        WindowManager windowManager = getWindowManager();
        Display windowDisplay = windowManager.getDefaultDisplay();
        int windowWidth = windowDisplay.getWidth();
        int tabwidth = windowWidth/3;
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(ContextCompat.getDrawable(this,R.drawable.ic_menu_camera));
        tabLayout.getTabAt(1).setIcon(ContextCompat.getDrawable(this,R.drawable.ic_menu_gallery));
        tabLayout .getTabAt(2).setIcon(ContextCompat.getDrawable(this,R.drawable.ic_menu_manage));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab == tabLayout.getTabAt(0)){
                    tabLayout.getTabAt(0).setIcon(getDrawable(R.mipmap.ic_launcher));
                    viewPager.setCurrentItem(0);
                }else if(tab == tabLayout.getTabAt(1)){
                    tabLayout.getTabAt(1).setIcon(getDrawable(R.mipmap.ic_launcher));
                    viewPager.setCurrentItem(1);
                }else if(tab == tabLayout.getTabAt(2)){
                    tabLayout.getTabAt(2).setIcon(getDrawable(R.mipmap.ic_launcher));
                    viewPager.setCurrentItem(2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab == tabLayout.getTabAt(0)){
                    tabLayout.getTabAt(0).setIcon(getDrawable(R.drawable.ic_menu_camera));
                }else if(tab == tabLayout.getTabAt(1)){
                    tabLayout.getTabAt(1).setIcon(getDrawable(R.drawable.ic_menu_gallery));
                }else if(tab == tabLayout.getTabAt(2)){
                    tabLayout.getTabAt(2).setIcon(getDrawable(R.drawable.ic_menu_manage));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
