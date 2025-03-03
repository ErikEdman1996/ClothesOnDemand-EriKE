package org.example.views;

import org.example.controllers.builders.SkirtBuilder;
import org.example.controllers.builders.TShirtBuilder;
import org.example.controllers.commands.*;
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
        TShirt customerShirt = BusinessObjectManager.getInstance().newTShirt(currentCustomer.getName());
        TShirtBuilder builder = new TShirtBuilder();

        //Get instructions for the tailor
        pickMaterial(builder);
        pickSize(builder);
        pickColor(builder);
        pickNeck(builder);
        pickSleeves(builder);

        TShirt instructions = builder.build();

        //Build process
        new SetMaterialCommand().process(instructions, customerShirt);
        new SetSizeCommand().process(instructions, customerShirt);
        new SetColorCommand().process(instructions, customerShirt);
        new SetNeckCommand().process(instructions, customerShirt);
        new SetSleevesCommand().process(instructions, customerShirt);

        customerShirt.notifyObservers(currentCustomer.getName()+"'s T-Shirt is finished!");

        //Add to Order
        BusinessObjectManager.getInstance().getCurrentOrder().addToOrder(customerShirt);
    }

    private void pickMaterial(TShirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addMaterial("Cotton");
                    break;
                case 2:
                    System.out.println("You picked polyester!");
                    builder.addMaterial("Polyester");
                    break;
                case 3:
                    System.out.println("You picked linen!");
                    builder.addMaterial("Linen");
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

    private void pickSize(TShirtBuilder builder)
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

    private void pickColor(TShirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addColor("White");
                    break;
                case 2:
                    System.out.println("You picked the color Grey!");
                    builder.addColor("Grey");
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

    private void pickNeck(TShirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addNeck("V-neck");
                    break;
                case 2:
                    System.out.println("You picked Crew neck!");
                    builder.addNeck("Crew neck");
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

    private void pickSleeves(TShirtBuilder builder)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
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
                    builder.addSleeves("Long");
                    break;
                case 2:
                    System.out.println("You picked short sleeves!");
                    builder.addSleeves("Short");
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

