package Services;

import Behaviour.BorrowInterface;
import Entites.Item;
import Entites.Member;
import Utilities.Constants;

import java.util.Scanner;

public class BorrowService implements BorrowInterface {

    LibraryService libraryService = new LibraryService();
    MemberService memberService = new MemberService();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void borrowItem() {

        libraryService.displayAllItem();

        Item item = libraryService.findItemByTitle();

        if (item == null) {
            return;
        }

        if (!item.getStatus()) {
            System.out.println(Constants.ITEM_BORROWED);
            return;
        }

        Member member = memberService.findMemberById();

        if (member == null) {
            return;
        }

        member.setBorrowItems(item);
        item.setStatus(false);

        System.out.println(Constants.ITEM_BORROWED_SUCCESSFULLY);
    }

    @Override
    public void returnItem() {

        Member member = memberService.findMemberById();

        if (member == null) {
            System.out.println(Constants.MEMBER_NOT_FOUND);
            return;
        }

        System.out.println();
        System.out.println("Enter Item title to return: ");

        String title = scanner.nextLine();
        Item foundItem = null;

        for (Item item : member.getBorrowItems()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                foundItem = item;
                break;
            }
        }

        if (foundItem == null) {
            System.out.println(Constants.ITEM_NOT_FOUND);
            return;
        }

        member.getBorrowItems().remove(foundItem);
        foundItem.setStatus(true);

        System.out.println(Constants.ITEM_RETURNED_SUCCESSFULLY);
    }

    public Boolean handleBorrowMenu(Integer option) {

        switch (option) {
            case 1 -> borrowItem();
            case 2 -> returnItem();
            case 3 -> {
                System.out.println("Exit Member Services...");
                return false;
            }
            default -> System.out.println("Invalid option");
        }

        return true;
    }
}