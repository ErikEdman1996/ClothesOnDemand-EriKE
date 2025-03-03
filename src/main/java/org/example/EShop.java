package org.example;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.generic.CEO;
import org.example.models.generic.Customer;
import org.example.views.ViewMainMenu;
import org.example.views.ViewNewCustomer;

public class EShop
{
    public void run()
    {
        ViewNewCustomer newCustomer = new ViewNewCustomer();
        ViewMainMenu mainMenu = new ViewMainMenu();
        newCustomer.printMenu();
        mainMenu.printMenu();
    }
}
