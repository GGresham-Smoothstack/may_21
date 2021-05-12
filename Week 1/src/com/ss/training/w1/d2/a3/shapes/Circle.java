package com.ss.training.w1.d2.a3.shapes;

public class Circle implements Shape{
	
	int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String calculateArea() {
		return "The area of this circle is " + (radius*2)*Math.PI + " square feet.";
	}

	@Override
	public void display() {
		System.out.println(calculateArea());
	}

}
