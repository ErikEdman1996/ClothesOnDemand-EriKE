package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Skirt;

public class SetWaistlineCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        if(instructions instanceof Skirt && article instanceof Skirt)
        {
            System.out.println("Sewing waistline: "+((Skirt) instructions).getWaistline());
            ((Skirt) article).setWaistline(((Skirt) instructions).getWaistline());
        }
    }
}
