package com.lighters.library.guide.enumtype;

/**
 * Created by david on 15/12/28.
 */
public enum BubbleArrowLocation {

    LEFT(0x00),
    RIGHT(0x01),
    TOP(0x02),
    BOTTOM(0x03);

    private int mValue;

    BubbleArrowLocation(int value) {
        this.mValue = value;
    }

    public static BubbleArrowLocation mapIntToValue(int stateInt) {
        for (BubbleArrowLocation value : BubbleArrowLocation.values()) {
            if (stateInt == value.getIntValue()) {
                return value;
            }
        }
        return getDefault();
    }

    public static BubbleArrowLocation getDefault() {
        return LEFT;
    }

    public int getIntValue() {
        return mValue;
    }
}
