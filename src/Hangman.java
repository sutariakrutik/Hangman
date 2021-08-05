import java.util.Scanner;

public class Hangman {

	private static String[] words = {"Apple", "computer", "Macbook", "Airpods", "Iphone" };
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter from the word....");
			System.out.println(asterisk);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}

	public static void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			printHangman();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}
	
	private static void printHangman() {
		int poleLines = 6;   // number of lines for hanging pole
		System.out.println("  ____");
		System.out.println("  |  |");
		
		int NoMatch = count;
		if (NoMatch == 7) {
			System.out.println("  |  |");
			System.out.println("  |  |");
		}
		
		if (NoMatch > 0) {	    	   
			System.out.println("  |  O");
			poleLines = 5;
		}
		if (NoMatch > 1) {
			poleLines = 4;
			if (NoMatch == 2) {
				System.out.println("  |  |");
			} else if (NoMatch == 3) {
				System.out.println("  | \\|");
			} else if (NoMatch >= 4) {
				System.out.println("  | \\|/");
			}
		}
		if (NoMatch > 4) {
			poleLines = 3;
			if (NoMatch == 5) {
				System.out.println("  | /");
			} else if (NoMatch >= 6) {
				System.out.println("  | / \\");
			}
		}
		if (NoMatch == 7) {
			poleLines = 1;
		}

		for (int k = 0; k < poleLines; k++) {
			System.out.println("  |");
		}
		System.out.println("__|__");
		System.out.println();
	}
}
