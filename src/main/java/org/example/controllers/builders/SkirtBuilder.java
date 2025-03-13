package org.example.controllers.builders;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Skirt;

import java.util.ArrayList;
import java.util.List;

public class SkirtBuilder
{
    private Skirt skirt = BusinessObjectManager.getInstance().newSkirt(BusinessObjectManager.getInstance().getCurrentCustomer().getName());
    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();

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
        skirt.notifyObservers("Notifying CEO: picking material "+material+"...");
        return this;
    }

    public SkirtBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }

        skirt.setColor(color);
        skirt.notifyObservers("Notifying CEO: adding color "+color+"...");

        return this;
    }

    public SkirtBuilder addSize(String size)
    {
        if (!validSizes.contains(size))
        {
            throw new IllegalArgumentException("Invalid size");
        }
        skirt.setSize(size);
        skirt.notifyObservers("Notifying CEO: setting size "+size+"...");
        return this;
    }
}
