package com.app;

public class PencilDrawing extends AbstarctPainter implements Painter {
	@Override
	public void draw(String shape) {
		System.out.println("drawing " + shape + " using pencil...");
	}
}
