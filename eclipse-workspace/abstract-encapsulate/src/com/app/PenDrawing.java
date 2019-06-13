package com.app;

public class PenDrawing extends AbstarctPainter implements Painter {
	@Override
	public void draw(String shape) {
		System.out.println("Drawing " + shape +" using pen....");
	}

}
