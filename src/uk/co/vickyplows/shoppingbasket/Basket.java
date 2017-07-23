package uk.co.vickyplows.shoppingbasket;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Items> itemList = new ArrayList<Items>();
    private Customer customer;

    public Basket(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return this.customer.getName();
    }

    public boolean getCustomerLoyaltyCard() {
        return this.customer.getLoyaltyCard();
    }

    public int countItemsInItemList() {
        return itemList.size();
    }

    public void addItemToList(Items item) {
        itemList.add(item);
    }

    public void removeItemFromList(Items item) {
        itemList.remove(item);
    }

    public void emptyAllItems() {
        itemList.clear();
    }

    public double getItemPrice(Items item) {
        return item.getPrice();
    }

//    public double addItemAndUpdateCurrentValue(Items item) {
//        itemList.add(item);
//
//    }
}
