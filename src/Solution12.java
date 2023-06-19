package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution12 {
    public static int solution12(String[] maps) {
        // 변수 초기화
        int sToL = Integer.MAX_VALUE;
        int lToE = Integer.MAX_VALUE;
        int rowSize = maps.length;
        int colSize = maps[0].length();
        char[][] miro = new char[rowSize][colSize];
        boolean[][] visited = new boolean[rowSize][colSize];
        int[][] dist = new int[rowSize][colSize];
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                miro[i][j] = maps[i].charAt(j);
                if (miro[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // 알고리즘
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        dist[startRow][startCol] = 0;
        while (!q.isEmpty()) {
            int[] tempArr = q.poll();
            int currRow = tempArr[0];
            int currCol = tempArr[1];
            if (visited[currRow][currCol]) {
                continue;
            }
            if (miro[currRow][currCol] == 'L') {
                sToL = dist[currRow][currCol];
                startRow = currRow;
                startCol = currCol;
                break;
            }
            visited[currRow][currCol] = true;

            for (int i = 0; i < 4; ++i) {
                int tempRow = currRow + dx[i];
                int tempCol = currCol + dy[i];
                // 범위 초과
                if (tempRow >= rowSize || tempCol >= colSize || tempRow < 0 || tempCol < 0) {
                    continue;
                }
                // 벽 만남
                if (miro[tempRow][tempCol] == 'X') {
                    continue;
                }
                dist[tempRow][tempCol] = Math.min(dist[tempRow][tempCol], dist[currRow][currCol] + 1);
                q.add(new int[]{tempRow, tempCol});
            }
        }

        q = new LinkedList<>();
        visited = new boolean[rowSize][colSize];
        dist = new int[rowSize][colSize];
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        q.add(new int[]{startRow, startCol});
        dist[startRow][startCol] = 0;
        while (!q.isEmpty()) {
            int[] tempArr = q.poll();
            int currRow = tempArr[0];
            int currCol = tempArr[1];
            if (visited[currRow][currCol]) {
                continue;
            }
            if (miro[currRow][currCol] == 'E') {
                lToE = dist[currRow][currCol];
                break;
            }
            visited[currRow][currCol] = true;
            for (int i = 0; i < 4; ++i) {
                int tempRow = currRow + dx[i];
                int tempCol = currCol + dy[i];
                // 범위 초과
                if (tempRow >= rowSize || tempCol >= colSize || tempRow < 0 || tempCol < 0) {
                    continue;
                }
                // 벽 만남
                if (miro[tempRow][tempCol] == 'X') {
                    continue;
                }
                dist[tempRow][tempCol] = Math.min(dist[tempRow][tempCol], dist[currRow][currCol] + 1);
                q.add(new int[]{tempRow, tempCol});
            }
        }

        if (sToL == Integer.MAX_VALUE || lToE == Integer.MAX_VALUE) {
            System.out.println(-1);
            return -1;
        }

        return sToL + lToE;
    }
}
