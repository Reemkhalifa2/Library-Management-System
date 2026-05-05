package Services;

import Entites.Address;
import Entites.Item;
import Entites.Member;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MemberService {
    private List<Member> memberList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void registerMember(Member member){
        for (Member i : memberList) {
            if (i.getId().equals(member.getId())) {
                System.out.println(Constants.ITEM_ADDED_FAILED);
                return;
            }
        }
        memberList.add(member);
        System.out.println(Constants.MEMBER_REGISTERED);
    }
    public void registerMultipleMembers(){

        Member member = new Member();
        Boolean flag = true;

        while (flag){

            System.out.println("Enter Member Name : ");
            member.setName(scanner.nextLine());

            System.out.println("Enter Member Id: ");
            member.setCivilId(scanner.nextLine());

            member.setId(UUID.randomUUID());

            Address address = new Address();

            System.out.println("Enter City : ");
            address.setCity(scanner.nextLine());

            System.out.println("Enter Street: ");
            address.setStreet(scanner.nextLine());

            System.out.println("Enter Postal Code: ");
            address.setPostalCode(scanner.nextLine());

            member.setAddress(address);
            registerMember(member);
            System.out.println(Constants.INPUT_EXIT_CONTINUE_MESSAGE_MEMBER);
            if (scanner.nextLine().equalsIgnoreCase("q")) {
                flag = false;
            }
        }
        }





    public Boolean handleMemberMenu(Integer option){
        while (true){

            System.out.println(MenuMessage.MemberMenu);
            System.out.println();

            System.out.println(Constants.ENTER_OPTION);

            switch (option){
                case 1-> registerMultipleMembers();

            }
        }

    }
}
