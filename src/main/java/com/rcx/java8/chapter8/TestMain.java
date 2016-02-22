package com.rcx.java8.chapter8;

import org.junit.Test;

public class TestMain {

	
	@Test
	public void test() {
		System.out.println(String.join(", ", "a", "b", "c"));
		System.out.println(Integer.valueOf(10).hashCode());
		System.out.println(Integer.BYTES);//类型字节长度
		System.out.println(Integer.SIZE);//类型bit位数
		
	}
}
