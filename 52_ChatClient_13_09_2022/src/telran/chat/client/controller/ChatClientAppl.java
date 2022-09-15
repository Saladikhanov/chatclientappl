package telran.chat.client.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import telran.chat.client.tasks.Reciever;
import telran.chat.client.tasks.Sender;

public class ChatClientAppl {

    public static void main(String[] args) {
	String serverSocket = "127.0.0.1";
	int port = 9000;
	try {
	    Socket socket = new Socket(serverSocket, port);
	    Thread senderThread = new Thread(new Sender(socket));
	    Thread recieverThread = new Thread(new Reciever(socket));
//	    recieverThread.setDaemon(true);
	    recieverThread.start();
	    senderThread.start();

	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
