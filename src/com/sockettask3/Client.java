package com.sockettask3;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client extends Thread implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String payload;
	
	private String kata1;
	private String kata2;
	private String kata3;
	private String kata4;
	
	private Random rand;

	public Client(int num, String kata1, String kata2, String kata3, String kata4){
	        rand = new Random();
	        this.kata1 = kata1;
	        this.kata1 = kata2;
	        this.kata1 = kata3;
	        this.kata1 = kata4;
	    }

	public void run() {
		try {
			Socket sock = new Socket(InetAddress.getLocalHost(), (12345));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			for (int i = 0; i < 30; i++) {
				String random = Integer.toString(this.rand.nextInt());
				this.payload = "thread[" + this.kata1 + "]&" + random;
				this.payload = "thread[" + this.kata2 + "]&" + random;
				this.payload = "thread[" + this.kata3 + "]&" + random;
				this.payload = "thread[" + this.kata4 + "]&" + random;
				pw.write(this.payload);
				pw.write("\n");
				pw.flush();
			}
			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
