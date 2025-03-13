package org.example.views;

import org.example.controllers.builders.PantsBuilder;
import org.example.controllers.commands.*;
import org.example.controllers.commands.pants.CutAnkleLengthCommand;
import org.example.controllers.commands.pants.CutFullLengthCommand;
import org.example.controllers.commands.pants.SewRegularFitCommand;
import org.example.controllers.commands.pants.SewSlimFitCommand;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Pants;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewAddPants extends View
{
    @Override
    public void printMenu()
    {
        PantsBuilder builder = new PantsBuilder();
        Pipeline pipeline = new Pipeline();
        Customer currentCustomer = BusinessObjectManager.getInstance().getCurrentCustomer();
        Pants customerPants;

        /*3 första stegen ska skötas med Builder*/
        customerPants = builder
                .addMaterial(pickMaterial())
                .addSize(pickSize())
                .addColor(pickColor())
                .build();

        /*Steg 4-5 ska skötas med Commands via en loop*/
        pipeline.addCommand(pickFit());
        pipeline.addCommand(pickLength());

        pipeline.execute(customerPants);

        customerPants.notifyObservers("Notifying CEO: "+currentCustomer.getName()+"'s pants are finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerPants);
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

    private Command pickFit()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command fit = null;
        boolean finished = false;
        do
        {
            System.out.println("Select fit: ");
            System.out.println("1. Slim");
            System.out.println("2. Regular");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked slim-fit!");
                    fit = new SewSlimFitCommand();
                    break;
                case 2:
                    System.out.println("You picked regular-fit!");
                    fit = new SewRegularFitCommand();
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

        return fit;
    }

    private Command pickLength()
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        Command length = null;
        boolean finished = false;
        do
        {
            System.out.println("Select length: ");
            System.out.println("1. Full length");
            System.out.println("2. Ankle length");
            System.out.println("0. Return");
            System.out.print("Your choice: ");

            userInput = scanner.nextInt();
            switch (userInput)
            {
                case 1:
                    System.out.println("You picked full length!");
                    length = new CutFullLengthCommand();
                    break;
                case 2:
                    System.out.println("You picked ankle length!");
                    length = new CutAnkleLengthCommand();
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

        return length;
    }

}
