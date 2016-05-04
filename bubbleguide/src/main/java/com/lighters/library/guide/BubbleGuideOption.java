package com.lighters.library.guide;

import com.lighters.library.guide.draw.ITipViewDraw;
import com.lighters.library.guide.enumtype.BubbleAlignType;
import com.lighters.library.guide.enumtype.BubbleArrowDirection;
import com.lighters.library.guide.view.GuideShadeView;

/**
 * Created by alighters on 15/12/31.
 *
 * The option about the bubble guide, includes the offset spacing of the guide view and text, align type or arrow direction.
 */
public class BubbleGuideOption implements Cloneable {
    /**
     * The Bubble Align Type.
     */
    public BubbleAlignType mAlignType;
    /**
     * The Direction of the bubble Arrow.
     */
    public BubbleArrowDirection mBubbleArrowDirection;
    /**
     * The tip text of the guide view.
     */
    public String mTipText;

    /**
     * The confirm text of the guide view.
     */
    public String mConfirmText;

    /**
     * The left offset of the guide view.
     */
    public int mGuideViewOffsetLeft;
    /**
     * The right offset of the guide view.
     */
    public int mGuideViewOffsetRight;
    /**
     * The top offset of the guide view.
     */
    public int mGuideViewOffsetTop;
    /**
     * The bottom offset of the guide view.
     */
    public int mGuideViewOffsetBottom;

    /**
     * The angle size.
     */
    public int mAngle;

    /**
     * The height of the arrow.
     */
    public int mArrowHeight;

    /**
     * The width of the arrow.
     */
    public int mArrowWidth;

    /**
     * The position fo the arrow.
     */
    public int mArrowPosition;

    /**
     * The color of the bubble.
     */
    public int mBubbleColor;

    /**
     * The space distance between tip view and the guide view.
     */
    public int mTipToGuideSpace;

    /**
     * The margin info about the guide view.
     */
    public GuideShadeView.MarginInfo mMarginInfo;
    /**
     * The tip view draw.
     */
    public ITipViewDraw mTipViewDraw;

    private BubbleGuideOption(Builder builder) {
        mAlignType = builder.mAlignType;
        mBubbleArrowDirection = builder.mBubbleArrowDirection;
        mTipText = builder.mTipText;
        mConfirmText = builder.mConfirmText;
        mGuideViewOffsetLeft = builder.mGuideViewOffsetLeft;
        mGuideViewOffsetRight = builder.mGuideViewOffsetRight;
        mGuideViewOffsetTop = builder.mGuideViewOffsetTop;
        mGuideViewOffsetBottom = builder.mGuideViewOffsetBottom;
        mTipViewDraw = builder.mTipViewDraw;
        mAngle = builder.mRounderCornerSize;
        mArrowHeight = builder.mArrowHeight;
        mArrowWidth = builder.mArrowWidth;
        mArrowPosition = builder.mArrowPosition;
        mBubbleColor = builder.mBubbleColor;
    }

    public static final class Builder {
        private BubbleAlignType mAlignType;
        private BubbleArrowDirection mBubbleArrowDirection;
        private String mTipText;
        private String mConfirmText;
        private int mGuideViewOffsetLeft;
        private int mGuideViewOffsetRight;
        private int mGuideViewOffsetTop;
        private int mGuideViewOffsetBottom;
        private ITipViewDraw mTipViewDraw;
        private int mRounderCornerSize;
        private int mArrowHeight;
        private int mArrowWidth;
        private int mArrowPosition;
        private int mBubbleColor;
        private int mTipToGuideSpace;

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

        public Builder offsetLeft(int val) {
            mGuideViewOffsetLeft = val;
            return this;
        }

        public Builder offsetRight(int val) {
            mGuideViewOffsetRight = val;
            return this;
        }

        public Builder offsetTop(int val) {
            mGuideViewOffsetTop = val;
            return this;
        }

        public Builder offsetBottom(int val) {
            mGuideViewOffsetBottom = val;
            return this;
        }

        public Builder tipViewDraw(ITipViewDraw tipViewDraw) {
            mTipViewDraw = tipViewDraw;
            return this;
        }

        public Builder roundCornerSize(int angle) {
            mRounderCornerSize = angle;
            return this;
        }

        public Builder arrowHeight(int val) {
            mArrowHeight = val;
            return this;
        }

        public Builder arrowWidth(int val) {
            mArrowWidth = val;
            return this;
        }

        public Builder arrowPosition(int val) {
            mArrowPosition = val;
            return this;
        }

        public Builder bubbleColor(int val) {
            mBubbleColor = val;
            return this;
        }

        public Builder tipToGuideSpace(int val) {
            mTipToGuideSpace = val;
            return this;
        }

        public BubbleGuideOption build() {
            return new BubbleGuideOption(this);
        }
    }
}
