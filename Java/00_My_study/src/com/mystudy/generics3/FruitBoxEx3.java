package com.mystudy.generics3;

import java.util.ArrayList;

class Juice {
	String name;
	
	Juice(String name)			{ this.name = name + "Juice";	}
	public String toString()	{ return name;					}
}

class Juicer {
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		
		for (Fruit f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
public class FruitBoxEx3 {

	public static void main(String[] args) {
		FruitBox<Fruit>	fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple>	appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	}

}

class Fruit 		      { public String toString() { return "Fruit"; }}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}

class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	ArrayList<T> getList()		{ return list;   			}
	void add(T item)			{ list.add(item);			}
	T get (int i)				{ return list.get(i);		}
	int size()					{ return list.size();		}
	public String toString()	{ return list.toString();	}
}

