package com.ss.training.w1.d2.a3.shapes;

public class Triangle implements Shape{
	
	int base, height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public String calculateArea() {
		return "The area of this triangle is " + ((base*height)/2) + " square feet.";
	}

	@Override
	public void display() {
		System.out.println(calculateArea());
	}

}
