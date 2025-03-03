package org.example.controllers.commands;

import org.example.models.clothing.Clothing;

public class SetMaterialCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        System.out.println("Setting the material: " + instructions.getMaterial());
        article.setMaterial(instructions.getMaterial());
    }
}
