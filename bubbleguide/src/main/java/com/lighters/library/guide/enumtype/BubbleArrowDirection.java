package com.lighters.library.guide.enumtype;

/**
 * Created by david on 15/12/28.
 */
public enum BubbleArrowDirection {

    LEFT(0x00),
    RIGHT(0x01),
    TOP(0x02),
    BOTTOM(0x03);

    private int mValue;

    BubbleArrowDirection(int value) {
        this.mValue = value;
    }

    public static BubbleArrowDirection mapIntToValue(int stateInt) {
        for (BubbleArrowDirection value : BubbleArrowDirection.values()) {
            if (stateInt == value.getIntValue()) {
                return value;
            }
        }
        return getDefault();
    }

    public static BubbleArrowDirection getDefault() {
        return LEFT;
    }

    public int getIntValue() {
        return mValue;
    }
}
