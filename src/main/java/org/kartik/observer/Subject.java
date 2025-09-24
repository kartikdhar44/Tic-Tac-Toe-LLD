package org.kartik.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {
    private final List<IObserver<T>> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void register(IObserver<T> observer) {
        if (observer == null) {
            throw new NullPointerException("Observer cannot be null");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void unregister(IObserver<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T data) {
        for (IObserver<T> observer : observers) {
            observer.update(data);
        }
    }
}
