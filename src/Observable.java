//Observable.java

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Observable
{
    private CopyOnWriteArrayList<Observer> observers = new CopyOnWriteArrayList<>();

    public void add(Observer obs)
    {
        observers.add(obs);
    }

    public void notifyObserver()
    {
        for (Observer o : observers)
        {
            o.update(this);
        }
    }
}