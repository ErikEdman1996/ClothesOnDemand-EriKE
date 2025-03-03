package org.example.models.clothing;

import org.example.controllers.observers.Observable;
import org.example.controllers.observers.Observer;
import org.example.models.generic.BusinessObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Clothing extends BusinessObject implements Observable
{
    private double price;
    private String size;
    private String color;
    private String material;

    private List<Observer> observers = new ArrayList<Observer>();

    public abstract Clothing clone();

    public Clothing()
    {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg)
    {
        if(observers.isEmpty())
        {
            return;
        }

        for(Observer observer : observers)
        {
            observer.update(this, msg);
        }
    }
}
