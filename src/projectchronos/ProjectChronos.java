/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectchronos;

import GUIPresets.AddEventPanel;
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
        
        JFrame frame = new JFrame();
        AddEventPanel addPanel = new AddEventPanel();
        //addPanel.setSize(new Dimension(800,600));
        frame.setContentPane(new AddEventPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //I may want to change this later so that it saves when I click the x in the top right
        frame.setSize(new Dimension(800,600));
        frame.setVisible(true);
        
    }
    
}
