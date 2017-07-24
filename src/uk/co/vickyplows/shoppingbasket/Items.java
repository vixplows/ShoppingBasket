package uk.co.vickyplows.shoppingbasket;

public abstract class Items {

    private String productCode;
    private String name;
    private double price;
    private boolean bogofDiscount;


     Items(String productCode, String name, double price, boolean bogofDiscount) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.bogofDiscount = bogofDiscount;
    }

    String getProductCode() {
        return productCode;
    }

    void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    boolean getBogofDiscount() {
        return bogofDiscount;
    }

    void setBogofDiscount(boolean bogofDiscount) {
        this.bogofDiscount = bogofDiscount;
    }
}
