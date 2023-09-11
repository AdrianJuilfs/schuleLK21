package clientServer.reverse2;

import java.io.IOException;
import java.net.*;

public class HauptThread extends Thread {

	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(11111)) {
			while (true) {
				Socket s = serverSocket.accept();
				ClientThread ct = new ClientThread(s);
				ct.start();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
