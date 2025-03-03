package org.example.views;

import org.example.controllers.builders.PantsBuilder;
import org.example.controllers.builders.SkirtBuilder;
import org.example.controllers.commands.*;
import org.example.controllers.managers.BusinessObjectManager;
import org.example.models.clothing.Pants;
import org.example.models.clothing.Skirt;
import org.example.models.generic.Customer;

import java.util.Scanner;

public class ViewAddSkirt extends View
{
    @Override
    public void printMenu()
    {
        Customer currentCustomer = BusinessObjectManager.getInstance().getCurrentCustomer();
        Skirt customerSkirt = BusinessObjectManager.getInstance().newSkirt(currentCustomer.getName());
        SkirtBuilder builder = new SkirtBuilder();

        //Get instructions for the tailor
        pickMaterial(builder);
        pickSize(builder);
        pickColor(builder);
        pickWaistline(builder);
        pickPattern(builder);

        Skirt instructions = builder.build();

        //Build process
        new SetMaterialCommand().process(instructions, customerSkirt);
        new SetSizeCommand().process(instructions, customerSkirt);
        new SetColorCommand().process(instructions, customerSkirt);
        new SetWaistlineCommand().process(instructions, customerSkirt);
        new AddPatternCommand().process(instructions, customerSkirt);

        customerSkirt.notifyObservers(currentCustomer.getName()+"'s skirt is finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerSkirt);
    }

    private void pickMaterial(SkirtBuilder builder)
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

    private void pickSize(SkirtBuilder builder)
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

    private void pickColor(SkirtBuilder builder)
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

    private void pickWaistline(SkirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean finished = false;
        do
        {
            System.out.print("Select skirt waistline length between 80 - 100 cm: ");
            userInput = scanner.nextInt();
            builder.addWaistline(userInput);

            System.out.println("Are you happy with your choice? y/n");
            String answer = scanner.next();
            if(answer.equals("y"))
            {
                finished = true;
            }

        }while(!finished);
    }

    private void pickPattern(SkirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addPattern("Polka dots");
                    break;
                case 2:
                    System.out.println("You picked lines!");
                    builder.addPattern("Lines");
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
}
