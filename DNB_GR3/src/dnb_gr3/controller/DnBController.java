/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.controller;
//import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import dnb_gr3.model.MapModel;
import dnb_gr3.model.Owner;
import dnb_gr3.view.*;
//import prg2hs17_gr3_dnb.view;

/**
 *
 * @author Adi
 */
public class DnBController {

    private MapModel map;
    private MenuFrame menu;
    
    //private int sizeX;
    //private int sizeY;
    private int row;
    private int col;
    private int xCell;
    private int yCell;
    private final int tol = 10;
    private int bor;
    private Owner playerPlaying;
    private boolean areaSet = false;
    Client client;
    Server server;
    

    public DnBController() {
        
        this.playerPlaying = Owner.GUEST;
        this.map = new MapModel();
        //EventQueue.invokeLater(() -> new MenuFrame());
        this.menu = new MenuFrame();
        addMenuListeners();
        //this.map.setArea(2,1,Owner.GUEST);
    }
    
    public void evaluateClick(int x, int y){
        // Berechnung der Zelle
        this.col = (x-this.menu.getMainFrame().getPlayField().getBorderDist())/this.menu.getMainFrame().getPlayField().getPointDist();
        if(col==3) col=2;
        //System.out.println("Column:" + col);
        this.row = (y-this.menu.getMainFrame().getPlayField().getBorderDist())/this.menu.getMainFrame().getPlayField().getPointDist();
        if(row==3) row=2;
        //System.out.println("Row:" + row);
        System.out.print("Cell: [" + col + "/" + row + "]");
        
        //Berechnung der Koordinaten innerhalb der Zelle
        this.xCell = x-this.menu.getMainFrame().getPlayField().getBorderDist()-col*this.menu.getMainFrame().getPlayField().getPointDist();
        //System.out.println("xCell: " + xCell);
        this.yCell = y-this.menu.getMainFrame().getPlayField().getBorderDist()-row*this.menu.getMainFrame().getPlayField().getPointDist();
        //System.out.println("yCell: " + yCell);
        System.out.print("Coords: " + this.xCell + "/" + this.yCell);
        
        //Enstprechende Border-Wahl: W=1,N=2,E=3,S=4, Keine = 0;
        if(xCell<=tol) bor = 1;
        else if (yCell<=tol) bor = 2;
        else if (xCell >= this.menu.getMainFrame().getPlayField().getPointDist()-tol) bor = 3;
        else if (yCell >= this.menu.getMainFrame().getPlayField().getPointDist()-tol) bor = 4;
        else bor = 0;
        
        System.out.println(" Border: " + this.bor + " (That was a " + this.map.getBorder(col, row, bor) + "-Border!)");
        
        
        
        
        whosTurn(col,row,bor, playerPlaying);
        //whosTurn();
        manipulateModel(col,row,bor,playerPlaying);
        drawView(col,row,bor);
        
        
    }
    
    public void manipulateModel(int x, int y, int b, Owner o){
        if (this.map.getBorder(x,y,b)!= Owner.VOID) b=0;
        if(b==1){
            areaSet = false;
            this.map.setBorderW(x,y,o);
            if(this.map.checkArea(x, y)){ this.map.setArea(x, y, o); areaSet=true;}
            
            if(x>0){
                this.map.setBorderE(x-1,y,o);
                if(this.map.checkArea(x-1, y)){ this.map.setArea(x-1, y, o); areaSet=true;}
            }
        }
        
        else if (b==2){
            areaSet = false;
            this.map.setBorderN(x,y,o);
            if(this.map.checkArea(x, y)){ this.map.setArea(x, y, o); areaSet=true;}
            if(y>0){
                this.map.setBorderS(x,y-1,o);
                if(this.map.checkArea(x, y-1)){ this.map.setArea(x, y-1, o); areaSet=true;}
            }   
        }
        
        else if (b==3){
            areaSet = false;
            this.map.setBorderE(x,y,o);
            if(this.map.checkArea(x, y)){ this.map.setArea(x, y, o); areaSet=true;}
            if(x<2){
                this.map.setBorderW(x+1,y,o);
                if(this.map.checkArea(x+1, y)){this.map.setArea(x+1, y, o); areaSet=true;}
            }    
        }
        
        else if (b==4){
            areaSet = false;
            this.map.setBorderS(x,y,o);
            if(this.map.checkArea(x, y)){ this.map.setArea(x, y, o); areaSet=true;}
            if(y<2){
                this.map.setBorderN(x,y+1,o);
                if(this.map.checkArea(x, y+1)){ this.map.setArea(x, y+1, o); areaSet=true;}
            }
             
        }
        
        this.map.printMap();
    }

    public void drawView(int x, int y, int b){
        // Draw Borders
        this.menu.getMainFrame().getPlayField().drawBorder(x,y,b, this.map.getBorder(x,y,b));
        // Draw Boxes
        for (int i = 0; i < this.menu.getMainFrame().getPlayField().getPointsX()-1; i++) {
            for (int j = 0; j < this.menu.getMainFrame().getPlayField().getPointsY()-1; j++) {
                this.menu.getMainFrame().getPlayField().drawBox(i,j,this.map.getArea(i,j));
            }
        }
        // Update Score
        this.menu.getMainFrame().setHostpoints(this.map.getPointsHost());
        this.menu.getMainFrame().setGuestpoints(this.map.getPointsGuest());
        
        // Evaluate Winner
        if(this.map.getPointsHost()+this.map.getPointsGuest() == 9){
            if(this.map.getPointsHost() > this.map.getPointsGuest()){
                //put label to host as winner
                this.menu.getMainFrame().setEndtext("YOU WON!");
            }
            else {
                //put label to guest as winner
                this.menu.getMainFrame().setEndtext("OPONENT WON!");
            }
        }
        
        
    }
    
    public void whosTurn(int x, int y, int b, Owner o){
        if (b!=0 && areaSet==false){
            if(this.map.getBorder(x,y,b)==Owner.VOID && o == Owner.GUEST) this.playerPlaying = Owner.HOST;
            else if(this.map.getBorder(x,y,b)==Owner.VOID && o == Owner.HOST) this.playerPlaying = Owner.GUEST;
            
        }
        
        
    }
    public void whosTurn(){
        if(this.playerPlaying == Owner.GUEST) this.playerPlaying = Owner.HOST;
        if(this.playerPlaying == Owner.HOST) this.playerPlaying = Owner.GUEST;
        
        
    }
    
    
    public void addMenuListeners(){
        this.menu.setCreditsListener(new ButtonCreditsListener());
        this.menu.setSingleplayerListener(new ButtonSingleplayerListener());
        this.menu.setMultiplayerListener(new ButtonMultiplayerListener());
        this.menu.setQuitListener(new ButtonQuitListener());
    }
    
    public void addSingleListener() {
        menu.getMainFrame().setMouseListener(new MousePFListener());
        menu.getMainFrame().setBackToMenuListener(new ButtonSingleToMenuListener());
    }
    
    public void addMultiListener() {
        //menu.getMainFrame().setMouseListener(new MousePFListener());
        menu.getMultiFrame().setBackToMenuListener(new ButtonMultiToMenuListener());
        menu.getMultiFrame().setJoinListener(new ButtonMultiJoinListener());
        menu.getMultiFrame().setHostListener(new ButtonMultiHostListener());
    }
    
    public void addCreditListener(){
        menu.getCreditFrame().setBackToMenuListener(new ButtonCreditToMenuListener());
        
    }

    public void printMap() {
        this.map.printMap();
    }

    
/* MAIN MENU ACTION LISTENERS */
    
    class ButtonSingleplayerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        if(menu.getMainFrame()==null) menu.setMainFrame(new MainFrame());
        menu.getMainFrame().setVisible(true);
        menu.setVisible(false);
        addSingleListener();
        System.out.println("Singleplayer!");
        }
    }
    
    class ButtonMultiplayerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        if(menu.getMultiFrame()==null) menu.setMultiFrame(new MultiFrame());
        menu.getMultiFrame().setVisible(true);
        menu.setVisible(false);
        addMultiListener();
        System.out.println("Multiplayer!");
        }
    }
    
    class ButtonCreditsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        if(menu.getCreditFrame()==null)menu.setCreditFrame(new Credits());
        menu.getCreditFrame().setVisible(true);
        //menu.setVisible(false);
        addCreditListener();
        System.out.println("Credits!");
        }
    }
    
    class ButtonQuitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        System.exit(0);
        }
    }
    
/* SINGLE PLAYER ACTION LISTENERS  */
    
    class MousePFListener implements MouseListener {
        
        @Override
        public void mouseExited(MouseEvent e){}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseClicked(MouseEvent e){
            System.out.println("that was a click! at x: " + e.getX() + " and y: " + e.getY());
            evaluateClick(e.getX(),e.getY());
        }
        
    }

    class ButtonSingleToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        menu.getMainFrame().setVisible(false);
        menu.setVisible(true);
        }
    }
    
    
/* MULTIPLAYER MENU LISTENERS */
    class ButtonMultiToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        menu.getMultiFrame().setVisible(false);
        menu.setVisible(true);
        }
    }

    class ButtonMultiHostListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        server = new Server(menu.getMultiFrame().getPort());
        System.out.println("Client connected");
        if(menu.getMainFrame()==null) menu.setMainFrame(new MainFrame());
        menu.getMainFrame().setVisible(true);
        menu.getMultiFrame().setVisible(false);
        addSingleListener();
        }
    } 

    class ButtonMultiJoinListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        client = new Client(menu.getMultiFrame().getPort(), menu.getMultiFrame().getIP());
        System.out.println("Joined!");
        if(menu.getMainFrame()==null) menu.setMainFrame(new MainFrame());
        menu.getMainFrame().setVisible(true);
        menu.getMultiFrame().setVisible(false);
        addSingleListener();
        }
    } 
    
/* CREDITS ACTION LISTENER */

    class ButtonCreditToMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        menu.getCreditFrame().setVisible(false);
        menu.setVisible(true);
        }
    }
    

}
