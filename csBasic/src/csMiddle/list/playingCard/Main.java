package csMiddle.list.playingCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Card {
    private final String suit;
    private final String value;
    private final int intValue;

    public Card(String suit, String value, int intValue) {
        this.suit = suit;
        this.value = value;
        this.intValue = intValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getCardString() {
        return this.suit + this.value + "(" + this.intValue + ")";
    }

}

class Deck {
    public List<Card> deck;

    public Deck(Table table) {
        this.deck = generateDeck(table);
    }

    public List<Card> generateDeck(Table table) {
        List<Card> newDeck = new ArrayList<>();
        String[] suits = new String[]{"♣", "♦", "♥", "♠"};
        String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Map<String, Integer> blackJack = new HashMap<>() {
            {
                put("A", 1);
                put("J", 10);
                put("Q", 10);
                put("K", 10);
            }
        };
        for (String suit : suits) {
            for (int j = 0; j < values.length; j++) {
                if (table.getGameMode() == "21") {
                    newDeck.add(new Card(suit, values[j], blackJack.get(values[j]) == null ? j + 1 : blackJack.get(values[j])));
                } else {
                    newDeck.add(new Card(suit, values[j], j + 1));
                }
            }
        }
        return newDeck;
    }

    public Card draw() {
        return this.deck.remove(this.deck.size() - 1);
    }

    public void printDeck() {
        System.out.println("Displaying cards...");
        for (Card card : this.deck) {
            System.out.println(card.getCardString());
        }
    }

    // シャッフルする関数はtwo pointerを活用します。for文で一つ一つのカードをランダムに入れ替える処理を書きましょう。
    public void shuffleDeck() {
        for (int i = this.deck.size() - 1; i >= 0; i--) {
            // ランダムに得た数値をインデックスとし、two pointerで入れ替えます。
            int j = (int) Math.floor(Math.random() * (i + 1));
            Card tmp = this.deck.get(i);
            this.deck.set(i, this.deck.get(j));
            this.deck.set(j, tmp);
        }
    }
}

//他のゲームにも対応できるよう、プレイヤーの人数とgameModeを記録するTableクラスを作成します。
class Table {
    private int amountOfPlayers;
    private String gameMode;

    public Table(int amountOfPlayers, String gameMode) {
        this.amountOfPlayers = amountOfPlayers;
        this.gameMode = gameMode;
    }

    public int getAmountOfPlayers() {
        return amountOfPlayers;
    }

    public String getGameMode() {
        return gameMode;
    }
}

class Dealer {
    public static List<List<Card>> startGame(Table table) {

        Deck deck = new Deck(table);
        deck.shuffleDeck();

        List<List<Card>> playerCards = new ArrayList<>();

        for (int i = 0; i < table.getAmountOfPlayers(); i++) {
            List<Card> playerHand = new ArrayList<Card>(Dealer.initialCards(table.getGameMode()));
            for (int j = 0; j < Dealer.initialCards(table.getGameMode()); j++) {
                Card card1 = deck.draw();
                playerHand.add(card1);
            }
            playerCards.add(playerHand);
        }

        return playerCards;
    }

    public static int initialCards(String gameMode) {
        if (gameMode.equals("poker")) return 5;
        if (gameMode.equals("21")) return 2;
        else return 0;
    }

    public static void printTableInformation(List<List<Card>> playerCards, Table table) {
        System.out.println("Amount of players: " + table.getAmountOfPlayers() + "... Game mode: " + table.getGameMode() + ". At this table: ");

        for (int i = 0; i < playerCards.size(); i++) {
            System.out.println("Player " + (i + 1) + " hand is: ");
            for (int j = 0; j < playerCards.get(i).size(); j++) {
                System.out.println(playerCards.get(i).get(j).getCardString());
            }
            System.out.println();
        }
    }

    public static int score21Individual(List<Card> cards) {
        int value = 0;
        for (Card card : cards) {
            value += card.getIntValue();
        }
        if (value > 21) value = 0;
        return value;
    }

    public static String winnerOf21(List<List<Card>> playerCards) {

        int[] points = new int[playerCards.size()];
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < playerCards.size(); i++) {
            int point = score21Individual(playerCards.get(i));
            points[i] = point;

            if (cache.get(point) == null) cache.put(point, 1);
            else cache.replace(point, cache.get(point) + 1);
        }

        int winnerIndex = HelperFunctions.maxInArrayIndex(points);
        if (cache.get(points[winnerIndex]) > 1) return "It is a draw ";
        else if (cache.get(points[winnerIndex]) >= 0) return "player " + (winnerIndex + 1) + " is the winner";
        else return "No winners..";
    }

    public static String checkWinner(List<List<Card>> playerCards, Table table) {
        if (table.getGameMode().equals("21")) return Dealer.winnerOf21(playerCards);
        else return "no game";
    }
}

class HelperFunctions {
    public static int maxInArrayIndex(int[] intArr) {
        int maxIndex = 0;
        int maxValue = intArr[0];

        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] > maxValue) {
                maxIndex = i;
                maxValue = intArr[i];
            }
        }
        return maxIndex;
    }
}

public class Main {

    public static void main(String[] args) {

        Table table1 = new Table(1,"poker");
        List<List<Card>> game1 = Dealer.startGame(table1);

        Table table2 = new Table(3,"21");
        List<List<Card>> game2 = Dealer.startGame(table2);

        Dealer.printTableInformation(game1, table1);
        System.out.println(Dealer.checkWinner(game1, table1));

        Dealer.printTableInformation(game2, table2);
        System.out.println(Dealer.checkWinner(game2, table2));
    }
}
