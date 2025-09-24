package org.kartik.observer;

public interface IObserver<T> extends ISuperObserver {
    void update(T data);
}
