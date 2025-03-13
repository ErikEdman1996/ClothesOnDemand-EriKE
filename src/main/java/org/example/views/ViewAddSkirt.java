package org.example.views;

import org.example.controllers.builders.SkirtBuilder;
import org.example.controllers.commands.*;
import org.example.controllers.commands.skirt.AddLinesPatternCommand;
import org.example.controllers.commands.skirt.AddPolkaPatternCommand;
import org.example.controllers.commands.skirt.SetHighWaistlineCommand;
import org.example.controllers.commands.skirt.SetLowWaistlineCommand;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Skirt;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewAddSkirt extends View
{
    @Override
    public void printMenu()
    {
        Customer currentCustomer = BusinessObjectManager.getInstance().getCurrentCustomer();
        Skirt customerSkirt;
        SkirtBuilder builder = new SkirtBuilder();
        Pipeline pipeline = new Pipeline();

        customerSkirt = builder
                .addMaterial(pickMaterial())
                .addSize(pickSize())
                .addColor(pickColor())
                .build();

        pipeline.addCommand(pickWaistline());
        pipeline.addCommand(pickPattern());

        pipeline.execute(customerSkirt);

        customerSkirt.notifyObservers("Notifying CEO: "+currentCustomer.getName()+"'s skirt is finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerSkirt);
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
            System.out.println("2. Wool");
            System.out.println("3. Denim");
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
                    System.out.println("You picked wool!");
                    material = "Wool";
                    break;
                case 3:
                    System.out.println("You picked denim!");
                    material = "Denim";
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
                    size =  "Medium";
                    break;
                case 3:
                    System.out.println("You picked size Large!");
                    size =  "Large";
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
            System.out.println("2. Blue");
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
                    System.out.println("You picked the color Blue!");
                    color = "Blue";
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

    private Command pickWaistline()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command waistline = null;
        boolean finished = false;
        do
        {
            System.out.println("Select waistline: ");
            System.out.println("1. High waistline");
            System.out.println("2. Low waistline");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked high waistline!");
                    waistline = new SetHighWaistlineCommand();
                    break;
                case 2:
                    System.out.println("You picked low waistline!");
                    waistline = new SetLowWaistlineCommand();
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

        return waistline;
    }

    private Command pickPattern()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command pattern = null;
        boolean finished = false;
        do
        {
            System.out.println("Select pattern: ");
            System.out.println("1. Polka dots");
            System.out.println("2. Lines");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked polka dots!");
                    pattern = new AddPolkaPatternCommand();
                    break;
                case 2:
                    System.out.println("You picked lines!");
                    pattern = new AddLinesPatternCommand();
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

        return pattern;
    }
}
