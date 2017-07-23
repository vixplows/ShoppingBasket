package uk.co.vickyplows.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private ArrayList<Items> itemList = new ArrayList<Items>();
    private Customer customer;
    private double currentValue;

    public Basket(Customer customer) {
        this.customer = customer;
        this.currentValue = 0;
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

    public double getCurrentValue() {
        return currentValue;
    }

    public void addItemAndUpdateCurrentValue(Items item) {
        itemList.add(item);
        currentValue += item.getPrice();
    }

    public double getItemPrice(Items item) {
        return item.getPrice();
    }

    public double sumItemPrices() {
        double sum = 0;
        for (Items item : itemList) {
            sum += item.getPrice();
        }
        return sum;
    }

    public boolean checkItemBogof(Items item) {
        return item.getBogofDiscount();
    }

    public double getBogofDiscount() {

        double totalBogofDiscount = 0;

        HashMap<String, Integer> bogofHashMap = new HashMap<String, Integer>();

        for (Items item : itemList) {
            if (item.getBogofDiscount() == true) {

                if (!bogofHashMap.containsKey(item.getName())) {
                    bogofHashMap.put(item.getName(), 1);

                } else {
                    bogofHashMap.put(item.getName(), bogofHashMap.get(item.getName()) + 1);
                    if (bogofHashMap.get(item.getName()) % 2 == 0) {
                        totalBogofDiscount += item.getPrice();
                    }
                }
            }
        }
        return totalBogofDiscount;
    }

}
