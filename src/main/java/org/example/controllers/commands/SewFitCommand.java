package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;

public class SewFitCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        if(instructions instanceof Pants && article instanceof Pants)
        {
            System.out.println("Sewing clothing to match fit: "+((Pants) instructions).getFit());
            ((Pants) article).setFit(((Pants) instructions).getFit());
        }
    }
}
