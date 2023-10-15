import java.util.HashMap;

public class Solution {

    public static String[] solution(String[] players, String[] callings) {
        final HashMap<String, Integer> rankings = new HashMap<>();
        for (int rank = 0; rank < players.length; rank++) {
            rankings.put(players[rank], rank);
        }

        for (final String calling : callings) {
            final int rank = rankings.get(calling);
            final String frontPlayer = players[rank - 1];

            rankings.replace(frontPlayer, rank);
            players[rank] = frontPlayer;

            rankings.replace(calling, rank - 1);
            players[rank - 1] = calling;
        }

        return players;
    }
}