package org.example.controllers.builders;

import org.example.models.clothing.Skirt;

import java.util.ArrayList;
import java.util.List;

public class SkirtBuilder
{
    private Skirt skirt = new Skirt();
    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();
    private List<Integer> validWaistlines = new ArrayList<>();
    private List<String> validPatterns = new ArrayList<>();

    public SkirtBuilder()
    {
        validMaterials.add("Cotton");
        validMaterials.add("Wool");
        validMaterials.add("Denim");

        validSizes.add("Small");
        validSizes.add("Medium");
        validSizes.add("Large");

        validColors.add("White");
        validColors.add("Blue");
        validColors.add("Black");

        //Smallest waistline in cm
        validWaistlines.add(80);
        //Largest waistline in cm
        validWaistlines.add(100);

        validPatterns.add("Polka dots");
        validPatterns.add("Lines");
    }

    public Skirt build()
    {
        if(skirt.getMaterial() == null || skirt.getSize() == null || skirt.getColor() == null)
        {
            throw new RuntimeException("Skirt must have a valid material, size and color");
        }

        return skirt;
    }

    public SkirtBuilder addMaterial(String material)
    {
        if (!validMaterials.contains(material))
        {
            throw new IllegalArgumentException("Invalid material");
        }

        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }

        skirt.setColor(color);
        return this;
    }

    public SkirtBuilder addSize(String size)
    {
        if (!validSizes.contains(size))
        {
            throw new IllegalArgumentException("Invalid size");
        }
        skirt.setSize(size);
        return this;
    }

    public SkirtBuilder addWaistline(int waistline)
    {
        if(waistline < validWaistlines.get(0) || waistline > validWaistlines.get(1))
        {
            throw new IllegalArgumentException("Invalid waistline");
        }

        skirt.setWaistline(waistline);
        return this;
    }

    public SkirtBuilder addPattern(String pattern)
    {
        if (!validPatterns.contains(pattern))
        {
            throw new IllegalArgumentException("Invalid pattern");
        }

        skirt.setPattern(pattern);
        return this;
    }
}
