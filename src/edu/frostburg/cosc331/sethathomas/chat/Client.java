package edu.frostburg.cosc331.sethathomas.chat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a chat client
 *
 * @version 2015-23-3
 * @author Seth A. Thomas
 */
public class Client implements Runnable {

  private Socket client;
  private final String host;
  private final int port;
  private String nick;
  private final ChatGui chat;

  /**
   * Default constructor for Client
   *
   * @param host client host address
   * @param port Socket port
   */
  public Client(String host, int port, ChatGui chat, String nick) {
    this.host = host;
    this.port = port;
    this.nick = nick;
    this.chat = chat;
  }

  /**
   * Get client nick
   * @return nick
   */
  public String getNick() {
    return nick;
  }
  
  /**
   * Start Client
   */
  public void start() {
    System.out.println("Starting client...");
    try {
      
      // Instantiate Client and create reader
      client = new Socket(host, port);
      String line;
      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      
      // Read
      while ((line = br.readLine()) != null) {
	System.out.println("Client is reading: " + line);
	this.chat.getjTextAreaChatOutput().append(line + "\n");
      }

      //client.close();

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println("Unable to read file");
    } catch (UnknownHostException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Ugly way to stop client
   * @throws IOException 
   */
  public void stop() throws IOException {
    if(client != null)
      client.close();
  }
  
  /**
   * Broadcast message to server
   * @param message message to be broadcasted
   */
  public void broadcast(String message) {
    try {
      
      System.out.println(client.toString());
      
      PrintWriter pw = new PrintWriter(client.getOutputStream(), true);

      System.out.println("Client is sending: " + message);
      pw.println(message);
      this.chat.getjTextAreaChatOutput().append(message + "\n");
      
    } catch (IOException ex) {
      Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    start();
  }
}
