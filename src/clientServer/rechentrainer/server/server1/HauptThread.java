package clientServer.rechentrainer.server.server1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class HauptThread extends Thread {


    public void run() {
        try (ServerSocket st = new ServerSocket(33333)) {
            while (true) {
                Socket s = st.accept();
                ClientThread ct = new ClientThread(s);
                ct.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
