package com.wushanghao.test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wushanghao.test.Button1.SlidingActivity;
import com.wushanghao.test.Button2.TabSlidingActivity;
import com.wushanghao.test.Button3.MenuBottomActivity;

public class MainActivity extends Activity {

    private Button slidingFinish , slidingTab ,bottomTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initView(){

        slidingFinish = findViewById(R.id.slidingFinish);
        slidingTab = findViewById(R.id.slidingTab);
        bottomTab = findViewById(R.id.bottomTab);

    }

    private void initListener(){

        slidingFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SlidingActivity.class);
                startActivity(intent);
            }
        });
        slidingTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TabSlidingActivity.class);
                startActivity(intent);
            }
        });
        bottomTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuBottomActivity.class);
                startActivity(intent);
            }
        });

    }

}
