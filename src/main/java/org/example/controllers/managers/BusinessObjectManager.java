package org.example.controllers.managers;

import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;
import org.example.models.clothing.Skirt;
import org.example.models.clothing.TShirt;
import org.example.models.generic.*;

import java.util.*;

public class BusinessObjectManager
{
    private static BusinessObjectManager instance;
    //Key = id, Value = the actual object
    private Map<Integer, BusinessObject> map = new HashMap<Integer, BusinessObject>();
    private ClothingPrototypeCache clothingCache = new ClothingPrototypeCache();
    private int counter = 0;
    private Customer currentCustomer;
    private Order currentOrder;
    private CEO ceo;

    public static BusinessObjectManager getInstance()
    {
        if(instance == null)
        {
            instance = new BusinessObjectManager();
        }

        return instance;
    }

    private BusinessObjectManager()
    {
        ceo = newCEO("Wigell");
    }

    public CEO newCEO(String name)
    {
        CEO ceo = new CEO();
        ceo.setName(name);
        ceo.setId(++counter);
        map.put(counter, ceo);
        return ceo;
    }

    public Customer newCustomer(String name, String address, String email)
    {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setId(++counter);
        customer.setAddress(address);
        customer.setEmail(email);
        map.put(counter, customer);
        currentCustomer = customer;
        currentOrder = newOrder(name);
        return customer;
    }

    public Order newOrder(String name)
    {
        Order order = new Order();
        order.setName(name);
        order.setId(++counter);
        map.put(counter, order);
        return order;
    }

    public Receipt newReceipt(String name)
    {
        Receipt receipt = new Receipt();
        receipt.setName(name);
        receipt.setId(++counter);
        map.put(counter, receipt);
        return receipt;
    }

    public Pants newPants(String name)
    {
        Pants pants = (Pants)clothingCache.get("pants");
        pants.setName(name);
        pants.setId(++counter);
        pants.addObserver(ceo);
        pants.notifyObservers("Pants are being made...");
        map.put(counter, pants);
        return pants;
    }

    public Skirt newSkirt(String name)
    {
        Skirt skirt = (Skirt)clothingCache.get("skirt");
        skirt.setName(name);
        skirt.setId(++counter);
        skirt.addObserver(ceo);
        skirt.notifyObservers("Skirt is being made...");
        map.put(counter, skirt);
        return skirt;
    }

    public TShirt newTShirt(String name)
    {
        TShirt tshirt = (TShirt)clothingCache.get("tshirt");
        tshirt.setName(name);
        tshirt.setId(++counter);
        tshirt.addObserver(ceo);
        tshirt.notifyObservers("T-shirt is being made...");
        map.put(counter, tshirt);
        return tshirt;
    }

    public BusinessObject getBusinessObject(int id)
    {
        return map.get(id);
    }

    public Customer getCurrentCustomer()
    {
        return currentCustomer;
    }

    public Order getCurrentOrder()
    {
        return currentOrder;
    }
}
