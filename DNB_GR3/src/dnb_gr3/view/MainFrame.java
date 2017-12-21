/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Daniel Ouwehand
 */
public class MainFrame extends JFrame{
    
    private PlayPanel playField = new PlayPanel();
    private JLabel hostPoints = new JLabel("Own points: ");
    private JLabel guestPoints = new JLabel("Opponent points: ");
    private JLabel endText = new JLabel();
    private JPanel panelNorth = new JPanel();
    private JPanel panelEast = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JPanel panelWest = new JPanel();
    private JButton backToMenu = new JButton("Back to menu");
    
    
    
    
    public MainFrame(){
        
        super("Dots and Boxes");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new BorderLayout());
        setResizable(false);
        
        add(playField, BorderLayout.CENTER);
        add(panelNorth, BorderLayout.NORTH);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelWest, BorderLayout.WEST);
        
        panelSouth.setLayout(new GridLayout(1,2,160,0));
        panelSouth.add(endText);
        endText.setFont(new Font("SanSerif",Font.BOLD ,20));
        endText.setForeground(Color.red);
        panelSouth.add(backToMenu);
        panelSouth.setBorder(BorderFactory.createEmptyBorder(0, 320, 80, 40));
        
        panelNorth.setLayout(new GridLayout(1,2));
        panelNorth.add(hostPoints);
        panelNorth.add(guestPoints);
        hostPoints.setFont(new Font("SanSerif",Font.BOLD ,20));
        guestPoints.setFont(new Font("SanSerif",Font.BOLD ,20));
        
        
                
        
        panelNorth.setBorder(BorderFactory.createEmptyBorder(100, 140, 100, 0));
        panelWest.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 0));
        //panelSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        playField.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.black));
        
        setVisible(true);
        
        
    
    
    }

    public PlayPanel getPlayField() {
        return playField;
    }
    
    public void setMouseListener(MouseListener l){
        this.playField.addMouseListener(l);
    }
    
    public void setBackToMenuListener(ActionListener l){
        this.backToMenu.addActionListener(l);
    }
    
    public void setHostpoints(int points){
        this.hostPoints.setText("Own points: " + points);
        //this.hostPoints.setText(hostPoints + points);
    }
    
    public void setGuestpoints(int points){
        this.guestPoints.setText("Opponent points: " + points);
        //this.guestPoints.setText(hostPoints + points);
    }
    
    public void setEndtext(String message){
        this.endText.setText(message);
    }
    

    
    
    
}
