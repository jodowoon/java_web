package sec01.ex01;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

abstract class Animal {
	abstract void cry();
}

class Cat extends Animal {
	void cry() {
		System.out.println("냐옹");
	}
}

public class Polymorphism02{
	public static void main (String[] args) {
		Cat c = new Cat();
		c.cry();
	}
}