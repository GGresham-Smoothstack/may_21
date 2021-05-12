package com.ss.training.w1.d2.a3.shapes;

public class Rectangle implements Shape{
	
	private int width, height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String calculateArea() {
		return "The area of this rectangle is " + (width*height) + " square feet.";
	}

	@Override
	public void display() {
		System.out.println(calculateArea());
	}

}
