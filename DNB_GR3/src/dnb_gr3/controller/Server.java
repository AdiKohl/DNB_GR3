/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.controller;

import java.net.*;
import java.io.*;

/**
 *
 * @author PETERZ
 */
public class Server{
    private ServerSocket s;
    private DataOutputStream outStream;
    private DataInputStream inStream;

    public Server(int port){
        try{
            s = new ServerSocket(port);
            System.out.println("Warten auf Verbindung ...");
            Socket client = s.accept();
            System.out.println(client + " akzeptiert...");
            outStream = new DataOutputStream(client.getOutputStream());
            inStream = new DataInputStream(new DataInputStream(client.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public DataOutputStream getOutStream() {
        return outStream;
    }

    public void setOutStream(DataOutputStream outStream) {
        this.outStream = outStream;
    }

    public DataInputStream getInStream() {
        return inStream;
    }

    public void setInStream(DataInputStream inStream) {
        this.inStream = inStream;
    }
    
    
}


