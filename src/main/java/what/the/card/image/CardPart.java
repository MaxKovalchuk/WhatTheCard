package what.the.card.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class CardPart {

	private final int x;
	private final int y;
	private final int w;
	private final int h;
	private final Card card;
	private final BufferedImage source;
	private final BufferedImage image;

	public CardPart(int x, int y, int w, int h, Card card, BufferedImage source) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.card = card;
		this.source = source;
		this.image = image();
	}

	protected double compare(BufferedImage other) {
		double difference = 0;
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color color = new Color(image.getRGB(x, y));
				Color otherColor = new Color(other.getRGB(x, y));
				 difference += Math.abs(color.getRed() - otherColor.getRed()); 
                 difference += Math.abs(color.getGreen() - otherColor.getGreen()); 
                 difference += Math.abs(color.getBlue() - otherColor.getBlue()); 
			}
		}
		double totalPixels = image.getWidth() * image.getHeight() * 3;
		double avgDifferentPixels = difference / totalPixels;
		double percentage = (avgDifferentPixels / 255) * 100;
		return percentage;
	}
	
	protected double bgCardColorDiff(Color actual) {
		Color bg = card.isActive() ? new Color(-1) : new Color(-8882056);
		return Math.abs(bg.getRed() - actual.getRed()) + Math.abs(bg.getGreen() - actual.getGreen())
				+ Math.abs(bg.getBlue() - actual.getBlue());
	}

	private BufferedImage image() {
		return source.getSubimage(x, y, w, h);
	}

	public int RGB(int x, int y) {
		return image.getRGB(x, y);
	}
	
	public BufferedImage getImg() {
		return image;
	}
	
	public abstract String code() throws IOException;
}
