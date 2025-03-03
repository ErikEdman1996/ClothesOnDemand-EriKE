package org.example.views;

public class ViewManager
{

    private static ViewManager instance;

    public static ViewManager getInstance()
    {
        if(instance == null)
        {
            instance = new ViewManager();
        }

        return instance;
    }

    private ViewManager()
    {

    }

    public void switchView(ViewType type)
    {
        switch (type)
        {
            case MENU:
                ViewMainMenu menu = new ViewMainMenu();
                menu.printMenu();
                break;
            case ADD_PANTS:
                ViewAddPants addPants = new ViewAddPants();
                addPants.printMenu();
                break;
            case ADD_SKIRT:
                ViewAddSkirt addSkirt = new ViewAddSkirt();
                addSkirt.printMenu();
                break;
            case ADD_TSHIRT:
                ViewAddTShirt addTShirt = new ViewAddTShirt();
                addTShirt.printMenu();
                break;
        }
    }

    public enum ViewType
    {
        MENU,
        ADD_PANTS,
        ADD_SKIRT,
        ADD_TSHIRT,
        NEW_CUSTOMER
    }
}
