package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;

public class CutLengthCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article) {
        if(instructions instanceof Pants && article instanceof Pants)
        {
            System.out.println("Cutting to match length: "+((Pants) instructions).getLength());
            ((Pants) article).setLength(((Pants) instructions).getLength());
        }
    }
}
