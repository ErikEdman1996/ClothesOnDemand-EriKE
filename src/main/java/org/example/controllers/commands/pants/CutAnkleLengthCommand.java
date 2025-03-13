package org.example.controllers.commands.pants;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;

public class CutAnkleLengthCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof Pants)
        {
            article.notifyObservers("Notifying CEO: Cutting pants into ankle length...");
            ((Pants) article).setLength("Ankle Length");
        }
    }
}
