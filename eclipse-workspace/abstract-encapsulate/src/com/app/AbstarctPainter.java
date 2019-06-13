package com.app;

abstract class AbstarctPainter implements Painter {
	public void fillColor(String color) {
		System.out.println("color filled");
	}
	public void erase() {
		System.out.println("Drawing erased");
	}
}
