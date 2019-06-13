package com.organization;

public class NexwaveSecurity implements Security {
	
	public void authenticate() {
		System.out.println("Auth...");
	}
	public void login() {
		System.out.println("log :: in");
	}
	
	public void logout() {
		System.out.println("Log :: out");
	}
}

