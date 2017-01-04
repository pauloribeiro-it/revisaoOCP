package collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsTest {
	public static void main(String[] args) {
		Set<Dog> treeSet = new TreeSet<>();
//		Set<Dog> treeSet = new TreeSet<>(new DogComparator());
		treeSet.add(new Dog("Bob"));
	}
}

class Dog implements Comparable<Dog>{
	private String name;

	public Dog(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Dog o) {
		return this.name.compareTo(o.getName());
	}
	
}

class DogComparator implements Comparator<Dog>{
	public int compare(Dog o1, Dog o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class Cat {
}

enum Pets {
	DOG, CAT, HORSE
}
