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
            int candidate1 = (int)(Math.pow(startX + destX, 2) + Math.pow(startY - destY, 2));
            //우측 y축
            int candidate2 = (int) (Math.pow(2 * m - startX - destX, 2) + Math.pow(startY - destY, 2));
            //위쪽 x축
            int candidate3 = (int)(Math.pow(startX - destX, 2) + Math.pow(startY + destY, 2));
            //아래측 x축
            int candidate4 = (int) (Math.pow(2 * n - startY - destY, 2) + Math.pow(startX - destX, 2));

            dist = Math.max(candidate1, candidate2);
            dist = Math.min(dist, candidate3);
            dist = Math.min(dist, candidate4);

            answer[cnt++] = dist;
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }
}
