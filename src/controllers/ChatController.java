package controllers;

import java.io.IOException;
import client.Client;

public class ChatController implements Runnable {

	 private Client client;

	    public ChatController() {
	        this.client = new Client();
	    }
    @Override
    public void run() {
        
        try {
       	 
           while(true) {
               String response;
				try {
					this.client.initDataStreams();
					response = (String)client.getObjectInStream().readObject();
					System.out.println(response+"yes");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               //input.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
    
}
