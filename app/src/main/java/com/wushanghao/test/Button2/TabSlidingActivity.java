package com.wushanghao.test.Button2;

import android.support.design.widget.TabLayout;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.wushanghao.test.R;

public class TabSlidingActivity extends AppCompatActivity {

    private TabLayout tabTabLayout;
    private ViewPager tabViewPager;
    private TabFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);

        initView();
        initPager();
    }

    private void initView(){
        tabTabLayout = findViewById(R.id.tab_layout);
        tabViewPager = findViewById(R.id.tab_viewpager);
        //创建选项卡，三个
        tabTabLayout.addTab(tabTabLayout.newTab().setText(R.string.tab_attention));
        tabTabLayout.addTab(tabTabLayout.newTab().setText(R.string.tab_recommend));
        tabTabLayout.addTab(tabTabLayout.newTab().setText(R.string.tab_ordinary));

    }

    private void initPager(){
        adapter = new TabFragmentAdapter(getSupportFragmentManager());
        //应用适配器之后，ViewPager就可以左右滑动了
        tabViewPager.setAdapter(adapter);
        //把ViewPager与TabLayout绑在一起，左右滑动ViewPager的时候TabLayout也动
        tabViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabTabLayout));
        //点击TabLayout选项卡的时候
        tabTabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //当Tab被选中时，ViewPager显示相应的Fragment
                tabViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
