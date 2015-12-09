package com.rcx.java8;

import java.util.Optional;

public class TestMain {

	public static void main(String[] args) {
		
		Optional<String> sOptional = Optional.of("rcx");
		System.out.println(sOptional.get());
	}
}
