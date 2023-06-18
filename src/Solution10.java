package src;

import java.util.Arrays;

public class Solution10 {
    // 당구 연습
    public static int[] solution10(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int cnt = 0;
        for (int[] ball : balls) {
            int destX = ball[0];
            int destY = ball[1];
            int dist = 0;
            //좌측 y축
            int candidate1 = (int) (Math.pow(startX + destX, 2) + Math.pow(startY - destY, 2));
            //우측 y축
            int candidate2 = (int) (Math.pow(2 * m - startX - destX, 2) + Math.pow(startY - destY, 2));
            //위쪽 x축
            int candidate3 = (int) (Math.pow(2 * n - startY - destY, 2) + Math.pow(startX - destX, 2));
            //아래측 x축
            int candidate4 = (int) (Math.pow(startX - destX, 2) + Math.pow(startY + destY, 2));

            if (destY == startY) {
                dist = Math.min(candidate3, candidate4);
                if (destX > startX) {
                    dist = Math.min(dist, candidate1);
                } else {
                    dist = Math.min(dist, candidate2);
                }
            } else if (destX == startX) {
                dist = Math.min(candidate1, candidate2);
                if (destY > startY) {
                    dist = Math.min(dist, candidate4);
                } else {
                    dist = Math.min(dist, candidate3);
                }
            } else {
                dist = Math.min(candidate1, candidate2);
                dist = Math.min(dist, candidate3);
                dist = Math.min(dist, candidate4);
            }

            answer[cnt++] = dist;
        }
        return answer;
    }
}
