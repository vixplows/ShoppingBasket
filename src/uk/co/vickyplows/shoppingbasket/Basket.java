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

    public double getCurrentValue() {
        return currentValue;
    }

    public void addItemToList(Items item) {
        itemList.add(item);
        currentValue += item.getPrice();
    }

    public void removeItemFromList(Items item) {
        itemList.remove(item);
        currentValue -= item.getPrice();
    }

    public void emptyAllItems() {
        itemList.clear();
        currentValue = 0;
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
            if (item.getBogofDiscount()) {

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

    public double getTwentyPlusDiscountTotal() {
        double twentyPlusDiscount = 0;

        currentValue = currentValue - this.getBogofDiscount();

        if (currentValue > 20.00) {
            twentyPlusDiscount = currentValue * 0.1;
        } else {
            twentyPlusDiscount = 0;
        }

        return twentyPlusDiscount;
    }

    public double getCustomerLoyaltyDiscountTotal() {
        double customerLoyaltyDiscount = 0;

        currentValue = currentValue - (this.getBogofDiscount() + this.getTwentyPlusDiscountTotal());

        if (customer.getLoyaltyCard()) {
            customerLoyaltyDiscount = currentValue * 0.02;
        } else {
            customerLoyaltyDiscount = 0;
        }

        return customerLoyaltyDiscount;
    }

}
