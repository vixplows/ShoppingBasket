package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadTest {

    private Bread bread;

    @Before
    public void setUp() throws Exception {
        bread = new Bread ("a002", "Bread", 1.00, true);
    }

    @Test
    public void testGetProduceCode() {
        String productCode = bread.getProductCode();
        assertEquals("a002", productCode);
    }

    @Test
    public void testSetProductCode() {
        bread.setProductCode("b002");
        String productCode = bread.getProductCode();
        assertEquals("b002", productCode);
    }

    @Test
    public void testGetName() {
        String name = bread.getName();
        assertEquals( "Bread", name);
    }

    @Test
    public void testSetName() {
        bread.setName("SourDough");
        String name = bread.getName();
        assertEquals("SourDough", name);
    }


}