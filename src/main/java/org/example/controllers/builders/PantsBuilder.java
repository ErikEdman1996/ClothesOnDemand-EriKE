package org.example.controllers.builders;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Pants;

import java.util.ArrayList;
import java.util.List;

public class PantsBuilder
{
    private Pants pants = BusinessObjectManager.getInstance().newPants(BusinessObjectManager.getInstance().getCurrentCustomer().getName());

    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();

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
        pants.notifyObservers("Notifying CEO: setting size "+size+"...");
        return this;
    }

    public PantsBuilder addMaterial(String material)
    {
        if(!validMaterials.contains(material))
        {
            throw new IllegalArgumentException("Invalid material");
        }

        pants.setMaterial(material);
        pants.notifyObservers("Notifying CEO: picking material "+material+"...");
        return this;
    }

    public PantsBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }

        pants.setColor(color);
        pants.notifyObservers("Notifying CEO: adding color "+color+"...");
        return this;
    }
}
