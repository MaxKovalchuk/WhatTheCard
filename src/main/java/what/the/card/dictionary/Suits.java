package what.the.card.dictionary;

import java.util.LinkedList;
import java.util.List;

public enum Suits {
	Spades("s", "compares\\suits\\spades.png"),
	Clubs("c", "compares\\suits\\clubs.png"),
	Hearts("h", "compares\\suits\\hearts.png"),
	Diamonds("d", "compares\\suits\\diamonds.png");
	
	private String code;
	private String path;
	
	private Suits(String code, String path) {
		this.code = code;
		this.path = path;
	}
	
	public static List<Suits> black(){
		List<Suits> suits = new LinkedList<Suits>();
		suits.add(Spades);
		suits.add(Clubs);
		return suits;
	}
	
	public static List<Suits> red(){
		List<Suits> suits = new LinkedList<Suits>();
		suits.add(Hearts);
		suits.add(Diamonds);
		return suits;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getPath() {
		return path;
	}
}
