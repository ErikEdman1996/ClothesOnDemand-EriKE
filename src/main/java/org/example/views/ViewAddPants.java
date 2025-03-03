package org.example.views;

import org.example.controllers.builders.PantsBuilder;
import org.example.controllers.commands.*;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Pants;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewAddPants extends View
{
    @Override
    public void printMenu()
    {
        Customer currentCustomer = BusinessObjectManager.getInstance().getCurrentCustomer();
        Pants customerPants = BusinessObjectManager.getInstance().newPants(currentCustomer.getName());
        PantsBuilder builder = new PantsBuilder();

        //Get instructions for the tailor
        pickMaterial(builder);
        pickSize(builder);
        pickColor(builder);
        pickFit(builder);
        pickLength(builder);

        Pants instructions = builder.build();

        //Build process
        new SetMaterialCommand().process(instructions, customerPants);
        new SetSizeCommand().process(instructions, customerPants);
        new SetColorCommand().process(instructions, customerPants);
        new SewFitCommand().process(instructions, customerPants);
        new CutLengthCommand().process(instructions, customerPants);

        customerPants.notifyObservers(currentCustomer.getName()+"'s pants are finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerPants);
    }

    private void pickMaterial(PantsBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addMaterial("Cotton");
                    break;
                case 2:
                    System.out.println("You picked wool!");
                    builder.addMaterial("Wool");
                    break;
                case 3:
                    System.out.println("You picked denim!");
                    builder.addMaterial("Denim");
                    break;
                case 0:
                    return;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }

    private void pickSize(PantsBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addSize("Small");
                    break;
                case 2:
                    System.out.println("You picked size Medium!");
                    builder.addSize("Medium");
                    break;
                case 3:
                    System.out.println("You picked size Large!");
                    builder.addSize("Large");
                    break;
                case 0:
                    return;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }

    private void pickColor(PantsBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addColor("White");
                    break;
                case 2:
                    System.out.println("You picked the color Blue!");
                    builder.addColor("Blue");
                    break;
                case 3:
                    System.out.println("You picked the color Black!");
                    builder.addColor("Black");
                    break;
                case 0:
                    return;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }

    private void pickFit(PantsBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addFit("Slim");
                    break;
                case 2:
                    System.out.println("You picked regular-fit!");
                    builder.addFit("Regular");
                    break;
                case 0:
                    return;
            }

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }

    private void pickLength(PantsBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean finished = false;
        do
        {
            System.out.print("Select pant length between 102 - 117 cm: ");
            userInput = scanner.nextInt();
            builder.addLength(userInput);

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }
}
