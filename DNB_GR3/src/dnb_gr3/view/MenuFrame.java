/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import dnb_gr3.controller.DnBController;

/**
 *
 * @author Daniel Ouwehand
 */
public class MenuFrame extends JFrame{
    
    private final JButton singleplayer = new JButton ("Singleplayer");
    private final JButton multiplayer = new JButton ("Multiplayer");
    private final JButton credits = new JButton ("Credits");
    private final JButton quit = new JButton ("Quit");
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel("Main Menu");
    private MainFrame mainFrame;
    private MultiFrame multiFrame;
    private Credits creditFrame;

    public MenuFrame() {
        
        super("Dots and Boxes");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        
        add(label, BorderLayout.NORTH);
        
        label.setFont(new Font("SanSerif",Font.BOLD ,50));       
        
        
        setResizable(false);       
        
        
        panel.setLayout(new GridLayout(4, 1,0,40));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 200, 40, 200));
        label.setBorder(BorderFactory.createEmptyBorder(80, 220, 0, 0));
        
        
        panel.add(singleplayer);
        panel.add(multiplayer);
        panel.add(credits);
        panel.add(quit);  
        
        
        
        
        
        setVisible(true);
        
    }
    
    
// ActionListener Adding Methods    
    public void setCreditsListener(ActionListener l){
        this.credits.addActionListener(l);
    }
    
    public void setSingleplayerListener(ActionListener l){
        this.singleplayer.addActionListener(l);
    }
    
    public void setMultiplayerListener(ActionListener l){
        this.multiplayer.addActionListener(l);
    }
    
    public void setQuitListener(ActionListener l){
        this.quit.addActionListener(l);
    }
    
    

// Getter and Setter Methods

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public MultiFrame getMultiFrame() {
        return multiFrame;
    }

    public void setMultiFrame(MultiFrame multiFrame) {
        this.multiFrame = multiFrame;
    }
    
    public Credits getCreditFrame() {
        return creditFrame;
    }
    
    
    public void setCreditFrame(Credits creditFrame) {
        this.creditFrame = creditFrame;
    }

   
   
   
   
    
    
    
    
    
    
}
