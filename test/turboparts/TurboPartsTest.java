/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package turboparts;

import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurboPartsTest {
    
    public TurboPartsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of min method, of class TurboParts.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        double num1 = 1.0;
        double num2 = 2.0;
        double expResult = 1.0;
        double result = TurboParts.min(num1, num2);
        assertEquals(expResult, result, 0.0);
    }
    
}
