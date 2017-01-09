package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsFail {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		Inserter in = new Inserter();
		in.insert(myList);
		System.out.println(myList.get(myList.size()-1).intValue());
	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new String("42")); // adds to the incoming list
	}
}
