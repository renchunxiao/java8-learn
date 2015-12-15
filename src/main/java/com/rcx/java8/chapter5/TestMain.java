package com.rcx.java8.chapter5;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

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

	// @Test
	public void test2() {
		// LocalDate.now() 获取本地今天日期
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		// LocalDate.of() 创建日期 2015-12-22
		LocalDate localDate2 = LocalDate.of(2015, 12, 22);
		System.out.println(localDate2);
		System.out.println(localDate2.plusDays(1));
		System.out.println(localDate.isBefore(localDate2));
		LocalDate localDate3 = localDate2.plus(Period.ofDays(3));
		System.out.println(localDate.isBefore(localDate3));
		System.out.println(localDate2.until(localDate3, ChronoUnit.DAYS));// 日期的距离
		System.out.println(localDate3.getDayOfWeek());// 星期几
	}

	// @Test
	public void test3() {
		LocalDate localDate = LocalDate.of(2015, 1, 1).with(
				TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));// 从指定日期开始的后一个星期几
		System.out.println(localDate);
		LocalDate localDate2 = localDate.with(TemporalAdjusters.previous(DayOfWeek.TUESDAY));// 指定日期的前一个星期几
		LocalDate localDate3 = localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));// 指定日期的后一个星期几
		System.out.println(localDate2);
		System.out.println(localDate3);
		LocalDate localDate4 = localDate.with(TemporalAdjusters.dayOfWeekInMonth(3,
				DayOfWeek.TUESDAY));// 第三个周二
		System.out.println(localDate4);
		LocalDate localDate5 = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));
		System.out.println(localDate5);

		TemporalAdjuster Next_WorkDay = w -> {// 自定义校正器
			LocalDate resultDate = (LocalDate) w;
			do {
				resultDate = resultDate.plusDays(1);
			} while (resultDate.getDayOfWeek().getValue() >= 6);
			return resultDate;
		};
	}

	// @Test
	public void test4() {
		LocalTime localTime = LocalTime.now();
		LocalTime localTime2 = LocalTime.of(12, 24);
		System.out.println(localTime);
		System.out.println(localTime2);
		// 其他 api 与 LocalDate 类似
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime localDateTime2 = LocalDateTime.of(2015, 12, 22, 3, 14, 23);
		System.out.println(localDateTime);
		System.out.println(localDateTime2);
		// 其他 api 与 LocalDate 类似
	}

	@Test
	public void test5() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));// 预定义标准格式
		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));// 预定义标准格式

		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
				.format(localDateTime));// 语言相关格式
		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(
				localDateTime));// 语言相关格式
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(
				localDateTime));// 语言相关格式
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(
				localDateTime));// 语言相关格式，一般使用这个

		System.out
				.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(localDateTime));// 自定义
	}

}