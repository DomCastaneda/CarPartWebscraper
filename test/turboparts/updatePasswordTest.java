/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turboparts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaepark
 */
public class updatePasswordTest {
    
    public updatePasswordTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getPassword method, of class updatePassword.
     */
    @org.junit.Test
    public void testGetPassword() {
        User password = new User();
        password.setPassword("password");
        assertTrue(password.getPassword() == "password");
    }

    /**
     * Test of setPassword method, of class updatePassword.
     */
    @org.junit.Test
    public void testSetPassword() {
        User password = new User();
        password.setPassword("password");
        assertTrue(password.getPassword() == "password");
    }

    /**
     * Test of getNewPassword method, of class updatePassword.
     */
    @org.junit.Test
    public void testGetNewPassword() {
        updatePassword newPw = new updatePassword();
        newPw.setPassword("newPassword");
        assertTrue(newPw.getNewPassword() != "password");
    }

    /**
     * Test of SetNewPassword method, of class updatePassword.
     */
    @org.junit.Test
    public void testSetNewPassword() {
        updatePassword newPw = new updatePassword();
        newPw.setPassword("newPassword");
        assertTrue(newPw.getNewPassword() != "password");
    }
    
}
