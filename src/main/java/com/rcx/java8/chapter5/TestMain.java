package com.rcx.java8.chapter5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import org.junit.Test;

public class TestMain {

	// @Test
	public void test1() throws Exception {
		// Instant.now() 获取当前时间瞬时点
		Instant begin = Instant.now();
		System.out.println(begin);
		Thread.sleep(200);
		Instant end = Instant.now();
		System.out.println(end);

		// Duration表示两个瞬时点之间的持续时间
		Duration duration = Duration.between(begin, end);
		System.out.println(duration.toMillis());

		// 可以对 Duration 和 Instant 进行数学操作
		System.out.println(end.plusSeconds(20));
		System.out.println(duration.plusMillis(500).toMillis());
	}

	@Test
	public void test2() {
		// LocalDate.now() 获取本地今天日期
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		// LocalDate.of() 创建日期 2015-12-22
		LocalDate localDate2 = LocalDate.of(2015, 12, 22);
		System.out.println(localDate2);
		System.out.println(localDate2.plusDays(1));
		System.out.println(localDate.isBefore(localDate2));

	}
}
