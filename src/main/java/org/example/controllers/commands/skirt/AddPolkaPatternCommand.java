package org.example.controllers.commands.skirt;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.Skirt;

public class AddPolkaPatternCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof Skirt)
        {
            article.notifyObservers("Notifying CEO: adding polka dots to the skirt...");
            ((Skirt) article).setPattern("Polka Dots");
        }
    }
}
