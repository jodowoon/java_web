package com.spring.ex01;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		ArrayList<String> age = new ArrayList<String>();
		age.add("hu");
		ArrayList<Integer> age1 = new ArrayList<Integer>();
		age1.add(3);
		
		System.out.println("초기값 : " + age);
		age.add("hu1");
		System.out.println("초기값1 : " + age);
	}

}
