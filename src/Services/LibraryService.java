package Services;

import Behaviour.LibraryInterface;
import Entites.Book;
import Entites.Item;
import Entites.Magazines;
import Utilities.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class LibraryService implements LibraryInterface {
    List<Item> LibraryItem = new ArrayList<>();

    @Override
    public void addItem(Item items) {
        for (Item i : LibraryItem) {
            if (i.getID().equals(items.getID())) {
                System.out.println(Constants.ITEM_ADDED_FAILED);
                return;
            }
        }
        items.setID(UUID.randomUUID());
        LibraryItem.add(items);
        System.out.println(Constants.ITEM_ADDED_SUCCESSFULLY);
    }

    public void handleLibraryMenu(Integer option) {
        Scanner scanner = new Scanner(System.in);
        Item item = new Item();
        switch (option) {
            case 1 -> {
                System.out.println(""" 
                        1. Book.
                        2. Magazine.
                        """);

                System.out.println(Constants.ENTER_OPTION);
                int choice = scanner.nextInt();

                System.out.print("Enter Title: ");
                String title = scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        Book book = new Book();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        book.setTitle(title);
                        book.setAuthor(author);
                        book.setStatus(false);
                        addItem(book);

                    }
                    case 2 -> {
                        Magazines magazines = new Magazines();
                        System.out.print("Enter Issue Number: ");
                        Integer issue = scanner.nextInt();
                        magazines.setTitle(title);
                        magazines.setIssueNumber(issue);
                        magazines.setStatus(false);
                        addItem(magazines);

                    }
                }


            }


        }


    }
}
