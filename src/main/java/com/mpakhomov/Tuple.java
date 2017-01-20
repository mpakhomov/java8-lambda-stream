package com.mpakhomov;

public class Tuple<T, U> {
    public final T x;
    public final U y;

    public T getX() {
        return x;
    }

    public U getY() {
        return y;
    }

    public Tuple(T x, U y) {
        this.x = x;
        this.y = y;
    }
}
