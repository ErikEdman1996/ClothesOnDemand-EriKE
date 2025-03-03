package org.example.controllers.commands;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.TShirt;

public class SetSleevesCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article)
    {
        if(instructions instanceof TShirt && article instanceof TShirt)
        {
            System.out.println("Cutting sleeves to match: "+((TShirt) instructions).getSleeves());
            ((TShirt) article).setSleeves(((TShirt) instructions).getSleeves());
        }
    }
}
