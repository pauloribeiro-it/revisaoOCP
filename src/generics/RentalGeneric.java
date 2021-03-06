package generics;

import java.util.ArrayList;
import java.util.List;

public class RentalGeneric<T> {
	private List<T> rentalPool;
	private int maxNum;

	public RentalGeneric(int maxNum, List<T> rentalPool) {
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}

	public T getRental() {
		return rentalPool.get(0);
	}

	public void returnRental(T returnedThing) {
		rentalPool.add(returnedThing);
	}
	
	public int getMaxNum() {
		return maxNum;
	}
}

class TestRental {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
		List<Car> carList = new ArrayList<>();
		carList.add(c1);
		carList.add(c2);
		RentalGeneric<Car> carRental = new RentalGeneric<>(2, carList);
		// now get a car out, and it won't need a cast
		Car carToRent = carRental.getRental();
		carRental.returnRental(carToRent);
		// can we stick something else in the original carList?
//		carList.add(new Cat("Fluffy"));
	}
}

class Car {

}