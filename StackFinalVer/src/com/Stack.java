package com;

import java.util.Random;

class StackIsOverflowing extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	

	public StackIsOverflowing(String msg) {
		super(msg);
	}
}

class StackIsUnderflowing extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	
	

	public StackIsUnderflowing(String msg) {
		super("Stack Underflowing");
	}
}
public class Stack {
	private int index;
	private int[] aStackArr ;
	private static final int  ZERO = 0;
	
	double randomGenerator(int max, int min) {
		Random generator = new Random();
	    return generator.nextInt(max - min) + min;
	}
public Stack(int size) {
	aStackArr = new int[size];
	this.index = -1;
}

public int size() {
	return index+1;
}
public void push(int anInt) {
	++index;
	try {
		if(this.index >= this.size()) {
			throw new StackIsOverflowing("Stack is overflowing");
		}else {
			aStackArr[index] = anInt;
		}
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}

public int pop() {
	
	try {
		if(this.index < Stack.ZERO) {
			throw new StackIsOverflowing("Stack is underflowing");
		}else {
			int result = aStackArr[index];
			--index;
			return result;
		}
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
		return -1;
	}
	
	
}

public int peek() {
	int tmpIdx = index - 1;
	return aStackArr[tmpIdx];
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack aStack = new Stack(10);
		int randomInt = 0;
		for(int i = 0; i < 10; ++i) {
			randomInt =(int) aStack.randomGenerator(10, 0);
			aStack.push(randomInt);
		}
		for(int i = 0; i < 10; ++i) {
			
			System.out.println(aStack.pop());
		}
	}

}
