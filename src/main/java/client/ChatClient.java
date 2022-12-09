/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

/**
 *
 * @author 0802n
 */
public class ChatClient {
     public static void main(String[] args) {
         ConnectInputMessage connectToServer = new ConnectInputMessage();
         Thread tConnectInputMessage = new Thread(connectToServer);
         tConnectInputMessage.start();
         
         ReceiveMessageFromServer receiveMessage = 
                 new ReceiveMessageFromServer(connectToServer.getInputStreamServer());
         Thread tReceiveMessage = new Thread(receiveMessage);
         tReceiveMessage.start();
     }
}
