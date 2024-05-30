package com.kodilla.good.patterns.prototype.library;

public class Prototype<T> implements Cloneable {
    @SuppressWarnings("unchecked")
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}
