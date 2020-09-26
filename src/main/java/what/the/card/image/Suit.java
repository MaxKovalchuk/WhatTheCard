package what.the.card.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import what.the.card.dictionary.Suits;

public class Suit extends CardPart{

	public Suit(Card card, BufferedImage source, int x, int w) {
		super(x, 26, w, 18, card, source);
	}

	@Override
	public String code() throws IOException {
		String code = "?";
		double percentage = 100;
		List<Suits> suits = isBlack() ? Suits.black() : Suits.red();
		for (Suits suit : suits) {
			double percentage2 = compare(ImageIO.read(new File(suit.getPath())));
			if (percentage2 < percentage) {
				percentage = percentage2;
				code = suit.getCode();
			}
		}
		return code;
	}
	
	private boolean isBlack() {
		Color color = new Color(getImg().getRGB(15, 9));
		return Math.abs(35 - color.getRed())
				+ Math.abs(35 - color.getGreen())
				+ Math.abs(38 - color.getBlue()) < 60;
	}
}
