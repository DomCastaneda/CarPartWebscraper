/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dcast
 */
public class PartTest {
    
    public PartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPrice method, of class Part.
     */
    @Test
    public void testGetPrice() {
        System.out.println("Running setPrice()");
        Part part = new Part();
        part.setPrice(10.00);
        assertTrue(part.getPrice() == 10.00);
    }

    /**
     * Test of setPrice method, of class Part.
     */
    @Test
    public void testSetPrice() {
        System.out.println("Running setPrice()");
        Part part = new Part();
        part.setPrice(10.00);
        assertTrue(part.getPrice() == 10.00);
    }

    /**
     * Test of getName method, of class Part.
     */
    @Test
    public void testGetName() {
        System.out.println("Running getName()");
        Part part = new Part();
        part.setName("test");
        assertTrue(part.getName() == "test");
    }

    /**
     * Test of setName method, of class Part.
     */
    @Test
    public void testSetName() {
        System.out.println("Running setName()");
        Part part = new Part();
        part.setName("test");
        assertTrue(part.getName() == "test");
    }
    
}
