package com.lighters.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.lighters.library.guide.BubbleGuide;
import com.lighters.library.guide.BubbleGuideOption;
import com.lighters.library.guide.enumtype.BubbleAlignType;
import com.lighters.library.guide.enumtype.BubbleArrowDirection;

/**
 * Created by alighters on 16/4/29.
 * Email: huangdiv5@gmail.com
 * GitHub: https://github.com/alighters
 */
public class GuideNormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_normal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.guide_normal);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });
        showGuide();
    }

    private void showGuide() {
        BubbleGuideOption guideOption = new BubbleGuideOption.Builder()
            .alignType(BubbleAlignType.RIGHT)
            .arrowDirection(BubbleArrowDirection.BOTTOM)
            .confirmText("I Got it")
            .tipText("This a normal button")
            .bubbleColor(Color.WHITE)
            .arrowWidth(20)
            .roundCornerSize(50)
            .arrowHeight(20)
            .build();
        new BubbleGuide.Builder(this)
            .container(findViewById(android.R.id.content))
            .guide(R.id.fab)
            .option(guideOption)
            .build().show();
    }
}
