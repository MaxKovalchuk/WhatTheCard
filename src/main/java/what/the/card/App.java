package what.the.card;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import what.the.card.image.Card;
import what.the.card.image.CardBoard;

public class App {
	public static void main(String[] args) {
		System.out.println("Enter path to folder: ");
		Scanner in = new Scanner(System.in);
		String folderPath = in.nextLine();
		in.close();
		File folder = new File(folderPath);
		for(File image : folder.listFiles()) {
			try {
				CardBoard board = new CardBoard(ImageIO.read(image));
				for(Card card : board.cards()) {
					System.out.print(card.valueCode() + card.suitCode());
				}
				System.out.println();
			} catch (IOException e) {
				System.out.println("Error reading file " + image.getPath());
				e.printStackTrace();
			}
		}
	}
}
