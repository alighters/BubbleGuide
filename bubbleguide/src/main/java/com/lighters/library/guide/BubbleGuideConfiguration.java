package com.lighters.library.guide;

import com.lighters.library.guide.enumtype.BubbleAlignType;
import com.lighters.library.guide.enumtype.BubbleArrowDirection;

/**
 * Created by alighers on 16/1/5.
 * <p>
 * 气泡引导的设置
 */
public class BubbleGuideConfiguration {

    private static BubbleGuideOption mBubbleGuideOption;

    /**
     * 获取全局气泡引导选项
     */
    public static BubbleGuideOption getBubbleGuideOptions() {
        if (mBubbleGuideOption == null) {
            mBubbleGuideOption = new BubbleGuideOption.Builder()
                .arrowDirection(BubbleArrowDirection.BOTTOM)
                .alignType(BubbleAlignType.RIGHT)
                .build();
        }
        return mBubbleGuideOption;
    }

    /**
     * 设置全局默认气泡引导选项
     */
    public static void setBubbleGuideOption(BubbleGuideOption bubbleGuideOption) {
        mBubbleGuideOption = bubbleGuideOption;
    }
}
