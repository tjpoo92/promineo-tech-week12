package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	Random random = new Random();
	
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b; 
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public int addNegative(int a, int b) {
		if (a < 0 && b < 0){
			return a +b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be negative!");
		}
	}

	public int randomNumberSquared() {
		int a = getRandomInt();
		return a*a;
		
	}

	public int getRandomInt() {
		return random.nextInt(10);		
	}


}
