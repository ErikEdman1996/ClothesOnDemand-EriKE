package org.example.models.clothing;

public class TShirt extends Clothing
{
    private String waistline;
    private String pattern;

    public TShirt()
    {

    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
