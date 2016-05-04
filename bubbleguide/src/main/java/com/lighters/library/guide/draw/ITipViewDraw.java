package com.lighters.library.guide.draw;

import android.graphics.Canvas;
import com.lighters.library.guide.BubbleGuideOption;

/**
 * Draw the tip view on the canvas by the bubble guide option.
 *
 * Created by alighters on 16/5/2.
 * Email: huangdiv5@gmail.com
 * GitHub: https://github.com/alighters
 */
public interface ITipViewDraw {

    /**
     * The way about the bubble draw.
     *
     * @param canvas            the canvas
     * @param bubbleGuideOption bubble guide option (@linked
     */
    void draw(Canvas canvas, BubbleGuideOption bubbleGuideOption);
}
