package org.example.models.clothing;

public class Skirt extends Clothing
{
    private String sleeves;
    private String neck;

    public Skirt()
    {

    }

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }
}
