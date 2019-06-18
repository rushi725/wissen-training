package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FP_With_Exception_Handling {

	public static void fileWriter(String s) {
		File file = new File("log.txt");
	    FileWriter writer;
		try {
		 writer = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Consumer<String> fileWrite = log->fileWriter(log);
		Consumer<String> logWrite = log-> System.out.println(log);
		BiFunction<Consumer<String>,Consumer<String>,Consumer<String> > composed = (a,b) ->
		{
			return a.andThen(b);
		};
		
		
		Consumer<String> clc = composed.apply(fileWrite,logWrite);
		clc.accept("Hello World");
	}
}
