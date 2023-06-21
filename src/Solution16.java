package src;

import java.util.Arrays;

public class Solution16 {
    // 숫자 변환하기
    public static int solution(int x, int y, int n) {
        int[] calCnt = new int[y+1];
        Arrays.fill(calCnt, -1);
        calCnt[x] = 0;
        for (int i = x; i < calCnt.length; ++i) {
            if (calCnt[i] != -1) {
                int num = i;
                if (num + n < calCnt.length) {
                    if (calCnt[num + n] > 0) {
                        calCnt[num + n] = Math.min(calCnt[num] + 1, calCnt[num + n]);
                    } else {
                        calCnt[num + n] = calCnt[num] + 1;
                    }
                }
                if (num * 2 < calCnt.length) {
                    if (calCnt[num * 2] > 0) {
                        calCnt[num * 2] = Math.min(calCnt[num] + 1, calCnt[num * 2]);
                    } else {
                        calCnt[num * 2] = calCnt[num] + 1;
                    }
                }
                if (num * 3 < calCnt.length) {
                    if (calCnt[num * 3] > 0) {
                        calCnt[num * 3] = Math.min(calCnt[num] + 1, calCnt[num * 3]);
                    } else {
                        calCnt[num * 3] = calCnt[num] + 1;
                    }
                }
            }
        }
        return calCnt[y];
    }
}
