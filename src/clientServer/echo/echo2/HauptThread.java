package clientServer.echo.echo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HauptThread extends Thread {
	
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(2222)) {
            while (true) {
                Socket s = serverSocket.accept();
                ClientThread cs = new ClientThread(s);
                cs.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
