package clientServer.reverse2;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {

	private Socket s;
	private InputStreamReader in;
	private OutputStreamWriter out;

	public ClientThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	public void run() {
		try {
			in = new InputStreamReader(s.getInputStream(), "UTF-8");
			out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
			int zeichen;
			String ausgabe="";
			while ((zeichen = in.read()) != -1) {
				if ((char) zeichen != '§') {
					ausgabe = (char) zeichen + ausgabe;
				} else {
					out.write(ausgabe + System.lineSeparator());
					out.flush();
					ausgabe = "";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
