package Entites;

import java.util.List;

public class Member  {

    public List<String> getBorrowItems() {
        return borrowItems;
    }

    public void setBorrowItems(List<String> borrowItems) {
        this.borrowItems = borrowItems;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private String Id;
    private List<String> borrowItems ;
}
