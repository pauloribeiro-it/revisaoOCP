package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
	public <T> void makeArrayList(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
	}
}

class A{
	
}

class B{
	
}

class TestGenericMethod {
	public static void main(String[] args) {
		GenericMethods generics = new GenericMethods();
		generics.makeArrayList(new A());
		generics.makeArrayList(new B());
	}
}
