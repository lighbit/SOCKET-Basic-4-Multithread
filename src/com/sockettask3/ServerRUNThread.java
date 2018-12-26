package com.sockettask3;

public class ServerRUNThread {

	public static void main(String[] args) {
		Server[] serv = new Server[10];
		for (int i = 0; i < 10; i++) {
			serv[i] = new Server(12345 + i);
			serv[i].start();
		}
	}

}
