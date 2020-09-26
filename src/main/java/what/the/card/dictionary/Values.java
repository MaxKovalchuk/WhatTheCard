package what.the.card.dictionary;

public enum Values {

	TwoR("2", "compares\\values\\2r.png"),
	ThreeR("3", "compares\\values\\3r.png"),
	FourR("4", "compares\\values\\4r.png"),
	FiveR("5", "compares\\values\\5r.png"),
	SixR("6", "compares\\values\\6r.png"),
	SevenR("7", "compares\\values\\7r.png"),
	EightR("8", "compares\\values\\8r.png"),
	NineR("9", "compares\\values\\9r.png"),
	TenR("10", "compares\\values\\10r.png"),
	JackR("J", "compares\\values\\jackr.png"),
	QueenR("Q", "compares\\values\\queenr.png"),
	KingR("K", "compares\\values\\kingr.png"),
	AceR("A", "compares\\values\\acer.png"),
	TwoB("2", "compares\\values\\2b.png"),
	ThreeB("3", "compares\\values\\3b.png"),
	FourB("4", "compares\\values\\4b.png"),
	FiveB("5", "compares\\values\\5b.png"),
	SixB("6", "compares\\values\\6b.png"),
	SevenB("7", "compares\\values\\7b.png"),
	EightB("8", "compares\\values\\8b.png"),
	NineB("9", "compares\\values\\9b.png"),
	TenB("10", "compares\\values\\10b.png"),
	JackB("J", "compares\\values\\jackb.png"),
	QueenB("Q", "compares\\values\\queenb.png"),
	KingB("K", "compares\\values\\kingb.png"),
	AceB("A", "compares\\values\\aceb.png");
	
	private String code;
	private String path;
	
	private Values(String code, String path) {
		this.code = code;
		this.path = path;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getPath() {
		return path;
	}
}
