package com.sockettask3;

import java.io.*;
import java.net.*;

public class Server3 {
	// static ServerSocket variable
	private static ServerSocket server;
	// socket server port on which it will listen
	private static int port = 5555;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		// create the socket server object
		server = new ServerSocket(port);
		// keep listens indefinitely until receives 'exit' call or program
		// terminates

		System.out.println("----> Menunggu Client. . .");
		while (true) {
			// creating socket and waiting for client connection
			Socket socket = server.accept();
			System.out.println("==================== INFO ====================\n");
			// read from socket to ObjectInputStream object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			// convert ObjectInputStream object to String
			String message = (String) ois.readObject();
			System.out.println(message);
			System.out.println("==============================================\n");

			// create ObjectOutputStream object
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			// write object to Socket
			oos.writeObject("Hi Server " + message);
			// close resources
			ois.close();
			oos.close();
			socket.close();
			// terminate the server if client sends exit request
			if (message.equalsIgnoreCase("------------------> Selesai <-----------------"))
				break;
		}
		System.out.println("\nData karyawan tidak ditemukan!");
		System.out.println("Server akan ditutup. . .");
		System.out.println("Server ditutup!");
		// close the ServerSocket object
		server.close();
	}

}
