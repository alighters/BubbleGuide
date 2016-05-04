package com.lighters.library.guide.view;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lighters.library.guide.BubbleGuideOption;
import com.lighters.library.guide.R;
import com.lighters.library.guide.drawable.BubbleDrawable;

/**
 * The Bubble LinearLayout, contains the tip text and the confirm text.
 */
public class BubbleGuideLayout extends LinearLayout {

    private Context mContext;

    private BubbleDrawable bubbleDrawable;

    private TextView mTipView;
    private TextView mConfirmView;

    private BubbleGuideOption mGuideOption;

    public BubbleGuideLayout(Context context, BubbleGuideOption guideOption) {
        this(context, null, guideOption);
    }

    public BubbleGuideLayout(Context context, AttributeSet attrs, BubbleGuideOption guideOption) {
        super(context, attrs);
        mContext = context;
        mGuideOption = guideOption;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        setPadding(getDimen(R.dimen.bubble_guide_padding_left), getDimen(R.dimen.bubble_guide_padding_top),
            getDimen(R.dimen.bubble_guide_padding_right), getDimen(R.dimen.bubble_guide_padding_bottom));

        addView(getTipTextView());
        addView(getConfirmView());
        setData();
    }

    /**
     * Set the confirm and tip text.
     */
    private void setData() {
        if (mGuideOption != null) {
            if (!TextUtils.isEmpty(mGuideOption.mConfirmText)) {
                mConfirmView.setText(mGuideOption.mConfirmText);
            }
            if (!TextUtils.isEmpty(mGuideOption.mTipText)) {
                mTipView.setText(mGuideOption.mTipText);
            }
        }
    }

    private TextView getTipTextView() {
        if (mTipView == null) {
            mTipView = new TextView(mContext);
            mTipView.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mTipView.setTextColor(getResources().getColor(R.color.bubble_guide_tip_text_color));
            mTipView.setTextSize(getResources().getDimension(R.dimen.bubble_guide_tip_text_size));
        }
        return mTipView;
    }

    private TextView getConfirmView() {
        if (mConfirmView == null) {
            mConfirmView = new TextView(mContext);
            mConfirmView.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mConfirmView.setGravity(Gravity.RIGHT);
            mConfirmView.setText(R.string.bubble_guide_confirm_text);
            mConfirmView.setTextColor(getResources().getColor(R.color.bubble_guide_confirm_text_color));
            mConfirmView.setTextSize(getResources().getDimension(R.dimen.bubble_guide_confirm_text_size));
        }
        return mConfirmView;
    }

    private int getDimen(int id) {
        return (int) getResources().getDimension(id);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            setUp(w, h);
        }
    }

    private void setUp(int left, int right, int top, int bottom) {
        if (right < left || bottom < top) {
            return;
        }
        RectF rectF = new RectF(left, top, right, bottom);
        if (mGuideOption != null) {
            BubbleDrawable.Builder builder = new BubbleDrawable.Builder()
                .rect(rectF)
                .arrowLocation(mGuideOption.mBubbleArrowDirection)
                .bubbleType(BubbleDrawable.BubbleType.COLOR)
                .angle(mGuideOption.mAngle)
                .arrowHeight(mGuideOption.mArrowHeight)
                .arrowWidth(mGuideOption.mArrowWidth)
                .arrowPosition(mGuideOption.mArrowPosition)
                .bubbleColor(mGuideOption.mBubbleColor);

            bubbleDrawable = builder.build();
        }
    }

    //public void setArrowPosition(int arrowPosition){
    //    if(bubbleDrawable!=null){
    //        bubbleDrawable.
    //    }
    //}

    private void setUp(int width, int height) {
        setUp(getPaddingLeft(), +width - getPaddingRight(),
            getPaddingTop(), height - getPaddingBottom());
        setBackgroundDrawable(bubbleDrawable);
    }
}
