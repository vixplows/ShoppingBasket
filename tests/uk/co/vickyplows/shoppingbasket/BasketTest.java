package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;
    Basket basket1;
    Customer customer;
    Customer customer1;
    Milk milk;
    Bread bread;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Louise", true);
        customer1 = new Customer("Fabio", false);
        milk = new Milk("a001", "Milk", 1.55, false);
        bread = new Bread ("a002", "Bread", 1.00, true);
        basket = new Basket(customer);
        basket1 = new Basket(customer1);
    }

    @Test
    public void testGetCustomerName() {
        String name = basket.getCustomerName();
        assertEquals("Louise", name);
    }

    @Test
    public void testCanCheckCustomerHasLoyaltyCard() {
        boolean loyaltyCard = basket.getCustomerLoyaltyCard();
        assertEquals(true, loyaltyCard);
    }

    @Test
    public void testsCheckCustomerNoLoyaltyCard() {
        boolean loyaltyCard = basket1.getCustomerLoyaltyCard();
        assertEquals(false, loyaltyCard);
    }

    @Test
    public void testItemListStartsEmpty() {
        int countItemList = basket.countItemsInItemList();
        assertEquals(0, countItemList);
    }

    @Test
    public void testCurrentValueStartsAtZero() {
        double currentValue = basket.getCurrentValue();
        assertEquals( 0, currentValue, 0.01);
    }

    @Test
    public void testCanAddItem() {
        basket.addItemToList(milk);
        int countItemList = basket.countItemsInItemList();
        assertEquals(1, countItemList);
    }

    @Test
    public void testUpdatesCurrentValueWhenAddItem() {
        basket.addItemToList(bread);
        double currentValue = basket.getCurrentValue();
        assertEquals(1.00, currentValue, 0.01);
    }

    @Test
    public void testCanRemoveItem() {
        basket.addItemToList(milk);
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        basket.removeItemFromList(milk);
        int countItemList = basket.countItemsInItemList();
        assertEquals(2, countItemList);
    }

    @Test
    public void testUpdatesCurrentValueWhenRemoveItem() {
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        basket.removeItemFromList(bread);
        double currentValue = basket.getCurrentValue();
        assertEquals(1.55, currentValue, 0.01);
    }

    @Test
    public void testCanRemoveAllItems() {
        basket.addItemToList(milk);
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        basket.emptyAllItems();
        int countItemList = basket.countItemsInItemList();
        assertEquals(0, countItemList);
    }

    @Test
    public void testCurrentValueSetToZeroWhenBasketEmptied() {
        basket.addItemToList(milk);
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        basket.emptyAllItems();
        double currentValue = basket.getCurrentValue();
        assertEquals(0, currentValue, 0.01);
    }

    @Test
    public void testCanGetItemPrice() {
        double itemPrice = basket.getItemPrice(milk);
        assertEquals( 1.55, itemPrice, 0.01);
    }

    @Test
    public void testCanSumTotalItemsValuePreDiscounts() {
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        double totalValue = basket.sumItemPrices();
        assertEquals(2.55, totalValue, 0.01);
    }

    @Test
    public void testCanCheckItemHasBogofTrue() {
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        boolean bogof = basket.checkItemBogof(bread);
        assertEquals(true, bogof);
    }

    @Test
    public void testCanCheckItemHasBogofFalse() {
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        boolean bogof = basket.checkItemBogof(milk);
        assertEquals(false, bogof);
    }

    @Test
    public void testGetTotalBogofDiscount() {
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        double totalBogofDiscount = basket.getBogofDiscountTotal();
        assertEquals( 1.00, totalBogofDiscount, 0.01);
    }

    @Test
    public void testGetTwentyPlusDiscountTotal() {
        bread = new Bread ("a002", "Bread", 12.00, true);
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        double twentyPlusDiscount = basket.getTwentyPlusDiscountTotal();
        assertEquals(2.40, twentyPlusDiscount, 0.01);
    }

    @Test
    public void testNoTwentyPlusDiscountApplied() {
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        double twentyPlusDiscount = basket.getTwentyPlusDiscountTotal();
        assertEquals( 0, twentyPlusDiscount, 0.01);
    }

    @Test
    public void testGetCustomerLoyaltyDiscountTotal() {
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        basket.addItemToList(bread);
        double customerLoyaltyDiscount = basket.getCustomerLoyaltyDiscountTotal();
        assertEquals( 0.04, customerLoyaltyDiscount, 0.01);
    }

    @Test
    public void testNoCustomerLoyaltyDiscountApplied() {
        basket1.addItemToList(bread);
        basket1.addItemToList(bread);
        basket1.addItemToList(bread);
        double customerLoyaltyDiscount = basket1.getCustomerLoyaltyDiscountTotal();
        assertEquals( 0, customerLoyaltyDiscount, 0.01);
    }

    @Test
    public void testCaluculateTotalToPayNoLoyaltyCard() {
        bread = new Bread ("a002", "Bread", 12.00, true);
        basket1.addItemToList(bread);
        basket1.addItemToList(bread);
        basket1.addItemToList(bread);
        double totalToPay = basket1.getTotalToPay();
        assertEquals(21.60, totalToPay, 0.01);
    }

//    @Test
//    public void testCalculateTotalToPayWithLoyaltyCard() {
//        bread = new Bread ("a002", "Bread", 12.00, true);
//        basket.addItemToList(bread);
//        basket.addItemToList(bread);
//        basket.addItemToList(bread);
//        double totalToPay = basket.getTotalToPay();
//        assertEquals(21.17, totalToPay, 0.01);
//    }

}