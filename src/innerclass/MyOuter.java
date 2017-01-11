package innerclass;

public class MyOuter {
	private int x = 7;

	class MyInner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
		}
	}
}

class TestInnerClass {
	public static void main(String[] args) {
		MyOuter.MyInner myInner = new MyOuter().new MyInner();
		myInner.seeOuter();

		new MyOuter().new MyInner().seeOuter();
	}
}