package clientServer.echo.echo3;

import java.net.Socket;
import java.io.*;

public class ClientThread extends Thread {
	
	Socket s;
	
	public ClientThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}
	@Override
	public void run() {
		try {
			InputStreamReader in = new InputStreamReader(s.getInputStream(), "UTF-8");
			OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
			int zeichen;
			while ((zeichen = in.read()) != -1) {
				out.write((char)zeichen);
				out.flush();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
