package com.lighters.library.guide.enumtype;

/**
 * Created by david on 15/12/28.
 */
public enum BubbleAlignType {

    LEFT(0x00),
    CENTER(0x01),
    RIGHT(0x02);

    private int mValue;

    BubbleAlignType(int value) {
        this.mValue = value;
    }

    public static BubbleAlignType mapIntToValue(int stateInt) {
        for (BubbleAlignType value : BubbleAlignType.values()) {
            if (stateInt == value.getIntValue()) {
                return value;
            }
        }
        return getDefault();
    }

    public static BubbleAlignType getDefault() {
        return LEFT;
    }

    public int getIntValue() {
        return mValue;
    }
}
