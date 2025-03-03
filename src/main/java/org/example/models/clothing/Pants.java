package org.example.models.clothing;

public class Pants extends Clothing
{
    private String fit;
    private int length;

    @Override
    public Clothing clone()
    {
        Pants clone = new Pants();
        clone.setPrice(getPrice());
        clone.setMaterial(getMaterial());
        clone.setSize(getSize());
        clone.setColor(getColor());
        clone.setFit(this.fit);
        clone.setLength(this.length);

        return clone;
    }

    public Pants()
    {

    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
