package uk.co.vickyplows.shoppingbasket;

public class Customer {

    private String name;
    private boolean loyaltyCard;

    public Customer(String name, boolean loyaltyCard) {
        this.name = name;
        this.loyaltyCard = loyaltyCard;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public boolean getLoyaltyCard() {
        return loyaltyCard;
    }
}
