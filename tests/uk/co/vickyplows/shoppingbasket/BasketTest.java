package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;
    Basket basket2;
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
        basket2 = new Basket(customer1);
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
        boolean loyaltyCard = basket2.getCustomerLoyaltyCard();
        assertEquals(false, loyaltyCard);
    }

    @Test
    public void testItemListStartsEmpty() {
        int countItemList = basket.countItemsInItemList();
        assertEquals(0, countItemList);
    }

    @Test
    public void testCanAddItem() {
        basket.addItemToList(milk);
        int countItemList = basket.countItemsInItemList();
        assertEquals(1, countItemList);
    }

    @Test
    public void testCanAddMutlipleItems() {
        basket.addItemToList(milk);
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        int countItemList = basket.countItemsInItemList();
        assertEquals(3, countItemList);
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
    public void testCanRemoveAllItems() {
        basket.addItemToList(milk);
        basket.addItemToList(milk);
        basket.addItemToList(bread);
        basket.emptyAllItems();
        int countItemList = basket.countItemsInItemList();
        assertEquals(0, countItemList);
    }

    @Test
    public void testCanGetItemPrice() {
        double itemPrice = basket.getItemPrice(milk);
        assertEquals( 1.55, itemPrice, 0.01);
    }

//    @Test
//    public void testCanCalculateBeforeDiscountValue() {
//        basket.addItemToList(milk);
//        basket.addItemToList(bread);
//        double totalValue =
//        assertEquals(2.55, totalValue, 0.01);
//    }

//    @Test
//    public void testCanAddItemAndUpdateTotalValue() {
//        double currentValue = basket.addItemAndUpdateCurrentValue(milk);
//        assertEquals(1.55, currentValue, 0.01);
//    }

}