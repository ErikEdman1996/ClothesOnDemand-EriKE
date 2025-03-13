package org.example.controllers.commands;

import org.example.models.clothing.Clothing;

import java.util.ArrayList;

public class Pipeline
{
    private ArrayList<Command> commands;

    public Pipeline()
    {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command)
    {
        commands.add(command);
    }

    public void execute(Clothing article)
    {
        for(Command command : commands)
        {
            command.process(article);
        }
    }
}
