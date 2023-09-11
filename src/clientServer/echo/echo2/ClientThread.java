package clientServer.echo.echo2;

import java.io.*;
import java.net.*;

public class ClientThread extends Thread {
    private Socket s;
    private InputStreamReader in;
    private OutputStreamWriter out;

    public ClientThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            int zeichen;
            in = new InputStreamReader(s.getInputStream(),"UTF-8");
            out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            while ((zeichen = in.read()) != -1) {
                out.write(zeichen);
                out.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}