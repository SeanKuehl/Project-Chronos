/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author turqo
 */
public class EventTest {
    
    public EventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of PrintThis method, of class Event.
     */
    @Test
    public void EventId() {
        Event first = new Event(" ", " ", " ", " ", " ");
        int expected = -100000000 + 1;
        int actual = first.GetId();
        System.out.println(expected+" "+actual);
        Assert.assertEquals(expected, actual);
        //-100000000
    }

   
    
}
