package what.the.card.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import what.the.card.dictionary.Values;

public class Value extends CardPart {

	public Value(Card card, BufferedImage source, int x, int w) {
		super(x, 0, w, 25, card, source);
	}

	@Override
	public String code() throws IOException {
		String code = "!";
		double percentage = 100;
		for (Values value : Values.values()) {
			double percentage2 = compare(ImageIO.read(new File(value.getPath())));
			if (percentage2 < percentage) {
				percentage = percentage2;
				code = value.getCode();
			}
		}
		return code;
	}
}
