import Menu.Menu;
import Services.LibraryService;
import Services.MemberService;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        LibraryService libraryService = new LibraryService();
        MemberService memberService = new MemberService();

        Scanner scanner = new Scanner(System.in);
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
                    Boolean MemberExit = true;
                    while (MemberExit){
                        System.out.println(MenuMessage.MemberMenu);
                        System.out.println(Constants.ENTER_OPTION);
                        MemberExit = memberService.handleMemberMenu(scanner.nextInt());
                    }
                }case 3->{
                    System.out.println("Exit...");
                    Continue = false;
                }
            }

        }


    }
}