package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

public class MilkTest {

    private Milk milk;

    @Before
    public void setUp() throws Exception {
        milk = new Milk( "a001", "Milk", 1.55, false);
    }

    @Test
    public void testGetProductCode() {
        String productCode = milk.getProductCode();
        assertEquals( "a001", productCode);
    }

    @Test
    public void testSetProductCode() {
        milk.setProductCode("b001");
        String productCode = milk.getProductCode();
        assertEquals( "b001", productCode);
    }

    @Test
    public void testGetName() {
        String name = milk.getName();
        assertEquals( "Milk", name);
    }

    @Test
    public void testSetName() {
        milk.setName("LactoseFreeMilk");
        String name = milk.getName();
        assertEquals( "LactoseFreeMilk", name);
    }

    @Test
    public void testGetPrice() {
        double price = milk.getPrice();
        assertEquals( 1.55, price, 0.01);
    }

    @Test
    public void testSetPrice() {
        milk.setPrice(1.90);
        double price = milk.getPrice();
        assertEquals(1.90, price, 0.01);
    }


}