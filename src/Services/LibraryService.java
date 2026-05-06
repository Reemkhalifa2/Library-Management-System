package Services;

import Behaviour.LibraryInterface;
import Entites.Book;
import Entites.DVD;
import Entites.Item;
import Entites.Magazines;
import Utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LibraryService implements LibraryInterface {
    List<Item> LibraryItem = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addItem(Item items) {
        for (Item i : LibraryItem) {
            if (i.getID().equals(items.getID())) {
                System.out.println(Constants.ITEM_ADDED_FAILED);
                return;
            }
        }
        LibraryItem.add(items);
        System.out.println(Constants.ITEM_ADDED_SUCCESSFULLY);
    }

    public void addMultipleItems() {

        boolean continueAdding = true;

        while (continueAdding) {

            System.out.println("""
                1. Book
                2. Magazine
                3. DVD
                4. Exit
                """);

            System.out.println(Constants.ENTER_OPTION);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    Book book = new Book();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setStatus(true);
                    book.setItemType("Book");
                    book.setID(UUID.randomUUID());
                    addItem(book);
                }

                case 2 -> {
                    Magazines magazines = new Magazines();

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Issue Number: ");
                    int issue = scanner.nextInt();
                    scanner.nextLine();

                    magazines.setTitle(title);
                    magazines.setIssueNumber(issue);
                    magazines.setStatus(true);
                    magazines.setItemType("Magazines");
                    magazines.setID(UUID.randomUUID());
                    addItem(magazines);
                }

                case 3 -> {
                    DVD dvd = new DVD();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    scanner.nextLine();

                    dvd.setTitle(title);
                    dvd.setDirector(director);
                    dvd.setStatus(true);
                    dvd.setItemType("DVD");
                    dvd.setID(UUID.randomUUID());
                    addItem(dvd);




                }

                case 4 -> continueAdding = false;

                default -> System.out.println("Invalid choice");
            }
        }
    }
    public void displayAllItem(){
        System.out.println("** ** ** Items List ** ** **" );
        System.out.println();
        System.out.println("MAGAZINE DETAILS");
        for(Item i : LibraryItem){
                if (i instanceof Magazines magazine) {

                    System.out.println("Title: " + magazine.getTitle());
                    System.out.println("Issue Number: " + magazine.getIssueNumber());
                    System.out.println("Available: " + magazine.getStatus());
                    System.out.println();
                }

        }
        System.out.println("BOOK DETAILS");
        for(Item i : LibraryItem){
                if (i instanceof Book book) {

                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.getStatus());
                    System.out.println();
                }
        }
        System.out.println("DVD DETAILS");
        for(Item i : LibraryItem){
            if (i instanceof DVD dvd) {
                System.out.println("DVD DETAILS");
                System.out.println("Title: " + dvd.getTitle());
                System.out.println("Director: " + dvd.getDirector());
                System.out.println("Available: " + dvd.getStatus());
            }
        }

    }

    public Item findItemByTitle() {
        System.out.println("Enter Item Name: ");
        String title = scanner.nextLine();

        Item foundItem = null;

        for (Item i : LibraryItem) {

            if (i.getTitle().equalsIgnoreCase(title)) {

                foundItem = i;

                if (i instanceof Book book) {
                    System.out.println("BOOK DETAILS");
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available: " + book.getStatus());
                }
                else if (i instanceof Magazines magazine) {
                    System.out.println("MAGAZINE DETAILS");
                    System.out.println("Title: " + magazine.getTitle());
                    System.out.println("Issue Number: " + magazine.getIssueNumber());
                    System.out.println("Available: " + magazine.getStatus());
                }
                else if (i instanceof DVD dvd) {
                    System.out.println("DVD DETAILS");
                    System.out.println("Title: " + dvd.getTitle());
                    System.out.println("Director: " + dvd.getDirector());
                    System.out.println("Available: " + dvd.getStatus());
                } else {
                    System.out.println(Constants.ITEM_NOT_FOUND);
                }
            }
        }
        System.out.println(foundItem);

        return foundItem;
    }




    public Boolean handleLibraryMenu(Integer option) {
        switch (option) {
            case 1 -> addMultipleItems();
            case 2-> findItemByTitle();
            case 3-> displayAllItem();
            case 4-> {
                System.out.println("Exit Library Services...");
                return false;
            }


            default -> System.out.println("Invalid option");


            }



        return true;


    }
}
