package collections;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeCollectionsTest {
	
	public static void main(String[] args) {
		treeSetTest();
		treeMapTest();
	}
	
	private static void treeSetTest(){
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(7);
		System.out.println("CeilingSet = "+treeSet.ceiling(6)); //>=
		System.out.println("Higher from set = "+treeSet.higher(4));//>
		System.out.println("Floor from set = "+treeSet.floor(2));//<=
		System.out.println("Lower from set = "+treeSet.lower(7));//<
		System.out.println("Poll first from set = "+treeSet.pollFirst());//returns the first element and exclude it
		System.out.println("Poll last from set = "+treeSet.pollLast());//returns the last element and exclude it
	}
	
	private static void treeMapTest(){
		TreeMap<Integer,String> treeMap = new TreeMap<>();
		treeMap.put(1, "I");
		treeMap.put(2, "II");
		treeMap.put(3, "III");
		treeMap.put(4, "IV");
		treeMap.put(6, "VI");
		System.out.println("CeilingMap = "+treeMap.ceilingKey(5));
		System.out.println("Higher from map = "+treeMap.higherKey(4));
		System.out.println("Floor from map = "+treeMap.floorKey(2));//<=
		System.out.println("Lower from map = "+treeMap.lowerKey(7));//<
		System.out.println("Poll first from map = "+treeMap.pollFirstEntry());//returns the first entry and exclude it
		System.out.println("Poll last from map = "+treeMap.pollLastEntry());//returns the last entry and exclude it
	}
}
