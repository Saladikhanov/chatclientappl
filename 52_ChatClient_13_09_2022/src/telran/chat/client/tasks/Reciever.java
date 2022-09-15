package telran.chat.client.tasks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import telran.chat.model.Message;

public class Reciever implements Runnable {
    Socket socket;

    public Reciever(Socket socket) {
	this.socket = socket;
    }

    @Override
    public void run() {
	try {
	    Socket socket = this.socket;
	    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
	    while (true) {
		Message message = (Message) ois.readObject();
		System.out.println(message);
	    }
	} catch (IOException e) {
	    System.out.println(
		    "Connection to server" + socket.getInetAddress() + ":" + socket.getLocalPort() + " closed");
	   
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
