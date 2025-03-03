package org.example.models.clothing;

public class TShirt extends Clothing
{
    private String neck;
    private String sleeves;

    @Override
    public Clothing clone()
    {
        TShirt clone = new TShirt();

        clone.setPrice(getPrice());
        clone.setMaterial(getMaterial());
        clone.setSize(getSize());
        clone.setColor(getColor());
        clone.setNeck(getNeck());
        clone.setSleeves(getSleeves());

        return clone;
    }

    public TShirt()
    {

    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }
}
