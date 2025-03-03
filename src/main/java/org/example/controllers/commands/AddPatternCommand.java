package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Skirt;

public class AddPatternCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        if(instructions instanceof Skirt && article instanceof Skirt)
        {
            System.out.println("Adding pattern: "+((Skirt) instructions).getPattern());
            ((Skirt) article).setPattern(((Skirt) instructions).getPattern());
        }
    }
}
