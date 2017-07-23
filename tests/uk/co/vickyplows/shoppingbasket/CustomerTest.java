package uk.co.vickyplows.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;
    private Customer customer1;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Louise", true );
        customer1 = new Customer("Fabio", false);
    }

    @Test
    public void testGetName() {
        String name = customer.getName();
        assertEquals("Louise", name);
    }

    @Test
    public void testSetName() {
        customer.setName("Raina");
        String name = customer.getName();
        assertEquals( "Raina", name);
    }

    @Test
    public void testHasLoyaltyCard() {
        boolean loyaltyCard = customer.getLoyaltyCard();
        assertEquals( true, loyaltyCard);
    }
    
    @Test
    public void testNoLoyaltyCard() {
        boolean loyaltyCard = customer1.getLoyaltyCard();
        assertEquals( false, loyaltyCard);
    }


}