package uk.co.vickyplows.shoppingbasket;

public class Customer {

    private String name;
    private boolean loyaltyCard;

    Customer(String name, boolean loyaltyCard) {
        this.name = name;
        this.loyaltyCard = loyaltyCard;
    }

    String getName() {
        return name;
    }

    boolean getLoyaltyCard() {
        return loyaltyCard;
    }

    void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}
