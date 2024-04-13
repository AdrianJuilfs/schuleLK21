package clientServer.dateiinhalte.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HaupThread extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                ServerSocket ses = new ServerSocket(6666);
                Socket s = ses.accept();
                ClientThread ct = new ClientThread(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
