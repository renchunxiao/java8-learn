package com.rcx.java8.chapter2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamAPITest {

	// @Test
	public void createStream() {
		Stream<String> stream = Stream.of("a", "b");
		Stream<String> stream2 = Stream.empty();
		Stream<String> stream3 = Stream.generate(() -> "aaa");// generate方法生产一个无限的Stream
		Stream<Double> stream4 = Stream.generate(Math::random);
		Stream<BigInteger> stream5 = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));// iterate方法生产一个无限的Stream
	}

	// @Test
	public void streamTOstream() {
		Stream<String> stream = Stream.of("a", "b", "c", "da", "asdass");
		Stream<String> stream2 = stream.filter(n -> n.length() > 3);
		Stream<String> stream3 = stream.map(String::toUpperCase);// map方法是对每个元素操作传入的函数
		Stream<Stream<Character>> stream4 = stream.map(w -> characterStream(w));
		// 上面的结果是[['a'],['b'],['c'],['d','a'],['a','s' ...]]
		// 如果我们想获得所有单词的字符 Stream<Character> 这个可以使用 flatMap 方法
		Stream<Character> stream5 = stream.flatMap(w -> characterStream(w));
		// 上面的结果是['a', 'b', 'c', 'd', 'd', ...]
	}

	// @Test
	public void streamTOstream2() {
		Stream<Double> stream1 = Stream.generate(Math::random).limit(100);
		Stream<Double> stream2 = Stream.generate(Math::random).limit(100);
		Stream<Double> stream3 = Stream.concat(stream1, stream2);
		Stream<String> stream = Stream.of("a", "b", "c", "da", "asdass", "b");
		Stream<String> streamA = stream.distinct();// 去重
		Stream<String> streamB = stream.sorted(Comparator.comparing(String::length));// 排序

	}

	// @Test
	public void streamJuHe() {
		long count = Stream.of("a", "b", "c", "da", "asdass").count();
		System.out.println(count);
		Optional<String> max = Stream.of("a", "b", "c", "da", "asdass").max(
				String::compareToIgnoreCase);
		Optional<String> min = Stream.of("a", "b", "c", "da", "asdass").min(
				String::compareToIgnoreCase);
		System.out.println(max.get());
		System.out.println(min.get());
		Optional<String> first = Stream.of("a", "b", "c", "da", "asdass").findFirst();
		System.out.println(first.get());
		Optional<String> any = Stream.of("a", "b", "c", "da", "asdass")
				.filter(s -> s.startsWith("a")).findAny();// 匹配任何一个，可以使用
															// parallel 方法并行处理
		System.out.println(any.get());
	}

	// @Test
	public void optionalTest() {
		Optional<String> max = Stream.of("a", "b", "c", "da", "asdass").max(
				String::compareToIgnoreCase);
		max.ifPresent(System.out::print);
		List<String> reList = new ArrayList<String>();
		Optional<Boolean> added = max.map(reList::add);
		max.orElse("default");// 如果max不存在值返回默认值
		max.orElseGet(() -> "empty");
		max.orElseThrow(RuntimeException::new);

		Optional<String> optional = Optional.of("ads");
		Optional<String> optional2 = Optional.empty();
	}

	// @Test
	public void juhe() {
		Stream<Integer> values = Stream.of(1, 3, 5, 6, 7);
		Optional<Integer> sum = values.reduce(Integer::sum);
		Optional<Integer> sum1 = values.reduce((x, y) -> x + y);
		System.out.println(sum.get());
		System.out.println(sum1.get());
		Integer sum2 = values.reduce(0, Integer::sum);

	}

	@Test
	public void getResult() {
		Stream<String> stream = Stream.of("a", "b", "c", "da", "asdass");
		String[] arr = stream.toArray(String[]::new);
		HashSet<String> set = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println(set);
		Set<String> set1 = stream.collect(Collectors.toSet());// 相当于上边的
		List<String> list = stream.collect(Collectors.toList());
		String string = stream.collect(Collectors.joining());
		String string1 = stream.collect(Collectors.joining(","));
	}

	public static Stream<Character> characterStream(String string) {
		List<Character> result = new ArrayList<Character>();
		for (char c : string.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}

}