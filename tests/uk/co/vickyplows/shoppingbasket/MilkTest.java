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


}