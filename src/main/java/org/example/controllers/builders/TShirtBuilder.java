package org.example.controllers.builders;

import org.example.models.clothing.TShirt;

import java.util.ArrayList;
import java.util.List;

public class TShirtBuilder
{
    private TShirt tshirt = new TShirt();

    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();
    private List<String> validNecks = new ArrayList<>();
    private List<String> validSleeves = new ArrayList<>();

    public TShirtBuilder()
    {
        validMaterials.add("Cotton");
        validMaterials.add("Polyester");
        validMaterials.add("Linen");

        validSizes.add("Small");
        validSizes.add("Medium");
        validSizes.add("Large");

        validColors.add("White");
        validColors.add("Grey");
        validColors.add("Black");

        validNecks.add("V-neck");
        validNecks.add("Crew neck");

        validSleeves.add("Long");
        validSleeves.add("Short");

    }

    public TShirt build()
    {
        if(tshirt.getMaterial() == null || tshirt.getSize() == null || tshirt.getColor() == null)
        {
            throw new RuntimeException("T-shirt must have a valid material, size and color");
        }
        return tshirt;
    }

    public TShirtBuilder addMaterial(String material)
    {
        if(!validMaterials.contains(material))
        {
            throw new IllegalArgumentException("Invalid material");
        }

        tshirt.setMaterial(material);
        return this;
    }

    public TShirtBuilder addSize(String size)
    {
        if(!validSizes.contains(size))
        {
            throw new IllegalArgumentException("Invalid size");
        }

        tshirt.setSize(size);
        return this;
    }

    public TShirtBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }
        tshirt.setColor(color);
        return this;
    }

    public TShirtBuilder addSleeves(String sleeves)
    {
        if(!validSleeves.contains(sleeves))
        {
            throw new IllegalArgumentException("Invalid sleeve");
        }
        tshirt.setSleeves(sleeves);
        return this;
    }

    public TShirtBuilder addNeck(String neck)
    {
        if(!validNecks.contains(neck))
        {
            throw new IllegalArgumentException("Invalid neck");
        }
        tshirt.setNeck(neck);
        return this;
    }
}
