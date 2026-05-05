import Menu.Menu;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        Boolean exit = false;
        while(exit){
            menu.displayMenu();
            System.out.println(Constants.ENTER_OPTION);
            switch (scanner.nextInt()){
                case 1->{
                    Boolean LibraryExit = false;
                    while (LibraryExit){
                        System.out.println(MenuMessage.LibraryService);
                        System.out.println(Constants.ENTER_OPTION);


                    }

                }
                case 2->{
                    exit = true;
                }
            }

        }


    }
}