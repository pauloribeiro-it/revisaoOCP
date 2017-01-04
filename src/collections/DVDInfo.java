package collections;

import java.util.Comparator;

public class DVDInfo implements Comparable<DVDInfo> {
	private String title;
	private String genre;
	private String leadActor;

	public DVDInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getLeadActor() {
		return leadActor;
	}
	
	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}

	public int compareTo(DVDInfo d) {
		return title.compareTo(d.getTitle());
	}

}

class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
		return one.getGenre().compareTo(two.getGenre());
	}
}



