/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author 0802n
 */
public class ReceiveMessageFromServer implements Runnable{
    
    private InputStream inputStreamServer;

    public ReceiveMessageFromServer(InputStream inputStreamServer) {
        this.inputStreamServer = inputStreamServer;
    }
    
    

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        
        while(true){
            try {
                serverMessage = in.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);        
            }
            
            if(serverMessage!= null){
                System.out.println(serverMessage + "\nEnter your message:");
            }
            
        }


    }
    
}
