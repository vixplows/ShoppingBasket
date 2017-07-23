package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

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


}