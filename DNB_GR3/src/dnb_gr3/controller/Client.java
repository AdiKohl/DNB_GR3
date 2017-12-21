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
    private PrintWriter outStream;
    private BufferedReader inStream;
    
    
    public Client (int port, String host){
        try{
            //BufferedReader keyStream = new BufferedReader(new InputStreamReader(System.in));
            client = new Socket(host,port);
            outStream = new PrintWriter(client.getOutputStream());
            inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
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
}
