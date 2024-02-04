package clientServer.rechentrainer.server.server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientThread extends Thread {


    public void run() {
        while (true) {
            try {
                ServerSocket server = new ServerSocket(33333);
                Socket s = server.accept();
                ServerThread st = new ServerThread(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
