package org.example.controllers.commands;

import org.example.models.clothing.Clothing;

public interface Command
{
    public void process(Clothing article);
}
