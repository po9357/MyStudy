package com.mystudy.pm05_interface;

public class TypeTest {

	public static void main(String[] args) {
		//추상클래스 Animal은 객체 생성 할 수 없음
		//Animal an = new Animal();
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		Chicken ch = new Chicken();
		Pig pig = new Pig();
		Sheep sheep = new Sheep();
		
		cat.sound();
		dog.sound();
		ch.sound();
		pig.sound();
		sheep.sound();
		
		System.out.println("---- sound(Animal) 호출 --- ");
		sound(cat);
		sound(dog);
		sound(ch);
		sound(pig);
		sound(sheep);
	}
	
	private static void sound(I_Animal animal) {
		animal.sound();
	}

//	private static void sound(Cat cat) {
//		cat.sound();
//	}
}
