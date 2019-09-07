package com.wushanghao.test.Button3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wushanghao.test.Button2.AttentionFragment;
import com.wushanghao.test.Button2.OrdinaryFragment;
import com.wushanghao.test.Button2.RecommendFragment;
import com.wushanghao.test.R;

public class MenuBottomActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private AttentionFragment attentionFragment;
    private RecommendFragment recommendFragment;
    private OrdinaryFragment ordinaryFragment;
    private LinearLayout attentionLayout, recommendLayout, ordinaryLayout;
    private ImageView attentionImageView, recommendImageView, ordinaryImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3);

        initView();
        initListener();
    }

    private void initView() {

        attentionLayout = findViewById(R.id.bottom_attention_layout);
        recommendLayout = findViewById(R.id.bottom_recommend_layout);
        ordinaryLayout = findViewById(R.id.bottom_ordinary_layout);
        attentionImageView = findViewById(R.id.bottom_attention_img);
        recommendImageView = findViewById(R.id.bottom_recommend_img);
        ordinaryImageView = findViewById(R.id.bottom_ordinary_img);

        recommendFragment = new RecommendFragment();
        fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.bottom_frame_layout, recommendFragment);
        transaction.commit();
        recommendImageView.setSelected(true);
    }

    private void initListener() {
        attentionLayout.setOnClickListener(this);
        recommendLayout.setOnClickListener(this);
        ordinaryLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //为了防止出现commit already called错误，所以要重建transaction变量
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有Fragment
        hideAllFragment(transaction);
        //还原ImageView状态
        hideAllImageView();
        switch (v.getId()) {
            case R.id.bottom_attention_layout:
                Toast.makeText(getApplicationContext(), "你点击了关注", Toast.LENGTH_SHORT).show();
                if (attentionFragment == null) {
                    attentionFragment = new AttentionFragment();
                    transaction.add(R.id.bottom_frame_layout, attentionFragment);
                } else {
                    //显示指定Fragment
                    transaction.show(attentionFragment);
                }
                attentionImageView.setSelected(true);
                break;
            case R.id.bottom_recommend_layout:
                Toast.makeText(getApplicationContext(), "你点击了推荐", Toast.LENGTH_SHORT).show();
                if (recommendFragment == null) {
                    recommendFragment = new RecommendFragment();
                    transaction.add(R.id.bottom_frame_layout, recommendFragment);
                } else {
                    transaction.show(recommendFragment);
                }
                recommendImageView.setSelected(true);
                break;
            case R.id.bottom_ordinary_layout:
                Toast.makeText(getApplicationContext(), "你点击了广场", Toast.LENGTH_SHORT).show();
                if (ordinaryFragment == null) {
                    ordinaryFragment = new OrdinaryFragment();
                    transaction.add(R.id.bottom_frame_layout, ordinaryFragment);
                } else {
                    transaction.show(ordinaryFragment);
                }
                ordinaryImageView.setSelected(true);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (attentionFragment != null) {
            transaction.hide(attentionFragment);
        }
        if (recommendFragment != null) {
            transaction.hide(recommendFragment);
        }
        if (ordinaryFragment != null) {
            transaction.hide(ordinaryFragment);
        }
    }

    private void hideAllImageView(){
        attentionImageView.setSelected(false);
        recommendImageView.setSelected(false);
        ordinaryImageView.setSelected(false);
    }

}
