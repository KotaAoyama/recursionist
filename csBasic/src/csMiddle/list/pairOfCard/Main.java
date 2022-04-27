package csMiddle.list.pairOfCard;

import java.util.*;

public class Main {
    private static final String[] cardStrength = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static String winnerPairOfCards(String[] player1, String[] player2) {

        Map<String, Integer> player1Map = new HashMap<>();
        Map<String, Integer> player2Map = new HashMap<>();
        for (String card : player1) {
            if (player1Map.get(card.substring(1)) == null) {
                player1Map.put(card.substring(1), 1);
            } else {
                player1Map.replace(card.substring(1), player1Map.get(card.substring(1)) + 1);
            }
        }
        for (String card : player2) {
            if (player2Map.get(card.substring(1)) == null) {
                player2Map.put(card.substring(1), 1);
            } else {
                player2Map.replace(card.substring(1), player2Map.get(card.substring(1)) + 1);
            }
        }

        for (int i = 0; i < player1.length; i++) {

            int[] player1CountArray = getCountArray(player1Map);
            int player1MaxCount = 0;
            int player1MaxIndex = 0;
            for (int j = 0; j < player1CountArray.length; j++) {
                if (player1MaxCount <= player1CountArray[j]) {
                    player1MaxCount = player1CountArray[j];
                    player1MaxIndex = j;
                }
            }

            int[] player2CountArray = getCountArray(player2Map);
            int player2MaxCount = 0;
            int player2MaxIndex = 0;
            for (int j = 0; j < player2CountArray.length; j++) {
                if (player2MaxCount <= player2CountArray[j]) {
                    player2MaxCount = player2CountArray[j];
                    player2MaxIndex = j;
                }
            }

            if (player1MaxCount > player2MaxCount) return "player1";
            if (player2MaxCount > player1MaxCount) return "player2";
            if (player1MaxIndex > player2MaxIndex) return "player1";
            if (player2MaxIndex > player1MaxIndex) return "player2";

            for (int j = 0; j < 13; j++) {
                if (player1MaxIndex == j) {
                    player1Map.remove(cardStrength[j]);
                    break;
                }
            }
            for (int j = 0; j < 13; j++) {
                if (player2MaxIndex == j) {
                    player2Map.remove(cardStrength[j]);
                    break;
                }
            }
        }

        return "draw";
    }

    private static int[] getCountArray(Map<String, Integer> playerMap) {
        int[] countArray = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            countArray[Arrays.asList(cardStrength).indexOf(entry.getKey())] = entry.getValue();
        }

        return countArray;
    }

    public static void main(String[] args) {
        System.out.println(winnerPairOfCards(new String[]{"♣4","♥7","♥7","♠Q","♣J"},new String[]{"♥10","♥6","♣K","♠Q","♦2"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♣4","♥7","♥7","♠Q","♣J"},new String[]{"♥7","♥7","♣K","♠Q","♦2"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♣A","♥2","♥3","♠4","♣5"},new String[]{"♥A","♥2","♣3","♠4","♦5"})); // draw
        System.out.println(winnerPairOfCards(new String[]{"♣A","♥A","♥A","♠4","♣5"},new String[]{"♥A","♥A","♣A","♠4","♦5"})); // draw
        System.out.println(winnerPairOfCards(new String[]{"♣9","♥8","♥7","♠4","♣5"},new String[]{"♥10","♥8","♣7","♠4","♦5"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♣A","♥A","♥2","♠3","♣4"},new String[]{"♥6","♥6","♣Q","♠Q","♦8"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♣A","♥A","♥A","♠3","♣4"},new String[]{"♥6","♥6","♣Q","♠Q","♦Q"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♣K","♥K","♥K","♠A","♣A"},new String[]{"♥6","♥6","♣Q","♠Q","♦Q"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♣6","♠3","♠J","♦2","♥3"},new String[]{"♠8","♥2","♦8","♥9","♦J"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥3","♠9","♦3","♣Q","♦A"},new String[]{"♥4","♥3","♠10","♦3","♥4"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥3","♠9","♦3","♣Q","♦3"},new String[]{"♥4","♥A","♠10","♦A","♥4"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♣K","♥8","♥K","♠K","♣A"},new String[]{"♥K","♥4","♣K","♠4","♦K"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥9","♠8","♦7","♣6","♦5"},new String[]{"♥9","♥8","♠7","♦6","♥4"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♥3","♠4","♦5","♣6","♦7"},new String[]{"♥2","♥3","♠5","♦6","♥7"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♥K","♠4","♦K","♣6","♦6"},new String[]{"♥6","♥K","♠K","♦6","♥7"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥2","♠2","♦2","♣2","♦6"},new String[]{"♥2","♥2","♠2","♦2","♥7"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥2","♠2","♦2","♣2","♦6","♠3","♦3","♣4","♦6"},new String[]{"♥2","♥2","♠2","♦3","♥7","♠2","♦3","♣6","♦6"})); // player2
        System.out.println(winnerPairOfCards(new String[]{"♥2","♠2","♦2","♣2","♦6","♠3","♦3","♣4","♦3"},new String[]{"♥2","♥2","♠2","♦3","♥7","♠2","♦3","♣6","♦6"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♥2","♠2","♦6"},new String[]{"♥2","♥2","♥3"})); // player1
        System.out.println(winnerPairOfCards(new String[]{"♥2","♠A","♦6"},new String[]{"♥2","♥2","♥3"})); // player2
    }
}
