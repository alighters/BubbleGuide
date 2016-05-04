package com.lighters.library.guide.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lighters.library.guide.BubbleGuideOption;
import com.lighters.library.guide.enumtype.BubbleAlignType;
import com.lighters.library.guide.enumtype.BubbleArrowDirection;
import com.lighters.library.guide.utils.ViewUtils;

/**
 * Created by alighters on 15/12/31.
 *
 * The shade of the guide view. Show the guide view with
 */
public class GuideShadeView extends FrameLayout {

    private BubbleGuideOption mGuideOption;
    private Context mContext;

    private Bitmap mMaskBitmap;
    private int maskColor = 0xCC000000;

    public GuideShadeView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            buildMask();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),//
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mMaskBitmap, 0, 0, null);
        super.onDraw(canvas);
    }

    private void buildMask() {
        mMaskBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mMaskBitmap);
        canvas.drawColor(maskColor);

        if (mGuideOption != null && mGuideOption.mTipViewDraw != null) {
            mGuideOption.mTipViewDraw.draw(canvas, mGuideOption);
        }
    }

    public void addTipView(ViewGroup containerView, int guideViewId, View tipView, BubbleGuideOption bubbleGuideOption) {
        View guideView = containerView.findViewById(guideViewId);
        RectF rect = ViewUtils.getRectF(containerView, guideView, bubbleGuideOption.mGuideViewOffsetLeft,
            bubbleGuideOption.mGuideViewOffsetTop, bubbleGuideOption.mGuideViewOffsetRight,
            bubbleGuideOption.mGuideViewOffsetBottom);
        bubbleGuideOption.mMarginInfo = new MarginInfo();
        setMarginInfo(containerView, rect, bubbleGuideOption.mMarginInfo, bubbleGuideOption);
        if (tipView instanceof BubbleGuideLayout) {
            BubbleGuideLayout guideLayout = (BubbleGuideLayout) tipView;
            //guideLayout
        }
        LayoutParams lp = buildTipLayoutParams(tipView, bubbleGuideOption.mMarginInfo);

        if (lp.leftMargin == 0 && lp.topMargin == 0) {
            lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        } else if (lp.leftMargin == 0 && lp.bottomMargin == 0) {
            lp.gravity = Gravity.RIGHT | Gravity.TOP;
        } else if (lp.leftMargin == 0 && lp.rightMargin == 0) {
            lp.gravity = Gravity.CENTER_HORIZONTAL;
        }
        addView(tipView, lp);
    }

    private void setMarginInfo(View parent, RectF rectF, MarginInfo marginInfo, BubbleGuideOption guideOption) {
        if (guideOption != null) {
            float rightMargin = parent.getWidth() - rectF.right;
            float bottomMargin = parent.getHeight() - rectF.bottom;
            float topMargin = parent.getHeight() - rectF.top;

            if (guideOption.mAlignType != null && guideOption.mAlignType.equals(BubbleAlignType.RIGHT)) {
                marginInfo.rightMargin = rightMargin;

                if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.TOP)) {
                    marginInfo.topMargin = rectF.bottom + guideOption.mTipToGuideSpace;
                } else if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.BOTTOM)) {
                    marginInfo.bottomMargin = bottomMargin + rectF.height() + guideOption.mTipToGuideSpace;
                }
            } else if (guideOption.mAlignType != null && guideOption.mAlignType.equals(BubbleAlignType.LEFT)) {
                marginInfo.leftMargin = rectF.left;
                if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.TOP)) {
                    marginInfo.topMargin = topMargin + guideOption.mTipToGuideSpace;
                } else if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.BOTTOM)) {
                    marginInfo.bottomMargin = bottomMargin + rectF.height() + guideOption.mTipToGuideSpace;
                }
            } else if (guideOption.mAlignType != null && guideOption.mAlignType.equals(BubbleAlignType.CENTER)) {
                marginInfo.leftMargin = 0;
                marginInfo.rightMargin = rectF.right;
                if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.TOP)) {
                    marginInfo.topMargin = topMargin + guideOption.mTipToGuideSpace;
                } else if (guideOption.mBubbleArrowDirection.equals(BubbleArrowDirection.BOTTOM)) {
                    marginInfo.bottomMargin = bottomMargin + rectF.height() + guideOption.mTipToGuideSpace;
                }
            }
        }
    }

    private LayoutParams buildTipLayoutParams(View view, MarginInfo marginInfo) {
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (lp.leftMargin == (int) marginInfo.leftMargin &&
            lp.topMargin == (int) marginInfo.topMargin &&
            lp.rightMargin == (int) marginInfo.rightMargin &&
            lp.bottomMargin == (int) marginInfo.bottomMargin) {
            return null;
        }

        lp.leftMargin = (int) marginInfo.leftMargin;
        lp.topMargin = (int) marginInfo.topMargin;
        lp.rightMargin = (int) marginInfo.rightMargin;
        lp.bottomMargin = (int) marginInfo.bottomMargin;

        if (lp.leftMargin == 0 && lp.topMargin == 0) {
            lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        } else if (lp.leftMargin == 0 && lp.bottomMargin == 0) {
            lp.gravity = Gravity.RIGHT | Gravity.TOP;
        } else if (lp.leftMargin == 0 && lp.rightMargin == 0) {
            lp.gravity = Gravity.CENTER_HORIZONTAL;
        }
        return lp;
    }

    public static class MarginInfo {
        public float topMargin;
        public float leftMargin;
        public float rightMargin;
        public float bottomMargin;
    }
}
