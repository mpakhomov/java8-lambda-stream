package com.mpakhomov;

/**
 * @author mpakhomov
 * @since 7/31/2015
 */
public final class Pair<T> {
    public final T x;
    public final T y;

    public Pair(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
