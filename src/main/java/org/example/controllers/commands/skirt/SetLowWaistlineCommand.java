package org.example.controllers.commands.skirt;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.Skirt;

public class SetLowWaistlineCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof Skirt)
        {
            article.notifyObservers("Notifying CEO: setting the waistline as a low waistline...");
            ((Skirt) article).setWaistline("Low Waist");
        }
    }
}
