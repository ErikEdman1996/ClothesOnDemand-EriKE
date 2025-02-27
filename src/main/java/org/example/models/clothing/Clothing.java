package org.example.models.clothing;

import org.example.models.generic.BusinessObject;

public class Clothing extends BusinessObject
{
    private double price;
    private String size;
    private String color;

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
}
