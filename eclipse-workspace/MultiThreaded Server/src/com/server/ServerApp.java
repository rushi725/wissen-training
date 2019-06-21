package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// java.net.*

public class ServerApp {

	//private static int reqCount = 0;
	
	
	public static void processRequest(Socket socket) {

		try {
		System.out.println("accepted client request..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
				Object object;
				try {
					
					InputStream in = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(in);
					object = ois.readObject();
					String resp = (String) object;
					System.out.println("Client :" + resp);
					System.out.print("Server :");
					String input = br.readLine();
					OutputStream out = socket.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(out);
					oos.writeObject(input);
				}catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8181);
			while (true) {
				System.out.println("waiting for client request..");
				Socket socket = serverSocket.accept(); // accepts request
				
				Runnable task = ()->{
					processRequest(socket);
				};
				//processRequest(socket);
				ExecutorService executorService = Executors.newFixedThreadPool(100);
				executorService.submit(task);
				
				//System.out.println("respose sent back");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}