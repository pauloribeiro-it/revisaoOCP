package innerclass;

public class AnonymousInnerClass {

}

class Popcorn {
	public void pop() {
		System.out.println("popcorn");
	}
}

class Food {
	Popcorn p = new Popcorn() {
		int i = 2;

		public void pop() {
			System.out.println("anonymous popcorn");
		}

		public void printFood() { // won't work if you invoke this out of this
									// anonymous class
			System.out.println("hello");
		}
	};
}

interface Cookable {
	public void cook();
}

class FoodCook {
	Cookable c = new Cookable() {
		public void cook() {
			System.out.println("anonymous cookable implementer");
		}
	};
}