package com.lighters.library.guide;

import android.view.View;

import com.lighters.library.guide.callback.BubbleGuideShowCallback;
import com.lighters.library.guide.enumtype.BubbleAlignType;
import com.lighters.library.guide.enumtype.BubbleArrowDirection;

/**
 * Created by david on 15/12/31.
 */
public class BubbleGuideOption implements Cloneable{
    /**
     * 气泡对齐方式
     */
    private BubbleAlignType mAlignType;
    /**
     * 气泡三角箭头位置方向
     */
    private BubbleArrowDirection mBubbleArrowDirection;
    /**
     * 气泡提示文本
     */
    private String mTipText;

    /**
     * 气泡确认文本
     */
    private String mConfirmText;

    /**
     * 引导添加的遮罩View
     */
    private View mShadeView;


    /**
     * 引导的View
     */
    private View mGuideView;

    /**
     * 引导View的左侧偏移
     */
    private float mGuideViewOffsetLeft;
    /**
     * 引导View的右侧偏移
     */
    private float mGuideViewOffsetRight;
    /**
     * 引导View的顶部偏移
     */
    private float mGuideViewOffsetTop;
    /**
     * 引导View的底部偏移
     */
    private float mGuideViewOffsetBottom;

    /**
     * 引导的显示与取消的回调
     */
    private BubbleGuideShowCallback mShowCallback;

    private BubbleGuideOption(Builder builder) {
        mAlignType = builder.mAlignType;
        mBubbleArrowDirection = builder.mBubbleArrowDirection;
        mTipText = builder.mTipText;
        mConfirmText = builder.mConfirmText;
        mShadeView = builder.mShadeView;
        mGuideView = builder.mGuideView;
        mGuideViewOffsetLeft = builder.mGuideViewOffsetLeft;
        mGuideViewOffsetRight = builder.mGuideViewOffsetRight;
        mGuideViewOffsetTop = builder.mGuideViewOffsetTop;
        mGuideViewOffsetBottom = builder.mGuideViewOffsetBottom;
    }


    public static final class Builder {
        private BubbleAlignType mAlignType;
        private BubbleArrowDirection mBubbleArrowDirection;
        private String mTipText;
        private String mConfirmText;
        private View mShadeView;
        private View mGuideView;
        private float mGuideViewOffsetLeft;
        private float mGuideViewOffsetRight;
        private float mGuideViewOffsetTop;
        private float mGuideViewOffsetBottom;

        public Builder() {
        }

        public Builder alignType(BubbleAlignType val) {
            mAlignType = val;
            return this;
        }

        public Builder arrowDirection(BubbleArrowDirection val) {
            mBubbleArrowDirection = val;
            return this;
        }

        public Builder tipText(String val) {
            mTipText = val;
            return this;
        }

        public Builder confirmText(String val) {
            mConfirmText = val;
            return this;
        }

        public Builder shadeView(View val) {
            mShadeView = val;
            return this;
        }

        public Builder guideView(View val) {
            mGuideView = val;
            return this;
        }

        public Builder offsetLeft(float val) {
            mGuideViewOffsetLeft = val;
            return this;
        }

        public Builder offsetRight(float val) {
            mGuideViewOffsetRight = val;
            return this;
        }

        public Builder offsetTop(float val) {
            mGuideViewOffsetTop = val;
            return this;
        }

        public Builder offsetBottom(float val) {
            mGuideViewOffsetBottom = val;
            return this;
        }

        public BubbleGuideOption build() {
            return new BubbleGuideOption(this);
        }
    }
}
