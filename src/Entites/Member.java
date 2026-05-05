package Entites;

import java.util.List;
import java.util.UUID;

public class Member  {
    private Address address;

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public Member(){
        this.address = new Address();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCivilId() {
        return civilId;
    }

    public void setCivilId(String civilId) {
        this.civilId = civilId;
    }
    private String name;

    private String civilId;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    private UUID Id ;

    public void setBorrowItems(Item item) {
        this.borrowItems = borrowItems;
    }

    public List<Item> getBorrowItems() {
        return borrowItems;
    }

    private List<Item> borrowItems ;
}
