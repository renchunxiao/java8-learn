package com.rcx.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;

import org.junit.Test;

public class TestMain {
	public static void main(String[] args) {
		Comparator<String> comparator = String::compareTo;

		Runnable runnable = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Callable<Void> callable = () -> {
			System.out.println("asd");
			return null;
		};

	}

	// @Test
	public void test() {
		BiFunction<String, String, Integer> biFunction = (first, second) -> {
			return first.length() + second.length();
		};

		int a = biFunction.apply("rcx", "123");

		System.out.println(a);
	}

	public void repeat(String string, int count) {
		Runnable runnable = () -> {
			for (int i = 0; i < count; i++) {
				System.out.println(this.toString());
			}
		};
		new Thread(runnable).start();
	}

	@Test
	public void rep2() {
		List<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");

		strings.forEach(System.out::print);
	}
}
