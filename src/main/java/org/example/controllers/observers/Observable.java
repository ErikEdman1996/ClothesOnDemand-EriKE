package org.example.controllers.observers;

public interface Observable
{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(String msg);
}
