package org.example.views;

import org.example.controllers.builders.SkirtBuilder;
import org.example.controllers.builders.TShirtBuilder;
import org.example.controllers.commands.*;
import org.example.controllers.commands.tshirt.SetCrewNeckCommand;
import org.example.controllers.commands.tshirt.SetLongSleevesCommand;
import org.example.controllers.commands.tshirt.SetShortSleevesCommand;
import org.example.controllers.commands.tshirt.SetVNeckCommand;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.TShirt;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewAddTShirt extends View
{
    @Override
    public void printMenu()
    {
        Customer currentCustomer = BusinessObjectManager.getInstance().getCurrentCustomer();
        Pipeline pipeline = new Pipeline();
        TShirt customerShirt;
        TShirtBuilder builder = new TShirtBuilder();

        customerShirt = builder
                .addMaterial(pickMaterial())
                .addSize(pickSize())
                .addColor(pickColor())
                .build();

        pipeline.addCommand(pickNeck());
        pipeline.addCommand(pickSleeves());

        pipeline.execute(customerShirt);

        customerShirt.notifyObservers(currentCustomer.getName()+"'s T-Shirt is finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerShirt);
    }

    private String pickMaterial()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        String material = "";
        boolean finished = false;
        do
        {
            System.out.println("Select material: ");
            System.out.println("1. Cotton");
            System.out.println("2. Polyester");
            System.out.println("3. Linen");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked cotton!");
                    material = "Cotton";
                    break;
                case 2:
                    System.out.println("You picked polyester!");
                    material = "Polyester";
                    break;
                case 3:
                    System.out.println("You picked linen!");
                    material = "Linen";
                    break;
                case 0:
                    return "";
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);

        return material;
    }

    private String pickSize()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        String size = "";
        boolean finished = false;
        do
        {
            System.out.println("Select size: ");
            System.out.println("1. S");
            System.out.println("2. M");
            System.out.println("3. L");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked size Small!");
                    size = "Small";
                    break;
                case 2:
                    System.out.println("You picked size Medium!");
                    size = "Medium";
                    break;
                case 3:
                    System.out.println("You picked size Large!");
                    size = "Large";
                    break;
                case 0:
                    return "";
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);

        return size;
    }

    private String pickColor()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        String color = "";
        boolean finished = false;
        do
        {
            System.out.println("Select color: ");
            System.out.println("1. White");
            System.out.println("2. Grey");
            System.out.println("3. Black");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked the color White!");
                    color = "White";
                    break;
                case 2:
                    System.out.println("You picked the color Grey!");
                    color = "Grey";
                    break;
                case 3:
                    System.out.println("You picked the color Black!");
                    color = "Black";
                    break;
                case 0:
                    return "";
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);

        return color;
    }

    private Command pickNeck()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command neck = null;
        boolean finished = false;
        do
        {
            System.out.println("Select neck style: ");
            System.out.println("1. V-neck");
            System.out.println("2. Crew neck");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked V-neck!");
                    neck = new SetVNeckCommand();
                    break;
                case 2:
                    System.out.println("You picked Crew neck!");
                    neck = new SetCrewNeckCommand();
                    break;
                case 0:
                    return null;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);

        return neck;
    }

    private Command pickSleeves()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command sleeves = null;
        boolean finished = false;
        do
        {
            System.out.println("Select sleeves: ");
            System.out.println("1. Long");
            System.out.println("2. Short");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked long sleeves!");
                    sleeves = new SetLongSleevesCommand();
                    break;
                case 2:
                    System.out.println("You picked short sleeves!");
                    sleeves = new SetShortSleevesCommand();
                    break;
                case 0:
                    return null;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);

        return sleeves;
    }
}

