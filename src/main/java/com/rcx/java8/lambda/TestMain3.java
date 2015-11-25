package com.rcx.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.rcx.java8.lambda.bean.User;

public class TestMain3 {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("1", "rcx1"));
		users.add(new User("2", "rcx2"));
		users.add(new User("3", "rcx3"));
		users.add(new User("4", "rcx4"));

		Map<String, User> map = users.stream().collect(
				Collectors.toMap(User::getId, Function.identity()));
		System.out.println(map);
	}
}
