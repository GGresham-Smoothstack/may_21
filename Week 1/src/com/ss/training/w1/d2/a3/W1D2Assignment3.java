package com.ss.training.w1.d2.a3;

import com.ss.training.w1.d2.a3.shapes.Circle;
import com.ss.training.w1.d2.a3.shapes.Rectangle;
import com.ss.training.w1.d2.a3.shapes.Triangle;
import com.ss.training.w1.d2.a3.shapes.Shape;

public class W1D2Assignment3 {

	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[3];
		
		shapes[0] = new Rectangle(6, 8);
		shapes[1] = new Circle(5);
		shapes[2] = new Triangle(10, 8);
		
		for(Shape shape : shapes) {
			shape.display();
		}

	}

}
