package com.lighters.library.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by david on 16/1/5.
 */
public class BubbleGuideLayout extends LinearLayout {

    public BubbleGuideLayout(Context context){
        this(context, null);;
    }

    public BubbleGuideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        // 添加当前内容的子View,内容View跟确认View
    }



}
