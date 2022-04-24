package csMiddle.list.playingCard;

import java.util.ArrayList;

class Card{
    private String suit;
    private String value;
    private int intValue;

    public Card(String suit, String value, int intValue){
        this.suit = suit;
        this.value = value;
        this.intValue = intValue;
    }

    public String getCardString(){
        return this.suit + this.value + "(" + this.intValue + ")";
    }

}
class Deck{
    public ArrayList<Card> deck;

    public Deck(){
        this.deck = generateDeck();
    }

    public static ArrayList<Card> generateDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();
        String[] suits = new String[]{"♣", "♦", "♥", "♠"};
        String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (int j = 0; j < values.length; j++) {
                newDeck.add(new Card(suit, values[j], j + 1));
            }
        }
        return newDeck;
    }

    public Card draw() {
        return this.deck.remove(this.deck.size()-1);
    }

    public void printDeck(){
        System.out.println("Displaying cards...");
        for (Card card : this.deck) {
            System.out.println(card.getCardString());
        }
    }

    // シャッフルする関数はtwo pointerを活用します。for文で一つ一つのカードをランダムに入れ替える処理を書きましょう。
    public void shuffleDeck() {
        for(int i = this.deck.size()-1; i >= 0; i--){
            // ランダムに得た数値をインデックスとし、two pointerで入れ替えます。
            int j = (int)Math.floor(Math.random() * (i + 1));
            Card tmp = this.deck.get(i);
            this.deck.set(i, this.deck.get(j));
            this.deck.set(j, tmp);
        }
    }
}

public class Main{

    public static void main(String[] args){

        Deck deck1 = new Deck();

        deck1.shuffleDeck();

        System.out.println(deck1.deck.size() - 1);
        System.out.println(deck1.draw().getCardString());
    }
}
