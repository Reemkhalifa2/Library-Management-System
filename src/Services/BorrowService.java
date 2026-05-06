package Services;

import Entites.Item;
import Entites.Member;
import Utilities.Constants;

import java.util.Scanner;

public class BorrowService {
    LibraryService libraryService = new LibraryService();
    MemberService memberService = new MemberService();
    static Scanner scanner = new Scanner(System.in);

    public void borrow() {
        libraryService.displayAllItem();
        System.out.println("Enter Item title to borrow: ");

        Item item = libraryService.findItemByTitle();

        if (item == null) {
            System.out.println(Constants.ITEM_NOT_FOUND);
            return;
        }

        if (!item.getStatus()) {
            System.out.println("Item is already borrowed!");
            return;
        }
        System.out.println("Enter Member ID: ");
        Member member = memberService.findMemberById();

        if (member == null) {
            System.out.println(Constants.MEMBER_NOT_FOUND);
            return;
        }

        member.setBorrowItems(item);

        item.setStatus(false);

        System.out.println("Item borrowed successfully!");
    }

    public Boolean handleBorrowMenu(Integer option){
        switch (option) {
            case 1-> borrow();


            case 4-> {
                System.out.println("Exit Member Services...");
                return false;
            }

            default -> System.out.println("Invalid option");


        }



        return true;
    }
}
