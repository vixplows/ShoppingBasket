package uk.co.vickyplows.shoppingbasket;

public abstract class Items {

    private String productCode;
    private String name;
    private double price;
    private boolean bogofDiscount;

    public Items(String productCode, String name, double price, boolean bogofDiscount) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.bogofDiscount = bogofDiscount;
    }

    public String getProductCode() {
        return productCode;
    }
}
