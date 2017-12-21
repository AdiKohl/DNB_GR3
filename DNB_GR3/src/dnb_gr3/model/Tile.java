/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.model;

/**
 *
 * @author Adi
 */



public class Tile {
    
    private String ID;
    
    private Owner borderN;
    private Owner borderE;
    private Owner borderS;
    private Owner borderW;
    private Owner area;
    
    private Tile neighborN;
    private Tile neighborE;
    private Tile neighborS;
    private Tile neighborW;
    
    

    public Tile() {
        
        
        this.ID = "ID";
        this.borderN = Owner.VOID;
        this.borderE = Owner.VOID;
        this.borderS = Owner.VOID;
        this.borderW = Owner.VOID;
        this.area = Owner.VOID;
        this.neighborN = null;
        this.neighborE = null;
        this.neighborS = null;
        this.neighborW = null;
        
    }

    public Owner getBorderN() {
        return borderN;
    }

    public void setBorderN(Owner borderN) {
        this.borderN = borderN;
    }

    public Owner getBorderE() {
        return borderE;
    }

    public void setBorderE(Owner borderE) {
        this.borderE = borderE;
    }

    public Owner getBorderS() {
        return borderS;
    }

    public void setBorderS(Owner borderS) {
        this.borderS = borderS;
    }

    public Owner getBorderW() {
        return borderW;
    }

    public void setBorderW(Owner borderW) {
        this.borderW = borderW;
    }

    public Owner getArea() {
        return area;
    }

    public void setArea(Owner area) {
        this.area = area;
    }

    public Tile getNeighborN() {
        return neighborN;
    }

    public void setNeighborN(Tile neighborN) {
        this.neighborN = neighborN;
    }

    public Tile getNeighborE() {
        return neighborE;
    }

    public void setNeighborE(Tile neighborE) {
        this.neighborE = neighborE;
    }

    public Tile getNeighborS() {
        return neighborS;
    }

    public void setNeighborS(Tile neighborS) {
        this.neighborS = neighborS;
    }

    public Tile getNeighborW() {
        return neighborW;
    }

    public void setNeighborW(Tile neighborW) {
        this.neighborW = neighborW;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
    
    
    
    
}
