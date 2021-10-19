/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dcast
 */
public class webscraperTest {
    
    public webscraperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addPart method, of class webscraper.
     * Adds a Part to partlist.
     */
    @Test
    public void testAddPart() {
        System.out.println("Running addPart()");
        List<Part> partList = new ArrayList<Part>();
        assertEquals(partList.size(), 0);
        partList.add(new Part("Part1", 10.00));
        assertEquals(partList.size(), 1);
    }
    
}
