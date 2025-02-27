package org.example.models.generic;

import java.io.Serializable;

public class BusinessObject implements Serializable
{
    private int id;
    private String name;

    public BusinessObject()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
