public class Deck {
	private Card[] cards;
	public final int NUMCARDS = 52;
	
	public Deck() {
		cards = new Card[NUMCARDS];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = new Card(i % Card.VALUES.length, i / Card.VALUES.length);
		}
	}
	
	private void swap(int i, int j) {
		Card temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
	
	public void Shuffle() {
		for(int i = 0; i < cards.length; i++) {
			swap(i, (int)(Math.random() * cards.length));
		}
	}
	
	public String toString() {
		String builder = "";
		for(int i = 0; i < cards.length; i++) {
			if(i % 13 == 0 && i != 0) {
				builder += "\n";
			}
			builder += cards[i] + " ";
		}
		return builder;
	}
}
