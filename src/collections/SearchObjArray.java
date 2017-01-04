package collections;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {
	public static void main(String[] args) {
		String sa[] = { "one", "two", "three", "four" };
		Arrays.sort(sa);
		for (String s : sa)
			System.out.println(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
		ReSortComparator rs = new ReSortComparator();
		Arrays.sort(sa, rs);
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
		System.out.println("one = " + Arrays.binarySearch(sa, "one", rs));
	}

	static class ReSortComparator implements Comparator<String> {
		public int compare(String a, String b) {
			return b.compareTo(a);
		}
	}
}
