package edu.frostburg.cosc331.sethathomas.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a Server to respond to the Client
 *
 * @version 2015-23-3
 * @author Seth A. Thomas
 */
public class Server implements Runnable {

  private final int port;
  private ServerSocket s;
  private ExecutorService pool;
  public List<Socket> clientList;
  private boolean isRunning = true;
  private final ChatGui chat;
  private String nick;

  /**
   * Default Constructor for Server
   *
   * @param port ServerSocket port used by the server
   */
  public Server(int port, ChatGui chat, String nick) {
    this.port = port;
    this.clientList = Collections.synchronizedList(new ArrayList<Socket>());
    this.chat = chat;
    this.nick = nick;
  }
  
  /**
   * Get reference to ChatGui
   * @return chat
   */
  public ChatGui getChat() {
    return chat;
  }

  /**
   * Get Server nick
   * @return nick
   */
  public String getNick() {
    return nick;
  }

  /**
   * Start Server
   */
  public void start() {
    System.out.println("Starting server...");
    isRunning = true;
    pool = Executors.newCachedThreadPool();
    try {
      s = new ServerSocket(port);
      ClientHandler worker;

      while (isRunning) {
	Socket client = s.accept();
	worker = new ClientHandler(client, this);
	clientList.add(client);
	pool.execute(worker);
      }
    } 
    catch (IOException ex) {
      Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
      pool.shutdown();
      isRunning = false;
    }
  }
  
  /**
   * Ugly way to stop server
   * @throws IOException 
   */
  public void stop() throws IOException {
    if(s != null)
      s.close();
  }
  
  /**
   * Broadcast message to clients
   * @param message message to be broadcasted
   */
  public void broadcast(String message) {
    try {
      for(Socket sock: clientList) {
	System.out.println(sock.toString());
	PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
	pw.println(message);
      }
      this.chat.getjTextAreaChatOutput().append(message + "\n");
    } catch (IOException ex) {
      Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Broadcast message to all clients excluding one
   * @param message message to be broadcasted
   * @param op excluded client
   */
  public void broadcast(String message, Socket op) {
    try {
      for(Socket sock: clientList) {
	if(sock != op) {
	  PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
	  pw.println(message);
	}
      }
    } catch (IOException ex) {
      Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    start();
  }
}
