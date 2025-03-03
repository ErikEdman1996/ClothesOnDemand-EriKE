package org.example.controllers.commands;

import org.example.models.clothing.Clothing;

public class SetSizeCommand implements Command
{
    @Override
    public void process(Clothing instructions, Clothing article) {
        System.out.println("Setting size: " + instructions.getSize());
        article.setSize(instructions.getSize());
    }
}
