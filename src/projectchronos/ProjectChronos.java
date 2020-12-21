/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import GUIPresets.AddEventPanel;
import GUIPresets.ListEventsPanel;
import GUIPresets.RemoveEventPanel;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author turqo
 */
public class ProjectChronos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AddEventMenu();
        ListEventsMenu();   //list menu doesn't error if there are none to show, so I don't
        //need to worry about that when reading from files later
        RemoveEventMenu();
        EventHandler eh = new EventHandler();
        eh.PrintEvents();
        
        
        
    }
    
    private static void RemoveEventMenu(){
        JFrame frame = new JFrame();
        EventHandler eh = new EventHandler();
        RemoveEventPanel removePanel = new RemoveEventPanel();
        
        
        //addPanel.setSize(new Dimension(800,600));
        frame.setContentPane(removePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //I may want to change this later so that it saves when I click the x in the top right
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);
        
        int noNextMenuSelected = 0;
        
        
        
        
        
        
        int userIsDone = 1;
        
        while (removePanel.changeMenuInteger == noNextMenuSelected){
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //this needs to be here otherwise nothing will happen
        }
        frame.setVisible(false);
    }
    
    private static void ListEventsMenu(){
        JFrame frame = new JFrame();
        EventHandler eh = new EventHandler();
        ListEventsPanel listPanel = new ListEventsPanel(eh.GetEventList());
        
        
        //addPanel.setSize(new Dimension(800,600));
        frame.setContentPane(listPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //I may want to change this later so that it saves when I click the x in the top right
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);
        
        int noNextMenuSelected = 0;
        
        
        
        
        
        
        int userIsDone = 1;
        
        while (listPanel.changeMenuInteger == noNextMenuSelected){
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //this needs to be here otherwise nothing will happen
        }
        frame.setVisible(false);
    }
    
    private static void AddEventMenu(){
        JFrame frame = new JFrame();
        AddEventPanel addPanel = new AddEventPanel();
        //addPanel.setSize(new Dimension(800,600));
        frame.setContentPane(addPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //I may want to change this later so that it saves when I click the x in the top right
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);
        
        int noNextMenuSelected = 0;
        
        
        int userCanceledAddition = -1;
        int userCompletedAddition = 1;
        
        while (addPanel.changeMenuInteger == noNextMenuSelected){
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //this needs to be here otherwise nothing will happen
        }
        frame.setVisible(false);
    }
    
}
