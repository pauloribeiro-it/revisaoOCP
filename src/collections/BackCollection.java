package collections;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackCollection {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant");
		map.put("d", "dog");
		map.put("h", "horse");
		SortedMap<String, String> submap;
		submap = map.subMap("b",false, "g",false); //default inclusive
		System.out.println(map + " " + submap); 
		map.put("b", "bat"); 
		submap.put("f", "fish"); 
		System.out.println(map + " " + submap); 
		map.put("r", "raccoon"); 
//		submap.put("p", "pig"); 
		System.out.println(map + " " + submap); 
	}
}
