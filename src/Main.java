import Menu.Menu;
import Services.BorrowService;
import Services.LibraryService;
import Services.MemberService;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static LibraryService libraryService = new LibraryService();
    static MemberService memberService = new MemberService();
    static BorrowService borrowService = new BorrowService();

    public static void main(String[] args) {

        handleMainMenu();
    }

    public static void handleMainMenu() {

        Menu menu = new Menu();

        menu.displayMenu();

        System.out.println(Constants.ENTER_OPTION);

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1 -> {
                System.out.println(MenuMessage.LibraryService);
                libraryService.handleLibraryMenu();
                handleMainMenu();
            }

            case 2 -> {
                System.out.println(MenuMessage.MemberMenu);
                memberService.handleMemberMenu();
                handleMainMenu();
            }

            case 3 -> {
                System.out.println(MenuMessage.BorrowMenu);
                borrowService.handleBorrowMenu();
                handleMainMenu();
            }

            case 4 -> {
                System.out.println("Exit...");
                return;
            }

            default -> {
                System.out.println("Invalid option");
                handleMainMenu();
            }
        }
    }
}