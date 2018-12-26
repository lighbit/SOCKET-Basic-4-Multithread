package com.sockettask3;

/**
 * TODO: Task3(Random String) - @author zulkarnaen
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Client3 {
	public static void main(String[] args)
			throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

		// TODO: Dapatkan Koneksi ke Server.
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;

		// TODO: Dapatkan Objectoutputstream dan Objectinputstream.
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		int length = 5;
		// TODO: Buat String Array
		String[] karyawan = { "(1). MLPT1, 17/12/2018 10:35:53, 6", "(2). MLPT2, 18/12/2018 12:30:21, 7",
				"(3). MLPT3, 19/12/2018 01:40:10, 6", "(4). MLPT4, 20/12/2018 09:21:10, 7" };

		// TODO: Panggil Random Statement
		Random random = new Random();

		System.out.println("-----> Mengirim Request ke Socket Server. .\n");
		// TODO: Buat Perulangan
		for (int i = 0; i < length; i++) {
			// TODO: panggil socket dengan menarik host dari inetAddress.
			socket = new Socket(host.getHostName(), 5555);
			// TODO: write to socket using ObjectOutputStream
			oos = new ObjectOutputStream(socket.getOutputStream());

			if (i == 4)
				oos.writeObject("------------------> Selesai <-----------------");
			else
				System.out.println("-----> Data diterima!");
			oos.writeObject(
					" Karyawan baru diterima!\n" + "----> " + karyawan[random.nextInt(karyawan.length)] + " <----\n");
			// TODO: read the server response message
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("info: " + message + " ");
			// close resources
			ois.close();
			oos.close();
			System.out.println("Mencari Data Karyawan lagi. .\n");
			Thread.sleep(4000);
		}
		System.out.println("data tidak ditemukan!");
	}
}
