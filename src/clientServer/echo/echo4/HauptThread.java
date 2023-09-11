package clientServer.echo.echo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HauptThread extends Thread {

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(11111);
			while (true) {
				Socket s = server.accept();
				ClientThread ct = new ClientThread(s);
				ct.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
