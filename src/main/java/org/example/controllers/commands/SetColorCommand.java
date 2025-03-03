package org.example.controllers.commands;

import org.example.models.clothing.Clothing;

public class SetColorCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article) {
        System.out.println("Coloring clothing: "+instructions.getColor());
        article.setColor(instructions.getColor());
    }
}
