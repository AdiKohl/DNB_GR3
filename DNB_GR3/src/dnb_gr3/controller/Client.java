/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnb_gr3.controller;

import java.io.*;
import java.net.*;



/**
 *
 * @author PETERZ
 */
public class Client{
    
    private Socket client;
    private DataOutputStream outStream;
    private DataInputStream inStream;
    
    
    public Client (int port, String host){
        try{
            //BufferedReader keyStream = new BufferedReader(new InputStreamReader(System.in));
            client = new Socket(host,port);
            outStream = new DataOutputStream(client.getOutputStream());
            inStream = new DataInputStream(new DataInputStream(client.getInputStream()));
            //String line = inStream.readLine();
            //System.out.println(line);
            //line = keyStream.readLine();
            //outStream.println(line);
            //outStream.flush();
            //line = inStream.readLine();
            //System.out.println(line);
        }catch(IOException e){
            e.printStackTrace();}      
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
