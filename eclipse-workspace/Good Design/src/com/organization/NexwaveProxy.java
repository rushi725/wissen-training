package com.organization;

class Nexwave{
	public void doLearn() {
		System.out.println("learning");
	}
	public void doLab() {
		System.out.println("doing lab");
	}
}

public class NexwaveProxy extends Nexwave {
	NexwaveSecurity se = new NexwaveSecurity();
	
	
	public void doLearn() {
		se.authenticate();
		se.login();
		super.doLearn();
		se.logout();
	}
	public void doLab() {
		se.authenticate();
		se.login();
		super.doLab();
		se.logout();
	}
	
}
