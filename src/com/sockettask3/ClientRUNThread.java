package com.sockettask3;

public class ClientRUNThread {

	public static void main(String[] args) {
		Client[] cli = new Client[10];
		for (int i = 0; i < 10; i++) {
			cli[i] = new Client(i, null, null, null, null);
			cli[i].start();
		}
	}

}
