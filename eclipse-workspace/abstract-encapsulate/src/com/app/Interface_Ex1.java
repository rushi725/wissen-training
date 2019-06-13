package com.app;

public interface Interface_Ex1 {
	public static void main(String[] args) {
		Painter painter  = new PencilDrawing();
		painter.draw("Circle");
		painter.fillColor("Blue");
		painter.erase();
		
		painter = new PenDrawing();
		painter.draw("Square");
		painter.fillColor("Red");
		painter.erase();
		
	}
	
}
