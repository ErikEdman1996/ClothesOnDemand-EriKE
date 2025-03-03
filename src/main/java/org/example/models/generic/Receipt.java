package org.example.models.generic;

public class Receipt extends BusinessObject
{
    private String text;

    public Receipt()
    {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
