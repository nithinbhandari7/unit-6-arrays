public class Card {
	public static final String[] VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	public static final char[] SUITS = {'\u2660', '\u2661', '\u2662', '\u2663'};
	private String value;
	private char suit;
	
	public Card(int valIndex, int suitIndex) {
		value = VALUES[valIndex];
		suit = SUITS[suitIndex];
	}
	
	public String toString() {
		return value + suit;
	}
	
	public static void main(String[] args) {
		
	}
}
