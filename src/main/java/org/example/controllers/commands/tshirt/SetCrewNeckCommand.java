package org.example.controllers.commands.tshirt;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.TShirt;

public class SetCrewNeckCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof TShirt)
        {
            article.notifyObservers("Notifying CEO: cutting neck into a crew neck...");
            ((TShirt) article).setNeck("Crew Neck");
        }
    }
}
