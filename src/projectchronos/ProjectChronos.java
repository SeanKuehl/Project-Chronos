/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import GUIPresets.AddEventPanel;
import GUIPresets.ListEventsPanel;
import GUIPresets.MainMenuPanel;
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
        
        
        FileHandler fh = new FileHandler();
        
        EventHandler eh = new EventHandler();
        eh.LoadEvents();    
        
        
        
    
        boolean running = true;
        int userChoice = -1;    //I made it -1 so that it couldn't default to one of the options
        
        while (running){
            userChoice = MainMenu();
            
            switch (userChoice){
                case 1:
                    AddEventMenu();
                    break;
                case 2:
                    ListEventsMenu();
                    break;
                case 3:
                    RemoveEventMenu();
                    break;
                case 4:
                    
                    eh.SaveEvents();
                    running = false;
                    break;
            }
        }
        
        
        
       
        
        
        
    }
    
    private static int MainMenu(){
        JFrame frame = new JFrame();
        
        MainMenuPanel mainMenu = new MainMenuPanel();
        
        
        
        frame.setContentPane(mainMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //I may want to change this later so that it saves when I click the x in the top right
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);
        
        int noNextMenuSelected = 0;
        
        
        while (mainMenu.changeMenuInteger == noNextMenuSelected){
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //this needs to be here otherwise nothing will happen
        }
        frame.setVisible(false);
        return mainMenu.changeMenuInteger;
    }
    
    private static void RemoveEventMenu(){
        JFrame frame = new JFrame();
        EventHandler eh = new EventHandler();
        RemoveEventPanel removePanel = new RemoveEventPanel();
        
        
       
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
