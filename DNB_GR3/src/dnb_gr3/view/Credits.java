/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

/**
 *
 * @author Daniel Ouwehand
 */
public class Credits extends JFrame{
    
    private final JLabel lucien = new JLabel("Lucien Egloff");
    private final JLabel adrian = new JLabel("Adrian Kohler");
    private final JLabel daniel = new JLabel("Daniel Ouwehand");
    private final JLabel peter = new JLabel("Peter Zürcher");
    private final JLabel top = new JLabel("Credits");
    private JPanel panel = new JPanel();
    private JButton back = new JButton("Back");
    private JPanel panelEast = new JPanel();
    private MenuFrame menuFrame;

    public Credits() {
        
        super("Dots and Boxes");
        
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout());
        
        add(top, BorderLayout.NORTH);
        top.setBorder(BorderFactory.createEmptyBorder(20, 40, 0, 0));
        top.setFont(new Font("SanSerif",Font.BOLD ,50));
        
        
        
        
        
        
        add(panel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(5,1));
        panel.setBorder(BorderFactory.createEmptyBorder(60, 40, 120, 0));
        panel.add(lucien);
        panel.add(adrian);
        panel.add(daniel);
        panel.add(peter);
        add(panelEast,BorderLayout.EAST);
        panelEast.add(back);
        //back.setPreferredSize(new Dimension(20, 10));
        panelEast.setBorder(BorderFactory.createEmptyBorder(400, 20, 20, 20));
        
        
        lucien.setFont(new Font("SanSerif",Font.BOLD ,20));
        adrian.setFont(new Font("SanSerif",Font.BOLD ,20));
        daniel.setFont(new Font("SanSerif",Font.BOLD ,20));
        peter.setFont(new Font("SanSerif",Font.BOLD ,20));
        
        
        
        
                
        
        
        
        setVisible(true);
        
    }
    
    
    public void setBackToMenuListener(ActionListener l){
        this.back.addActionListener(l);
    }
    
    
    
}
