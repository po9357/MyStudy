package com.mystudy.generics;
import java.util.ArrayList;

class Fruit extends FruitBox implements Eatable{
	public String toString() { return "Fruit";}
}

class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}
class Toy				  { public String toString() { return "Toy"; }}

interface Eatable {}

class FruitBoxEx2 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>();
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-"+ fruitBox);
		System.out.println("appleBox-"+ appleBox);
		System.out.println("grapeBox-"+ grapeBox);
		
		Apple ap = new Apple();
		ap.add("사과");
		System.out.println(ap.toString());
		Box<String> box = new Box<String>();
		System.out.println(box.toString());
		box.add("박스");
		System.out.println(box.toString());
		System.out.println(ap.get(0));
		
		
	}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item)	{ list.add(item);		}
	T get (int i)		{ return list.get(i);	}
	int size()			{ return list.size();	}
	public String toString()	{ return list.toString(); }
}


