package com.lighters.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mNormalGuideBtn;
    private Button mRoundGuideBtn;
    private Button mRectGuideBtn;
    private Button mMenuGuideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        initListener();
    }

    private void initView() {
        mNormalGuideBtn = (Button) findViewById(R.id.btn_normal_guide);
        mRectGuideBtn = (Button) findViewById(R.id.btn_rect_guide);
        mRoundGuideBtn = (Button) findViewById(R.id.btn_round_guide);
        mMenuGuideBtn = (Button) findViewById(R.id.btn_menu_guide);
    }

    private void initListener() {
        mNormalGuideBtn.setOnClickListener(mClickListener);
        mRectGuideBtn.setOnClickListener(mClickListener);
        mRoundGuideBtn.setOnClickListener(mClickListener);
        mMenuGuideBtn.setOnClickListener(mClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_normal_guide:
                    intent = new Intent(MainActivity.this, GuideNormalActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_round_guide:
                    break;
                case R.id.btn_rect_guide:
                    break;
                case R.id.btn_menu_guide:
                    break;
            }
        }
    };
}
