package what.the.card.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Card {

	private final int x;
	private final int w = 31;
	private final int space = 72;
	private final Value value;
	private final Suit suit;
	private final int status;

	public Card(BufferedImage source, int number) {
		x = number * space;
		value = new Value(this, source, x, w);
		suit = new Suit(this, source, x, w);
		status = status();
	}

	public BufferedImage valueImg() {
		return value.getImg();
	}
	
	public BufferedImage suitImg() {
		return suit.getImg();
	}
	
	public String valueCode() throws IOException {
		return value.code();
	}

	public String suitCode() throws IOException {
		return suit.code();
	}

	private int status() {
		int status = 0; // blank card
		int rgb = value.RGB(w - 1, 24);
		Color color = new Color(rgb);
		if (activeCardColorDiff(color) < 20) {
			status = 1; // active card
		} else if (disactiveCardColorDiff(color) < 20) {
			status = 2; // disactive card
		}
		return status;
	}

	public boolean isBlank() {
		return status == 0;
	}
	
	public boolean isActive() {
		return status == 1;
	}

	private double activeCardColorDiff(Color actual) {
		Color activeCardColor = new Color(-1);
		return Math.abs(activeCardColor.getRed() - actual.getRed())
				+ Math.abs(activeCardColor.getGreen() - actual.getGreen())
				+ Math.abs(activeCardColor.getBlue() - actual.getBlue());
	}

	private double disactiveCardColorDiff(Color actual) {
		Color disactiveCardColor = new Color(-8882056);
		return Math.abs(disactiveCardColor.getRed() - actual.getRed())
				+ Math.abs(disactiveCardColor.getGreen() - actual.getGreen())
				+ Math.abs(disactiveCardColor.getBlue() - actual.getBlue());
	}
}
