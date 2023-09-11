package clientServer.echo.echo4;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket s;
	private InputStreamReader in;
	private OutputStreamWriter out;

	public ClientThread(Socket s) {this.s = s;}
	
	public void run() {
		try {
			in = new InputStreamReader(s.getInputStream(), "UTF-8");
			out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
			int zeichen;
			while ((zeichen = in.read()) != -1) {
				out.write((char) zeichen);
				out.flush();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
