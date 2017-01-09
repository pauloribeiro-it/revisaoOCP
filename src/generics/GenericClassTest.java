package generics;

public class GenericClassTest<T> {
	T anInstance;
	T[] anArrayOfTs;

	GenericClassTest(T anInstance) {
		this.anInstance = anInstance;
	}

	T getT() {
		return anInstance;
	}
}

class UseTwo<T, X> {
	T one;
	X two;

	UseTwo(T one, X two) {
		this.one = one;
		this.two = two;
	}

	T getT() {
		return one;
	}

	X getX() {
		return two;
	}

	public static void main(String[] args) {
		UseTwo<String, Integer> twos = new UseTwo<String, Integer>("foo", 42);
		String theT = twos.getT(); 
		int theX = twos.getX();
		System.out.println("theT = "+theT);
		System.out.println("theX = "+theX);
	}

}