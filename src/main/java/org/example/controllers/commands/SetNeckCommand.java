package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.TShirt;

public class SetNeckCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        if(instructions instanceof TShirt && article instanceof TShirt)
        {
            System.out.println("Sewing neck to match: "+((TShirt) instructions).getNeck());
            ((TShirt) article).setNeck(((TShirt) instructions).getNeck());
        }
    }
}
