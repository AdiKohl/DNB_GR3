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
public class MapModel {
    
    int xsize;
    int ysize;
    int pointsGuest = 0;
    int pointsHost = 0;
    Tile[][] tiles;

    public MapModel() {
        this(3,3);        
    }

    public MapModel(int xsize, int ysize) {
        this.xsize = xsize;
        this.ysize = ysize;
        // Erstelle 2D-Array
        tiles = new Tile[xsize][ysize];
        // Erstelle Tiles innerhalb des Arrays
        for(int i=0; i < xsize; i++){
            for(int j = 0; j < ysize; j++){
                tiles[i][j] = new Tile();
                tiles[i][j].setID("X" + i + "Y" + j);
                tiles[i][j].setNeighborN((j-1<0) ? null : tiles[j-1][i]);
                tiles[i][j].setNeighborE((i+1>=xsize) ? null : tiles[j][i+1]);
                tiles[i][j].setNeighborS((j+1>=ysize) ? null : tiles[j+1][i]);
                tiles[i][j].setNeighborW((i-1<0) ? null : tiles[j][i-1]);
                
                
            }
        }
        //this.map[2][1].setBorderN(Owner.HOST);
    }
    
    public void setBorderN(int x, int y, Owner owner){
        this.tiles[x][y].setBorderN(owner);
    }
    public Owner getBorderN(int x, int y){
        return this.tiles[x][y].getBorderN();
    }
    
    public void setBorderE(int x, int y, Owner owner){
        this.tiles[x][y].setBorderE(owner);    
    }
    public Owner getBorderE(int x, int y){
        return this.tiles[x][y].getBorderE();
    }
    
    public void setBorderS(int x, int y, Owner owner){
        this.tiles[x][y].setBorderS(owner);         
    }
    public Owner getBorderS(int x, int y){
        return this.tiles[x][y].getBorderS();
    }
    
    public void setBorderW(int x, int y, Owner owner){
        this.tiles[x][y].setBorderW(owner);    
    }
    public Owner getBorderW(int x, int y){
        return this.tiles[x][y].getBorderW();
    }
    
    public Owner getBorder(int x, int y, int b) {
        
            if (b==1)return getBorderW(x,y);
            else if (b==2) return getBorderN(x,y);
            else if (b==3) return getBorderE(x,y);
            else return getBorderS(x,y);
    }
    
    public void setArea(int x, int y, Owner owner){
        this.tiles[x][y].setArea(owner);
        if (owner == Owner.GUEST) pointsGuest++;
        if (owner == Owner.HOST) pointsHost++;
    }
    
    public Owner getArea(int x, int y){
        return this.tiles[x][y].getArea();
    }
    
    public boolean checkArea(int x, int y){
        if((this.tiles[x][y].getBorderW()!=Owner.VOID && this.tiles[x][y].getBorderN()!=Owner.VOID && this.tiles[x][y].getBorderE()!=Owner.VOID && this.tiles[x][y].getBorderS()!=Owner.VOID) && this.tiles[x][y].getArea()==Owner.VOID){
            return true;
        }
        return false;
    }

    public int getPointsGuest() {
        return pointsGuest;
    }

    public int getPointsHost() {
        return pointsHost;
    }
    
    
    
    public void printTile(int x, int y){
        
        System.out.print(this.tiles[x][y].getID() + " ");
        /*
        System.out.print("Area: " + tiles[x][y].getArea());
        System.out.print(" | NN: " + tiles[x][y].getNeighborN());
        */  
        System.out.print(this.tiles[x][y].getBorderW());
        System.out.print(this.tiles[x][y].getBorderN());
        System.out.print(this.tiles[x][y].getBorderE());
        System.out.print(this.tiles[x][y].getBorderS());
        
    }
    
    public void printMap(){
        for(int i=0; i < xsize; i++){
            
            for(int j = 0; j < ysize; j++){
                
                printTile(i,j);
                System.out.println("");
            }
            System.out.println("");
                    
        }
    }
    
    
    
    
    
    
    
    
}
