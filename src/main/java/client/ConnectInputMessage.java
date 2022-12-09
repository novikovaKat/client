/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author 0802n
 */
public class ConnectInputMessage implements Runnable{
    
    private Socket serverConnect;
    private InputStream inputStreamServer;

    public ConnectInputMessage( ) {
        try {
            serverConnect = new Socket("localhost", 8887);
        } catch (IOException ex) {
            throw new RuntimeException(ex);        
        }
        try {
            inputStreamServer = serverConnect.getInputStream();
        } catch (IOException ex) {
            throw new RuntimeException(ex);        
        }
    }


    public InputStream getInputStreamServer() {
        return inputStreamServer;
    }

    public void setInputStreamServer(InputStream inputStreamServer) {
        this.inputStreamServer = inputStreamServer;
    }
    
    

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStreamServer));
        String serverMessage;
        
        while(true){
                       
            try {
                serverMessage = in.readLine();
                
                if(serverMessage!=null){
                    System.out.println(serverMessage);
                    break;
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        
        PrintWriter out;
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        
        String userMessage;
        
        do {
            System.out.println("Enter message: ");

            try {
                userMessage = inputUser.readLine();
                out = new PrintWriter(serverConnect.getOutputStream(), true);
                out.println(userMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!"exit".equals(userMessage));
            
    }
}
    
    

