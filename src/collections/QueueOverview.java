package collections;

import java.util.Comparator;
import java.util.PriorityQueue;

import collections.PQ.PQSort;

public class QueueOverview {
	public static void main(String[] args) {
		int[] ia = { 1, 5, 3, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		for (int x : ia)
			pq1.offer(x);
		System.out.println(pq1);
		for (int x : ia)
			System.out.print(pq1.poll() + " ");
		System.out.println("");
		PQSort pqs = new PQSort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, pqs);
		for (int x : ia)
			pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());// first element
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());// first element and remove
		System.out.println("size " + pq2.size());
		for (int x : ia)
			System.out.print(pq2.poll() + " ");
	}
}

class PQ {
	static class PQSort implements Comparator<Integer> {
		@Override
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
}
