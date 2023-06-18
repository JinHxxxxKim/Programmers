package src;

import java.util.Arrays;

public class Solution5 {
    // 요격 시스템
    public static int solution5(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a, b)->(a[0]-b[0]));

        boolean[] isClear = new boolean[targets.length];
        int targetNum = 0;
        while (targetNum < targets.length) {
            if (!isClear[targetNum]) {
                ++answer;
                isClear[targetNum] = true;
                int endPos = targets[targetNum][1];
                //===//
                if (targetNum < targets.length - 1) {
                    int nextMissileStartPos = targets[targetNum + 1][0];
                    while (nextMissileStartPos < endPos) {
                        targetNum++;
                        isClear[targetNum] = true;
                        if (targetNum == targets.length - 1) {
                            break;
                        }
                        if (targets[targetNum][1] < endPos) {
                            endPos = targets[targetNum][1];
                        }
                        nextMissileStartPos = targets[targetNum+1][0];
                    }
                }
                //===//
            }
            targetNum++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

}
