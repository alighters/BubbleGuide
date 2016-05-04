package com.lighters.library.guide.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alighters on 16/5/3.
 * Email: huangdiv5@gmail.com
 * GitHub: https://github.com/alighters
 */
public class ViewUtils {

    /**
     * Get the rect of the child in the parent view.
     *
     * @param parent the parent view.
     * @param child  the child view.
     * @return the rect of the child.
     */
    public static Rect getLocationInView(View parent, View child) {
        if (child == null || parent == null) {
            throw new IllegalArgumentException("parent and child can not be null .");
        }

        View decorView = null;
        Context context = child.getContext();
        if (context instanceof Activity) {
            decorView = ((Activity) context).getWindow().getDecorView();
        }

        Rect result = new Rect();
        Rect tmpRect = new Rect();

        View tmp = child;

        if (child == parent) {
            child.getHitRect(result);
            return result;
        }
        while (tmp != decorView && tmp != parent) {
            tmp.getHitRect(tmpRect);

            result.left += tmpRect.left;
            result.top += tmpRect.top;
            tmp = (View) tmp.getParent();
        }
        result.right = result.left + child.getMeasuredWidth();
        result.bottom = result.top + child.getMeasuredHeight();
        return result;
    }

    /**
     * Get the pixel value by the dp value
     *
     * @param context The context.
     * @param dp      the dp value.
     * @return the pixel value.
     */
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
            context.getResources().getDisplayMetrics());
    }

    /**
     * Get the rectF about the child in the parent.
     *
     * @param parent       the parent view
     * @param view         the view.
     * @param offsetLeft   the left offset.
     * @param offsetTop    the top offset.
     * @param offsetRight  the right offset.
     * @param offsetBottom the bottom offset.
     * @return The rectF.
     */
    public static RectF getRectF(ViewGroup parent, View view, float offsetLeft, float offsetTop, float offsetRight,
        float offsetBottom) {
        RectF rect = new RectF(ViewUtils.getLocationInView(parent, view));
        rect.left += (offsetLeft);
        rect.right -= (offsetRight);
        rect.top += (offsetTop);
        rect.bottom -= (offsetBottom);
        return rect;
    }
}
