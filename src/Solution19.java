package src;

import java.util.HashMap;

public class Solution19 {
    // 마법의 엘리베이터
    public static int solution(int storey) {
        String stringStorey;
        stringStorey = String.valueOf(storey);
        int cnt = stringStorey.length() - 1;
        while (cnt > -1 && stringStorey.charAt(cnt) == '0') {
            cnt--;
        }
        int currNum = stringStorey.charAt(cnt) - '0';
        int tempNum = 10 - currNum;
        if (cnt == 0) {
            if (currNum > 5) {
                return (10 - currNum) + 1;
            } else {
                return currNum;
            }
        }
        int plusNum = storey + tempNum * (int)Math.pow(10, stringStorey.length() - 1 - cnt);
        int minusNUm = storey - currNum * (int)Math.pow(10, stringStorey.length() - 1 - cnt);
        return Math.min(solution(plusNum) + tempNum, solution(minusNUm) + currNum);
    }
}
