package src;

import java.util.HashMap;

public class Solution1 {
    // 달리기 경주
    public static String[] solution1(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; ++i) {
            map.put(players[i], i);
            answer[i] = players[i];
        }
        for (int i = 0; i < callings.length; ++i) {
            int overTakingRank = map.get(callings[i]);
            String overTakenPlayer = answer[overTakingRank - 1];
            int overTakenRank = map.get(overTakenPlayer);

            map.put(callings[i], overTakingRank - 1);
            map.put(overTakenPlayer, overTakenRank + 1);

            String temp = overTakenPlayer;
            answer[overTakenRank] = callings[i];
            answer[overTakingRank] = temp;
        }
        return answer;
    }
}
