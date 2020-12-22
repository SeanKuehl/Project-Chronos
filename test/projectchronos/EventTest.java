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
    public void EventFromInputTest() {
        Event first = new Event("October", "Sunday", "2000", "11:00PM", "cool party going on");
        String expected = " October Sunday 2000 11:00PM\n"+first.GetId()+"\ncool party going on\n";
        //there's a space at the start because the produced string starts as " " and adds on
        String actual = first.GetEventAsDisplayString();
        
        Assert.assertEquals(expected, actual);
        
    }
    
    @Test
    public void EventFromFileTest() {
        Event first = new Event("October", "Sunday", "2000", "11:00PM", "cool party going on", 0);
        String expected = " October Sunday 2000 11:00PM\n0\ncool party going on\n";
        //there's a space at the start because the produced string starts as " " and adds on
        String actual = first.GetEventAsDisplayString();
        
        Assert.assertEquals(expected, actual);
    }
    
   

   
    
}
