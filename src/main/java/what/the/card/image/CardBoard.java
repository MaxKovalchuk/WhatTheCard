package what.the.card.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class CardBoard {

	private final int x = 143;
	private final int y = 591;
	private final int w = 351;
	private final int h = 45;
	private final BufferedImage source;

	public CardBoard(BufferedImage source) {
		this.source = source;
	}

	public BufferedImage center() {
		BufferedImage center = source.getSubimage(x, y, w, h);
		return center;
	}

	public List<Card> cards() throws IOException {
		List<Card> cards = new LinkedList<Card>();
		for (int i = 0; i < 5; i++) {
			Card card = new Card(center(), i);
			if (!card.isBlank()) {
				cards.add(card);
			} else {
				break;
			}
		}
		return cards;
	}

}
