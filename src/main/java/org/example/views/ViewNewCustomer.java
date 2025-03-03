package org.example.views;

import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewNewCustomer extends View
{
    private Customer currentCustomer;

    @Override
    public void printMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Welcome to Wigell's Clothes-on-Demand e-shop!---");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("Please enter your address: ");
        String address = sc.nextLine();
        System.out.print("Please enter your e-mail: ");
        String email = sc.nextLine();
        currentCustomer = BusinessObjectManager.getInstance().newCustomer(name, address, email);
    }

    public Customer getCurrentCustomer()
    {
        return currentCustomer;
    }
}
