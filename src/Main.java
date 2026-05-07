import Menu.Menu;
import Services.BorrowService;
import Services.LibraryService;
import Services.MemberService;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        MemberService memberService = new MemberService();
        BorrowService borrowService = new BorrowService();

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

            menu.displayMenu();
            System.out.println(Constants.ENTER_OPTION);

            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {
                    Boolean LibraryExit = true;

                    while (LibraryExit) {
                        System.out.println(MenuMessage.LibraryService);
                        System.out.println(Constants.ENTER_OPTION);

                        LibraryExit = libraryService.handleLibraryMenu(scanner.nextInt());
                    }
                    menu.displayMenu();
                }

                case 2 -> {
                    Boolean MemberExit = true;

                    while (MemberExit) {
                        System.out.println(MenuMessage.MemberMenu);
                        System.out.println(Constants.ENTER_OPTION);

                        MemberExit = memberService.handleMemberMenu(scanner.nextInt());
                    }
                    menu.displayMenu();
                }

                case 3 -> {

                        System.out.println(MenuMessage.BorrowMenu);
                        System.out.println(Constants.ENTER_OPTION);

                        borrowService.handleBorrowMenu(scanner.nextInt());

                    menu.displayMenu();
                }

                case 4 -> {
                    System.out.println("Exit...");
                    return;
                }

                default -> {
                    System.out.println("Invalid option");
                    menu.displayMenu();
                }
            }
        }
    }
