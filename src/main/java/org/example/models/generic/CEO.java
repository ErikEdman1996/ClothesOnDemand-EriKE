package org.example.models.generic;

import org.example.controllers.observers.Observer;

public class CEO extends BusinessObject implements Observer
{
    public CEO()
    {

    }

    @Override
    public void update(org.example.controllers.observers.Observable o, String msg)
    {
        System.out.println(msg);
    }
}
