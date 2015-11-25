package com.rcx.java8.lambda;

public interface Person {
	long getID();

	default String getName() {
		return "name";
	}
}
