/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.main;

import dnb_gr3.controller.DnBController;
import dnb_gr3.view.*;
import java.awt.EventQueue;

/**
 *
 * @author Adi
 */
public class PRG2HS17_GR3_DNB {

    /**
     * @param args the command line arguments
     */
    static DnBController controller;
    
    public static void main(String[] args) {
        // TODO code application logic here
        controller = new DnBController();
        controller.printMap();  
    }
    
}
