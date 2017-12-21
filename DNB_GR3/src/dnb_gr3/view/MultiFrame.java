/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Daniel Ouwehand
 */
public class MultiFrame extends JFrame {
    
    private final JLabel title = new JLabel("Multiplayer Menu");
    private final JButton host = new JButton("Host");
    private final JButton join = new JButton("Join");
    private JLabel ownIP = new JLabel("own IP adress");
    public JTextField writeIP = new JTextField();
    private JPanel panelMain = new JPanel();
    private final JButton backToMenu = new JButton("Back to menu");
    private JPanel panelSouth = new JPanel();
    private String myIp;
    private int myPort;
    
    
    

    public MultiFrame() {
        
        super("Dots and Boxes");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(new BorderLayout());
        
        panelMain.setLayout(new GridLayout(2,2,80,20));
        add(panelMain, BorderLayout.CENTER);
        add(title, BorderLayout.NORTH);
        add(panelSouth, BorderLayout.SOUTH);
        
        try {
        ServerSocket ss = new ServerSocket(0);
                    myPort = ss.getLocalPort();
                    InetAddress ipAddress = InetAddress.getLocalHost();
                    myIp = ipAddress.getHostAddress();
                    //s = ss.accept();
                    //in = new ObjectInputStream(s.getInputStream());
        }catch (IOException e) {
                    e.printStackTrace();
                }
        
        
        panelMain.add(host);        
        panelMain.add(join);
        panelMain.add(ownIP);
        panelMain.add(writeIP);
        
        panelSouth.add(backToMenu);
        panelSouth.setBorder(BorderFactory.createEmptyBorder(0, 500, 20, 0));
        
        
        panelMain.setBorder(BorderFactory.createEmptyBorder(140, 80, 160, 80));
        title.setBorder(BorderFactory.createEmptyBorder(20, 140, 0, 0));
        title.setFont(new Font("SanSerif",Font.BOLD ,50));
        ownIP.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        ownIP.setText(myIp + " : " + myPort);
      
        
        
        
        
        
        setVisible(true);        
        
    }
    
    public void setHostListener(ActionListener l){
        this.host.addActionListener(l);
    }
        
        
    public void setJoinListener(ActionListener l){
        this.join.addActionListener(l);
    }
    
    public void setBackToMenuListener(ActionListener l){
        this.backToMenu.addActionListener(l);
    }
    
    public int getPort(){
        //String ports = writePort.getText(); //Eingabefeld Port hinzufügen
        //int port = Integer.parseInt(ports);
        return 3010;    
    }
    
    public String getIP(){
        String ip = writeIP.getText();
        return ip;
    }
    
    
    
    
}
