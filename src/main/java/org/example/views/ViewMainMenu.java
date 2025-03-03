package org.example.views;

import org.example.controllers.builders.ReceiptBuilder;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Clothing;
import org.example.models.clothing.Pants;
import org.example.models.clothing.Skirt;
import org.example.models.clothing.TShirt;
import org.example.models.generic.Customer;
import org.example.models.generic.Order;
import org.example.models.generic.Receipt;

import java.util.Scanner;

public class ViewMainMenu extends View
{
    @Override
    public void printMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        System.out.println("---Welcome to ClothesOnDemand e-shop!---");

        do
        {
            System.out.println("1. Buy pants");
            System.out.println("2. Buy skirt");
            System.out.println("3. Buy t-shirt");
            System.out.println("4. Look at cart");
            System.out.println("5. Go to checkout");
            System.out.println("0. Exit");
            System.out.print("Userinput: ");
            userInput = scanner.nextInt();

            switch(userInput)
            {
                case 1:
                    ViewManager.getInstance().switchView(ViewManager.ViewType.ADD_PANTS);
                    break;
                case 2:
                    ViewManager.getInstance().switchView(ViewManager.ViewType.ADD_SKIRT);
                    break;
                case 3:
                    ViewManager.getInstance().switchView(ViewManager.ViewType.ADD_TSHIRT);
                case 4:
                    printCart();
                    break;
                case 5:
                    checkOut();
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }

        }while(userInput != 0);
    }

    private void printCart()
    {
        System.out.println("---"+BusinessObjectManager.getInstance().getCurrentCustomer().getName()+"'s Cart---");
        if(BusinessObjectManager.getInstance().getCurrentOrder() == null)
        {
            System.out.println("Cart is empty!");
            return;
        }

        for(int i = 0; i < BusinessObjectManager.getInstance().getCurrentOrder().getArticles().size(); i++)
        {
            Clothing currentClothing = BusinessObjectManager.getInstance().getCurrentOrder().getArticles().get(i);

            if(currentClothing instanceof Pants)
            {
                System.out.println((i+1) +"."+((Pants) currentClothing).getFit() + " " +currentClothing.getColor() + " " + currentClothing.getMaterial()+" pants "+ currentClothing.getPrice()+"kr");
            }
            else if(currentClothing instanceof Skirt)
            {
                System.out.println((i+1) +"."+currentClothing.getColor() + " " + currentClothing.getMaterial()+" skirt "+ currentClothing.getPrice()+"kr");
            }
            else if(currentClothing instanceof TShirt)
            {
                System.out.println((i+1) +"."+currentClothing.getColor() + " " + currentClothing.getMaterial()+" t-shirt "+ currentClothing.getPrice()+"kr");
            }
        }
    }

    private void checkOut()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to check out? y/n");
        String userInput = scanner.nextLine();
        if(userInput.equals("y"))
        {
            Receipt receipt = BusinessObjectManager.getInstance().newReceipt(BusinessObjectManager.getInstance().getCurrentCustomer().getName());
            Order order = BusinessObjectManager.getInstance().getCurrentOrder();
            ReceiptBuilder builder = new ReceiptBuilder();
            builder.addOrderDetails(order);
            receipt.setText(builder.build().getText());
            System.out.println(receipt.getText());
        }
    }
}
