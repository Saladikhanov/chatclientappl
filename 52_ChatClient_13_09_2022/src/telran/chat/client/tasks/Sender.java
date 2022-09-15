package telran.chat.client.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;

import telran.chat.model.Message;

public class Sender implements Runnable {
    Socket socket;
    

    public Sender(Socket socket) {
	this.socket = socket;
    }

   

    @Override
    public void run() {
	try (Socket socket = this.socket) {
	    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter name");
	   String nickName = br.readLine();
	    
	    System.out.println("Enter message or exit");
	    String message = br.readLine();
	    Message msg = new Message(nickName, message);
//	    msg.setMessage(message);
	    while (!"exit".equalsIgnoreCase(msg.getMessage())) {
		msg.setTime(LocalTime.now());
		msg.setMessage(message);
//		oos.writeUnshared(msg);
		oos.writeObject(msg);
		oos.reset();
		message = br.readLine();
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
