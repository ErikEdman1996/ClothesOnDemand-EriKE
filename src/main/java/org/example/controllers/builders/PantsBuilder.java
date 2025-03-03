package org.example.controllers.builders;

import org.example.models.clothing.Pants;

import java.util.ArrayList;
import java.util.List;

public class PantsBuilder
{
    private Pants pants = new Pants();
    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();
    private List<String> validFits = new ArrayList<>();
    private List<Integer> validLengths = new ArrayList<>();

    public PantsBuilder()
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

        validFits.add("Slim");
        validFits.add("Regular");

        //Smallest length in cm
        validLengths.add(102);
        //Largest length in cm
        validLengths.add(117);
    }

    public Pants build()
    {
        if(pants.getMaterial() == null || pants.getSize() == null || pants.getColor() == null)
        {
            throw new RuntimeException("Pants must have a valid material, size and color");
        }

        return pants;
    }

    public PantsBuilder addSize(String size)
    {
        if(!validSizes.contains(size))
        {
            throw new IllegalArgumentException("Invalid size");
        }

        pants.setSize(size);
        return this;
    }

    public PantsBuilder addMaterial(String material)
    {
        if(!validMaterials.contains(material))
        {
            throw new IllegalArgumentException("Invalid material");
        }

        pants.setMaterial(material);
        return this;
    }

    public PantsBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }

        pants.setColor(color);
        return this;
    }

    public PantsBuilder addFit(String fit)
    {
        if(!validFits.contains(fit))
        {
            throw new IllegalArgumentException("Invalid fit");
        }
        pants.setFit(fit);
        return this;
    }

    public PantsBuilder addLength(int length)
    {
        if(length < validLengths.get(0) || length > validLengths.get(1))
        {
            throw new IllegalArgumentException("Invalid length, must be between 102 and 117 cm");
        }

        pants.setLength(length);
        return this;
    }
}
