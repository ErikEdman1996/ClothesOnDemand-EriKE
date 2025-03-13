package org.example.controllers.commands.tshirt;

import org.example.controllers.commands.Command;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.TShirt;

public class SetVNeckCommand implements Command
{
    @Override
    public void process(Clothing article)
    {
        if(article instanceof TShirt)
        {
            article.notifyObservers("Notifying CEO: cutting neck into a V-neck...");
            ((TShirt) article).setNeck("V-Neck");
        }
    }
}
