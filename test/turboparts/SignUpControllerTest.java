/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turboparts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dcast
 */
public class SignUpControllerTest {
    
    public SignUpControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testIsFieldFilled()
    {
        System.out.println("Running isFieldFilled()");
        String resultEmail = "email";
        boolean isFilled = true;
        if(resultEmail.isEmpty())
        {
            isFilled = false;
        }
        assertTrue(isFilled == true);
    }
    
}
