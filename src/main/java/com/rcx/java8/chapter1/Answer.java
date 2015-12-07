package com.rcx.java8.chapter1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @author renchunxiao
 */
public class Answer {

	// @Test
	public void question2() {
		File path = new File("/Users/renchunxiao/java8test");
		File[] dirs = path.listFiles(new FileFilter() {// 匿名内部类方式
					@Override
					public boolean accept(File pathname) {
						return pathname.isDirectory();
					}
				});
		for (File dir : dirs) {
			System.out.println(dir.getAbsolutePath());
		}
		System.out.println("===========我的华丽分割线===========");
		File[] dirs2 = path.listFiles(x -> {// lambda表达式方式
					return x.isDirectory();
				});
		for (File dir : dirs2) {
			System.out.println(dir.getAbsolutePath());
		}
		System.out.println("===========我的华丽分割线===========");
		File[] dirs3 = path.listFiles(File::isDirectory);// 方法引用
		for (File dir : dirs3) {
			System.out.println(dir.getAbsolutePath());
		}
	}

	// @Test
	public void question3() {
		File path = new File("/Users/renchunxiao/java8test");
		String suffix = "txt";
		File[] files = path.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String fileName) {
				return fileName.endsWith(suffix);
			}
		});
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("===========我的华丽分割线===========");
		File[] files1 = path.listFiles((dir, name) -> {
			return name.endsWith(suffix);
		});
		for (File file : files1) {
			System.out.println(file.getAbsolutePath());
		}
	}

	@Test
	public void question4() {
		File path = new File("/Users/renchunxiao/java8test");
		List<String> strings = Stream.of(path.listFiles()).map(file -> file.getName())
				.sorted((name1, name2) -> name1.length() - name2.length())
				.collect(Collectors.toList());
		strings.forEach(System.out::println);
	}
}