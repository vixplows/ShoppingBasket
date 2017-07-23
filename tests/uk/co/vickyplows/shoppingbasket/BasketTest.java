package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasketTest {

    Basket basket;
    Customer customer;
    Milk milk;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Louise", true);
        milk = new Milk("a001", "Milk", 1.55, false);
        basket = new Basket(customer);
    }

    @Test
    public void testItemListStartsEmpty() {
        int countItemList = basket.countItemsInItemList();
        assertEquals(0, countItemList);
    }

    @Test
    public void testCanAddItem() {
        ArrayList<Items> itemList = new ArrayList<Items>();
        basket.addItemToList(milk);
        int countItemList = basket.countItemsInItemList();
        assertEquals(1, countItemList);
    }

    @Test
    public void testCanRemoveItem() {
        
    }

}