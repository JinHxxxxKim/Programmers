package src;

import java.util.Arrays;
import java.util.HashMap;

public class Solution2 {
    // 추억 점수
    public static int[] solution2(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; ++i) {
            map.put(name[i], yearning[i]);
        }
        for (int numOfPhoto = 0; numOfPhoto < photo.length; ++numOfPhoto) {
            String[] currPhoto = photo[numOfPhoto];
            for (int numOfPeople = 0; numOfPeople < currPhoto.length; ++numOfPeople) {
                if (map.get(currPhoto[numOfPeople]) == null) {
                    continue;
                }
                answer[numOfPhoto]+=map.get(currPhoto[numOfPeople]);
            }
        }
        return answer;
    }
}
