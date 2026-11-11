
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        boolean quit = false;


        while (!quit)
        {

            displayMenu();


            String choice = SafeInput.getRegExString(
                    in,
                    "Enter your choice: ",
                    "[AaDdIiPpQq]"
            );


            choice = choice.toUpperCase();


            switch (choice)
            {
                case "A":
                    addItem(in);
                    break;

                case "D":
                    deleteItem(in);
                    break;

                case "I":
                    insertItem(in);
                    break;

                case "P":
                    printList();
                    break;

                case "Q":
                    if (SafeInput.getYNconfirm(in,
                            "Are you sure you want to quit?"))
                    {
                        quit = true;
                    }
                    break;
            }
        }

        IO.println("Thank you for using ListMaker!");

        in.close();
    }


    private static void displayMenu()
    {
        IO.println();
        IO.println("========== LIST MAKER ==========");

        displayNumberedList();

        IO.println();
        IO.println("A - Add an item");
        IO.println("D - Delete an item");
        IO.println("I - Insert an item");
        IO.println("P - Print the list");
        IO.println("Q - Quit");
        IO.println("================================");
    }


    private static void displayNumberedList()
    {
        if (list.size() == 0)
        {
            IO.println("Your list is currently empty.");
        }
        else
        {
            IO.println("Current List:");

            for (int i = 0; i < list.size(); i++)
            {
                IO.println((i + 1) + ". " + list.get(i));
            }
        }
    }


    private static void addItem(Scanner in)
    {
        IO.println();
        IO.println("ADD ITEM");

        String item = SafeInput.getNonZeroLenString(
                in, "Enter the item to add: ");

        list.add(item);

        IO.println("Item added successfully!");
    }


    private static void deleteItem(Scanner in)
    {
        IO.println();
        IO.println("DELETE ITEM");


        if (list.size() == 0)
        {
            IO.println("There are no items to delete.");
            return;
        }


        displayNumberedList();


        int itemNumber = SafeInput.getRangedInt(
                in,
                "Enter the item number to delete",
                1,
                list.size()
        );


        String removedItem = list.remove(itemNumber - 1);

        IO.println("Deleted: " + removedItem);
    }

    private static void insertItem(Scanner in)
    {
        IO.println();
        IO.println("INSERT ITEM");

        displayNumberedList();


        int location = SafeInput.getRangedInt(
                in,
                "Enter the location to insert the item",
                1,
                list.size() + 1
        );


        String item = SafeInput.getNonZeroLenString(
                in, "Enter the item to insert: ");


        list.add(location - 1, item);

        IO.println("Item inserted successfully!");
    }


    private static void printList()
    {
        IO.println();
        IO.println("PRINT LIST");

        displayNumberedList();
    }
}
