package src;

import java.util.Arrays;

public class Solution17 {
    // 시소 짝꿍
    public static long solution(int[] weights) {
        long answer = 0;
        int[] weightList = new int[1001];
        Arrays.fill(weightList, 0);
        for (int weight : weights) {
            weightList[weight]++;
        }

        long[][] DP = new long[100001][3];
        Arrays.fill(DP[0], 0);
        DP[0][0] = 1;
        for (int i = 1; i < DP.length; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (j == 0) {
                    DP[i][j] = 1;
                } else {
                    DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
                }
            }
        }

        for (int i = 100; i < 1001; ++i) {
            // 해당 몸무게의 사람이 없는 경우
            if (weightList[i] == 0) {
                continue;
            }
            // 해당 몸무게의 사람이 여러명인 경우
            // 동일 몸무게
            if (weightList[i] != 1) {
                answer += DP[weightList[i]][2];
            }
            // 2:3 비율의 몸무게
            if (i % 2 == 0 && (i / 2) * 3 < weightList.length) {
                answer += (long)weightList[(i / 2) * 3] * (long)weightList[i];
            }
            // 1:2 비율의 몸무게
            if (i * 2 < weightList.length) {
                answer += (long)weightList[i * 2] * (long)weightList[i];
            }
            // 3:4 비율의 몸무게
            if (i % 3 == 0 && (i / 3) * 4 < weightList.length) {
                answer += (long)weightList[(i / 3) * 4] * (long)weightList[i];
            }
        }
        return answer;
    }
}
