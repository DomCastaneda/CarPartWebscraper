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
public class changeUserTest {
    public changeUserTest() {
    }
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }
    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }
    /**
     * Test of getUsername method, of class changeUser.
     */
    @org.junit.Test
    public void testGetUsername() {
        User user = new User();
        user.setUsername("username");
        assertTrue(user.getUsername() == "username");
    }
    /**
     * Test of setUsername method, of class changeUser.
     */
    @org.junit.Test
    public void testSetUsername() {
        User user = new User();
        user.setUsername("username");
        assertTrue(user.getUsername() == "username");
    }
    /**
     * Test of getNewUsername method, of class changeUser.
     */
    @org.junit.Test
    public void testGetNewUsername() {
        changeUser changeuser = new changeUser();
        changeuser.setUsername("newusername");
        assertTrue(changeuser.getNewUsername() != "username");
    }
    /**
     * Test of SetNewUsername method, of class changeUser.
     */
    @org.junit.Test
    public void testSetNewUsername() {
        changeUser changeuser = new changeUser();
        changeuser.setUsername("newusername");
        assertTrue(changeuser.getNewUsername() != "username");
    }
}
