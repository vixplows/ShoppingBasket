package uk.co.vickyplows.shoppingbasket;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Items> itemList = new ArrayList<Items>();
    private Customer customer;

    public Basket(Customer customer) {
        this.customer = customer;
    }


    public int countItemsInItemList() {
        return itemList.size();
    }

    public void addItemToList(Items item) {
        itemList.add(item);
    }
}
