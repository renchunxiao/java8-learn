package com.rcx.java8.chapter2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

	@Test
	public void streamTOstream() {
		Stream<String> stream = Stream.of("a", "b", "c", "da", "asdass");
		Stream<String> stream2 = stream.filter(n -> n.length() > 3);
		Stream<String> stream3 = stream.map(String::toUpperCase);// map方法是对每个元素操作传入的函数
		Stream<Stream<Character>> stream4 = stream.map(w -> characterStream(w));
		//上面的结果是[['a'],['b'],['c'],['d','a'],['a','s' ...]]
		//如果我们想获得所有单词的字符 Stream<Character> 这个可以使用 flatMap 方法
		Stream<Character> stream5 =  stream.flatMap(w -> characterStream(w));
		//上面的结果是['a', 'b', 'c', 'd', 'd', ...]
	}
	
	@Test
	public void streamTOstream2() {
		Stream<Double> stream1 = Stream.generate(Math::random).limit(100);
		Stream<Double> stream2 = Stream.generate(Math::random).limit(100);
		Stream<Double> stream3 = Stream.concat(stream1, stream2);
		Stream<String> stream = Stream.of("a", "b", "c", "da", "asdass", "b");
		Stream<String> streamA = stream.distinct();//去重
		Stream<String> streamB = stream.sorted(Comparator.comparing(String::length));//排序
		
	}

	public static Stream<Character> characterStream(String string) {
		List<Character> result = new ArrayList<Character>();
		for (char c : string.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}

}
