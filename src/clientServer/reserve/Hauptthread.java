package clientServer.reserve;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Hauptthread extends Thread {
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(11111)) {
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