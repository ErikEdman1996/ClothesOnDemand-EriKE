package org.example.controllers.builders;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.TShirt;

import java.util.ArrayList;
import java.util.List;

public class TShirtBuilder
{
    private TShirt tshirt = BusinessObjectManager.getInstance().newTShirt(BusinessObjectManager.getInstance().getCurrentCustomer().getName());

    private List<String> validMaterials = new ArrayList<>();
    private List<String> validSizes = new ArrayList<>();
    private List<String> validColors = new ArrayList<>();

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
        tshirt.notifyObservers("Notifying CEO: picking material "+material+"...");
        return this;
    }

    public TShirtBuilder addSize(String size)
    {
        if(!validSizes.contains(size))
        {
            throw new IllegalArgumentException("Invalid size");
        }

        tshirt.setSize(size);
        tshirt.notifyObservers("Notifying CEO: setting size "+size+"...");
        return this;
    }

    public TShirtBuilder addColor(String color)
    {
        if(!validColors.contains(color))
        {
            throw new IllegalArgumentException("Invalid color");
        }
        tshirt.setColor(color);
        tshirt.notifyObservers("Notifying CEO: adding color "+color+"...");
        return this;
    }
}
