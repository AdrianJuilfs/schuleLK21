package clientServer.echo.echo3;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class HauptThread extends Thread {

	
	@Override
	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(2222);){
			while (true) {
				Socket s = serverSocket.accept();
				ClientThread ct = new ClientThread(s);
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
