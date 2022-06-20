package csAdvanced.dataStructureIntroduction.queue.diceStreakGamble;

import java.util.Stack;

class Solution {
    public static String diceStreakGamble(int[] player1, int[] player2, int[] player3, int[] player4) {
        int winner = Integer.MIN_VALUE;
        int winnerFromIndex = Integer.MAX_VALUE;
        int winnerCount = 0;
        int[][] players = {player1, player2, player3, player4};

        for (int i = 0; i < players.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(players[i][0]);
            int currentPlayerFromIndex = 0;

            for (int j = 1; j < players[i].length; j++) {
                if (stack.peek() > players[i][j]) {
                    stack.clear();
                    currentPlayerFromIndex = j;
                }
                stack.push(players[i][j]);
            }

            if (winnerCount < players[i].length - currentPlayerFromIndex) {
                winnerFromIndex = currentPlayerFromIndex;
                winner = i;
                winnerCount = players[i].length - currentPlayerFromIndex;
            }
        }

        String outputArrayString = "[";
        for (int i = winnerFromIndex; i < players[winner].length; i++) {
            outputArrayString += players[winner][i] + ",";
        }
        outputArrayString = outputArrayString.substring(0, outputArrayString.length()-1) + "]";

        return String.format(
                "Winner: Player %s won $%s by rolling %s",
                ++winner, winnerCount * 4, outputArrayString);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.diceStreakGamble(new int[]{1, 2, 3}, new int[]{3, 4, 2}, new int[]{4, 2, 4}, new int[]{6, 16, 4}));
    }
}
