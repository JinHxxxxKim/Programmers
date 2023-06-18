package src;

public class Solution4 {
    // 바탕화면 정리
    public static int[] solution4(String[] wallpaper) {
        int[] answer = new int[4];
        int rowSize = wallpaper.length;
        int colSize = wallpaper[0].length();

        char[][] backGround = new char[rowSize][colSize];
        for (int i = 0; i < rowSize; ++i) {
            backGround[i] = wallpaper[i].toCharArray();
        }
        int lux = -1;
        int luy = -1;
        int rdx = -1;
        int rdy = -1;

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (backGround[i][j] == '#') {
                    if (lux == -1) {
                        lux = i; // 한번 정해지면 확인할 필요 X
                    }
                    if (luy == -1) {
                        luy = j;
                    }
                    if (rdx == -1) {
                        rdx = i;
                    }
                    if (rdy == -1) {
                        rdy = j;
                    }
                    ////
                    if (j < luy) {
                        luy = j;
                    }
                    if (j > rdy) {
                        rdy = j;
                    }
                    if (i > rdx) {
                        rdx = i;
                    }

                }
            }
        }
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx + 1;
        answer[3] = rdy + 1;
        return answer;
    }

}
