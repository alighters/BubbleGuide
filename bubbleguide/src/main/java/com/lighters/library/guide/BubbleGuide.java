package com.lighters.library.guide;

import android.content.Context;

import com.lighters.library.guide.callback.BubbleGuideShowCallback;
import com.lighters.library.guide.view.GuideShadeView;

/**
 * Created by david on 15/12/31.
 * <p>
 * BubbleGuide的设置
 */
public class BubbleGuide {
    private BubbleGuideOption mBubbleGuideOption;
    private GuideShadeView mGuideShadeView;
    private Context mContext;
    private BubbleGuideShowCallback mShowCallback;

    public BubbleGuide(Context context) {
        mContext = context;
    }

    public BubbleGuide option(BubbleGuideOption bubbleGuideOption){
        mBubbleGuideOption = bubbleGuideOption;
        return this;
    }

    public void show(){

    }

    public void show(BubbleGuideShowCallback callback){

    }

    /**
     * 获取配置选项, 若不存在, 则获取全局默认配置
     * @return
     */
    private BubbleGuideOption getBubbleGuideOption() {
        if (mBubbleGuideOption == null) {
            mBubbleGuideOption = BubbleGuideConfiguration.getBubbleGuideOptions();
        }
        return  mBubbleGuideOption;
    }




}
