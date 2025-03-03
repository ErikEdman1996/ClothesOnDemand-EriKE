package org.example.models.generic;

import org.example.models.clothing.Clothing;

import java.util.ArrayList;
import java.util.List;

public class Order extends BusinessObject
{
    private List<Clothing> articles = new ArrayList<Clothing>();

    public Order()
    {

    }

    public void addToOrder(Clothing clothing)
    {
        articles.add(clothing);
    }

    public void removeFromOrder(Clothing clothing)
    {
        articles.remove(clothing);
    }

    public List<Clothing> getArticles()
    {
        return articles;
    }
}
