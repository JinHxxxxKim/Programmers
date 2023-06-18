package src;

public class Solution6 {
    // 두 원 사이의 정수 쌍
    public static long solution6(int r1, int r2) {
        long answer = 0;
        int r2_yMax = 0;
        int r1_yMax = 0;

        for (int x = 1; x < r2; ++x) {
            r2_yMax = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            if (x >= r1) {
                r1_yMax = 0;
            } else {
                r1_yMax = (int) Math.floor(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
                if (Math.pow(r1_yMax, 2) + Math.pow(x, 2) == Math.pow(r1, 2)) {
                    answer++;
                }
            }

            answer += r2_yMax - r1_yMax;
        }
        return answer * 4 + (r2 - r1 + 1) * 4;
    }

}
