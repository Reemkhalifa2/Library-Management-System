import Menu.Menu;
import Services.LibraryService;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("am worling");
        Menu menu = new Menu();
        Boolean Continue = true;
        while(Continue){
            menu.displayMenu();
            System.out.println(Constants.ENTER_OPTION);
            switch (scanner.nextInt()){
                case 1->{
                    Boolean LibraryExit = true;
                    while (LibraryExit){
                        System.out.println(MenuMessage.LibraryService);
                        System.out.println(Constants.ENTER_OPTION);
                        LibraryExit = libraryService.handleLibraryMenu(scanner.nextInt());
                    }

                }
                case 2->{
                    Continue = false;
                }
            }

        }


    }
}