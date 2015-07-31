package com.mpakhomov;

/**
 * @author mpakhomov
 * @since 7/31/2015
 */
public final class IntPair {
    public final int x;
    public final int y;

    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
