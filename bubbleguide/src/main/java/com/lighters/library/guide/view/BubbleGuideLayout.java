package com.lighters.library.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lighters.library.guide.R;

/**
 * Created by david on 16/1/5.
 * <p>
 * 气泡引导的layout
 */
public class BubbleGuideLayout extends LinearLayout {


    private Context mContext;

    private TextView mTipView;
    private TextView mConfirmView;

    public BubbleGuideLayout(Context context) {
        this(context, null);
    }

    public BubbleGuideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        setPadding(getDimen(R.dimen.bubble_guide_padding_left), getDimen(R.dimen.bubble_guide_padding_top), getDimen(R.dimen.bubble_guide_padding_right), getDimen(R.dimen.bubble_guide_padding_bottom));

        // 添加当前内容的子View,内容View跟确认View
        addView(getTipTextView());
        addView(getConfirmView());
    }

    private TextView getTipTextView() {
        if (mTipView == null) {
            mTipView = new TextView(mContext);
            mTipView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mTipView.setTextColor(getResources().getColor(R.color.bubble_guide_tip_text_color));
            mTipView.setTextSize(getResources().getDimension(R.dimen.bubble_guide_tip_text_size));
        }
        return mTipView;
    }

    private TextView getConfirmView() {
        if (mConfirmView == null) {
            mConfirmView = new TextView(mContext);
            mConfirmView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mConfirmView.setGravity(Gravity.RIGHT);
            mConfirmView.setText(R.string.bubble_guide_confirm_text);
            mConfirmView.setTextColor(getResources().getColor(R.color.bubble_guide_confirm_text_color));
            mConfirmView.setTextSize(getResources().getDimension(R.dimen.bubble_guide_confirm_text_size));

        }
        return mConfirmView;
    }

    /**
     * 设置提示文字
     *
     * @param value
     */
    public void setTip(CharSequence value) {
        mTipView.setText(value);
    }

    /**
     * 设置气泡的确认文字
     *
     * @param value
     */
    public void setConfirm(CharSequence value) {
        mConfirmView.setText(value);
    }


    /**
     * 获取Dimen对应的value值
     *
     * @param id
     * @return
     */
    private int getDimen(int id) {
        return (int) getResources().getDimension(id);
    }


}
