package org.example.controllers.managers;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;
import org.example.models.clothing.Skirt;
import org.example.models.clothing.TShirt;

import java.util.HashMap;
import java.util.Map;

public class ClothingPrototypeCache
{
    private Map<String, Clothing> cache = new HashMap<String, Clothing>();

    public ClothingPrototypeCache()
    {
        Pants pants = new Pants();
        pants.setPrice(200);
        pants.setMaterial("Cotton");
        pants.setSize("M");
        pants.setColor("Blue");
        pants.setFit("Regular");
        pants.setLength(102);

        Skirt skirt = new Skirt();
        skirt.setPrice(175);
        skirt.setMaterial("Wool");
        skirt.setSize("M");
        skirt.setColor("Black");
        skirt.setWaistline(80);
        skirt.setPattern("Lines");

        TShirt tShirt = new TShirt();
        tShirt.setPrice(150);
        tShirt.setMaterial("Cotton");
        tShirt.setSize("M");
        tShirt.setColor("White");
        tShirt.setNeck("V-neck");
        tShirt.setSleeves("Short");


        cache.put("pants", pants);
        cache.put("skirt", skirt);
        cache.put("tshirt", tShirt);
    }

    public Clothing put(String key, Clothing clothing)
    {
        cache.put(key, clothing);
        return clothing;
    }

    public Clothing get(String key)
    {
        return cache.get(key).clone();
    }
}
