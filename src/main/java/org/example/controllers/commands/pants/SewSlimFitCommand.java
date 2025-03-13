package org.example.controllers.commands.pants;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;

public class SewSlimFitCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof Pants)
        {
            article.notifyObservers("Notifying CEO: Sewing pants into slim fit...");
            ((Pants) article).setFit("Slim");
        }
    }
}
