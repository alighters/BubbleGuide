package com.lighters.library.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.lighters.library.guide.callback.BubbleGuideShowCallback;
import com.lighters.library.guide.utils.ViewUtils;
import com.lighters.library.guide.view.BubbleGuideLayout;
import com.lighters.library.guide.view.GuideShadeView;

/**
 * Created by alighters on 15/12/31.
 *
 * The guide of bubble.
 */
public class BubbleGuide {

    private BubbleGuideOption mBubbleGuideOption;
    private GuideShadeView mGuideShadeView;
    private int mGuideViewId;
    private View mContainerView;
    private Context mContext;

    private BubbleGuide(Builder builder) {
        mBubbleGuideOption = builder.mBubbleGuideOption;
        mGuideViewId = builder.mGuideViewId;
        mContainerView = builder.mContainerView;
        mContext = builder.mContext;
    }

    public void show() {
        show(null);
    }

    public void show(BubbleGuideShowCallback callback) {
        if (mGuideShadeView == null) {
            mGuideShadeView = new GuideShadeView(mContext);
        }
        if (mContainerView != null && mContainerView instanceof ViewGroup) {
            if (mGuideViewId <= 0) {
                throw new RuntimeException("Guide view is not allowed empty!");
            }
            if (mBubbleGuideOption == null) {
                mBubbleGuideOption = BubbleGuideConfiguration.getBubbleGuideOptions();
            }
            BubbleGuideLayout guideTipView = new BubbleGuideLayout(mContext, mBubbleGuideOption);
            guideTipView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dp2px(mContext, 260),
                ViewGroup.LayoutParams.WRAP_CONTENT));
            mGuideShadeView.addTipView((ViewGroup) mContainerView, mGuideViewId, guideTipView, mBubbleGuideOption);
            addShadeView(mGuideShadeView);
            if (callback != null) {
                callback.onShow();
            }
        }
    }

    private void addShadeView(View shadeView) {
        if (mContainerView instanceof FrameLayout || mContainerView instanceof RelativeLayout) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) mContainerView).addView(shadeView, ((ViewGroup) mContainerView).getChildCount(), lp);
        } else {
            FrameLayout frameLayout = new FrameLayout(mContext);
            ViewGroup parent = (ViewGroup) mContainerView.getParent();
            parent.removeView(mContainerView);
            parent.addView(frameLayout, mContainerView.getLayoutParams());
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            frameLayout.addView(mContainerView, lp);

            frameLayout.addView(shadeView);
        }
    }

    /**
     * Get the bubble option, If not exists, get the global guide option.
     */
    private BubbleGuideOption getBubbleGuideOption() {
        if (mBubbleGuideOption == null) {
            mBubbleGuideOption = BubbleGuideConfiguration.getBubbleGuideOptions();
        }
        return mBubbleGuideOption;
    }

    public static final class Builder {
        private BubbleGuideOption mBubbleGuideOption;
        private int mGuideViewId;
        private View mContainerView;
        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder option(BubbleGuideOption val) {
            mBubbleGuideOption = val;
            return this;
        }

        public Builder guide(int val) {
            mGuideViewId = val;
            return this;
        }

        public Builder container(View val) {
            mContainerView = val;
            return this;
        }

        public BubbleGuide build() {
            return new BubbleGuide(this);
        }
    }
}
