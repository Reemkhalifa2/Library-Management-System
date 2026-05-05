package Services;

import Entites.*;
import Utilities.Constants;
import Utilities.MenuMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MemberService {

     List<Member> memberList = new ArrayList<>();
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

    public void displayAllMembers(){
        System.out.println("** ** ** Members List ** ** **" );
        System.out.println();
        for(Member member : memberList){
            System.out.println("Member Name: "+member.getName());
            System.out.println("Member ID: "+member.getCivilId());
            System.out.println("Member address: ");
            System.out.print("Street: "+ member.getAddress().getStreet() +
                    " || City: "+ member.getAddress().getCity() +
                    " || Postal Code: "+ member.getAddress().getPostalCode());

            if(member.getBorrowItems() != null){
                for(Item item : member.getBorrowItems()){
                    System.out.print("Borrowed Items: " + item.getTitle() + " || ");
                }
            }

        }

    }





    public Boolean handleMemberMenu(Integer option) {
        switch (option) {
            case 1 -> registerMultipleMembers();
            //case 2-> ;
            case 3-> displayAllMembers();
            case 4-> {
                System.out.println("Exit Member Services...");
                return false;
            }

            default -> System.out.println("Invalid option");


        }



        return true;


    }
}
