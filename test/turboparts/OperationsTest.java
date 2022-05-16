/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package turboparts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dcast
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of moneyFormat method, of class StringOperations.
     */
    @Test
    public void testmoneyFormat() {
        System.out.println("moneyFormat");
        String string1 = "45.00";
        Operations instance = new Operations();
        String expResult = "$45.00";
        String result = instance.moneyFormat(string1);
        assertEquals(expResult, result);
    }

    /**
     * Test of concatenate method, of class StringOperations.
     */
    @Test
    public void testConcatenate() {
        System.out.println("concatenate");
        String string1 = "test1";
        String string2 = "test2";
        Operations instance = new Operations();
        String expResult = "test1test2";
        String result = instance.concatenate(string1, string2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of clear method, of class StringOperations.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        String string1 = "test1";
        Operations instance = new Operations();
        String expResult = "";
        String result = instance.clear(string1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of smallestDouble method, of class TurboParts.
     */
    @Test
    public void smallestDouble() {
        System.out.println("min");
        double num1 = 45.0;
        double num2 = 50.0;
        double expResult = 45.0;
        double result = TurboParts.min(num1, num2);
        assertEquals(expResult, result, 0.0);
    }
    
}
