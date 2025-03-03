package org.example.models.clothing;

public class Skirt extends Clothing
{
    private int waistline;
    private String pattern;

    @Override
    public Clothing clone()
    {
        Skirt clone = new Skirt();

        clone.setPrice(getPrice());
        clone.setMaterial(getMaterial());
        clone.setSize(getSize());
        clone.setColor(getColor());
        clone.setWaistline(getWaistline());
        clone.setPattern(getPattern());

        return clone;
    }

    public Skirt()
    {

    }

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
