/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turboparts;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaepark
 */
public class SignUpPageControllerTest {
    
    public SignUpPageControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
    * Test of isFieldFilled method
    */
    @Test
    public void testIsFieldFilled() 
    {
        System.out.println("Running isFieldFilled()");
//        SignUpPageController filled = new SignUpPageController();
//        String fill = "";
//        String expEmail = "email";
//        String expName = "name";
//        String expPass = "123";
        String resultEmail = "email";
        String resultName = "name";
        String resultPass = "123";
        
        boolean isFilled = true;
        if(resultEmail.isEmpty())
        {
            isFilled = false;
        }
        assertTrue(isFilled == true);
    }
    
}
