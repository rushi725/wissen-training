package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApp {
	
	public static void sendRequest() {
		
		while(true) {
			try {
				Socket socket = new Socket("localhost", 8181);
		
				OutputStream out = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(out);
				Scanner sc = new Scanner(System.in);
				System.out.print("Client: ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String input = sc.nextLine();
				oos.writeObject(input);
		
				InputStream in = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(in);
				Object object = ois.readObject();
				String resp = (String) object;
				System.out.println("Server: " + resp);
				oos.close();
				ois.close();
				socket.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		
//		Runnable task = ()->{
//			sendRequest();
//		};
//		
//		ExecutorService executorService = Executors.newFixedThreadPool(100);
//		executorService.submit(task);
		
		sendRequest();
		
	}

}