package org.example.models.clothing;

public class Pants extends Clothing
{
    private String fit;
    private String length;

    public Pants()
    {

    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
