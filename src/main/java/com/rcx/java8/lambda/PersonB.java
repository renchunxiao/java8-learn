package com.rcx.java8.lambda;

public class PersonB implements Person1, Person {

	@Override
	public long getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Person1.super.getName();
	}

}