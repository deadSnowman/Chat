package edu.frostburg.cosc331.sethathomas.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a client handler that will relay client responses to other clients
 * @version 2015-23-3
 * @author Seth A. Thomas
 */
public class ClientHandler implements Runnable {

  private final Socket client;
  private final Server serv;

  /**
   * Constructor for ClientHandler
   * @param client client socket
   * @param serv reference to server doing handling
   */
  public ClientHandler(Socket client, Server serv) {
    this.client = client;
    this.serv = serv;
  }

  @Override
  public void run() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      
      // Read and print
      String line;
      while ((line = br.readLine()) != null) {
	System.out.println("Server reading: " + line);
	serv.getChat().getjTextAreaChatOutput().append(line + "\n");
	
	// relay to all clients except source
	this.serv.broadcast(line, client);
      }

    } catch (IOException ex) {
      Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Broadcast message to clients
   * @param message message to be broadcasted
   */
  public void broadcast(String message) {
    this.serv.broadcast(message);
  }
}
