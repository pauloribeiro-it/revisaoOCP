package generics;

import java.util.ArrayList;
import java.util.List;

public class AnimalDoctorGeneric {
	public void addAnimal(List<? extends Animal> animals) {
//		animals.add(new Dog()); must not add anything. "?" is generic, so, the list can be a list of Cat or Dog. Thus, you
								//can't add a Dog in a Cat list and vice-versa
	}
	
	public void addAnimalSafely(List<? super Dog> animals){
		animals.add(new Dog());
	}
	
	public static void main(String[] args) {
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		List<Cat> cats = new ArrayList<>();
		cats.add(new Cat());
		cats.add(new Cat());
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
		//doc.addAnimal(animals); It will break if addAnimal signature is addAnimal(List<Animal> animals)
		doc.addAnimal(animals);
		doc.addAnimal(cats);
		doc.addAnimalSafely(animals);
	}
}

abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() {
		// implement Dog-specific code
		System.out.println("Dog checkup");
	}
	public void dogCheckup(){
		
	}
}

class Cat extends Animal {
	public void checkup() {
		// implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() {
		// implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

