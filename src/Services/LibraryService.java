package Services;

import Behaviour.LibraryInterface;
import Entites.Item;
import Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class LibraryService implements LibraryInterface {
    List<Item> LibraryItem = new ArrayList<>();

    @Override
    public void addItem(Item items) {
        for (Item i : LibraryItem) {
            if (i.getID().equals(items.getID())) {
                System.out.println(Constants.ITEM_ADDED_FAILED);
                return;
            }
        }
        LibraryItem.add(items);
        System.out.println(Constants.ITEM_ADDED_SUCCESSFULLY);
    }

}

