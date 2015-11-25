package com.rcx.java8.lambda;

import java.awt.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testmain2 {
	public static void main(String[] args) {
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.",
				"Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase())
				.collect(Collectors.joining(", "));
		System.out.println(G7Countries);
	}

	@Override
	public String toString() {
		return "aaaa";
	}

	public void method() {
		Runnable runnable = () -> {
			System.out.println(this.toString());
		};
		new Thread(runnable).start();
	}
}
