package designpatterns;

import java.util.HashSet;
import java.util.Set;

public class ShowSingleton {
	private static final ShowSingleton INSTANCE = new ShowSingleton();
	
	private Set<String> availableSeats;
	
	public static ShowSingleton getInstance(){
		return INSTANCE;
	}
	
//	public static ShowSingleton getInstance(){
//		if(INSTANCE == null)
//			INSTANCE = new ShowSingleton();
//		return INSTANCE;
//	}
	

	private ShowSingleton(){
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat){
		return availableSeats.remove(seat);
	}
	
	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1B");
	}
	
	private static void ticketAgentBooks(String seat){
		ShowSingleton show = ShowSingleton.getInstance();
		System.out.println(show.bookSeat(seat));
	}

}
