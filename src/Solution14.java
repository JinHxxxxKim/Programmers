package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution14 {
    // 무인도 여행
    public static int[] solution14(String[] maps) {
        ArrayList<Integer> answer = new ArrayList();

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int rowSize = maps.length;
        int colSize = maps[0].length();
        int[][] intMap = new int[rowSize][colSize];
        boolean[][] visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (maps[i].charAt(j) == 'X') {
                    intMap[i][j] = -1;
                } else {
                    intMap[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                if (intMap[i][j] != -1 && !visited[i][j]) { // 바다가 아니고, 방문한적이 없는 육지
                    Queue<int[]> q = new LinkedList<>();
                    int islandFood = 0;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] currNode = q.poll();
                        int currRow = currNode[0];
                        int currCol = currNode[1];
                        if (visited[currRow][currCol]) {
                            continue;
                        }
                        visited[currRow][currCol] = true;
                        islandFood += intMap[currRow][currCol];

                        for (int k = 0; k < 4; ++k) {
                            int tempRow = currRow + dx[k];
                            int tempCol = currCol + dy[k];
                            if (tempRow < 0 || tempRow >= rowSize || tempCol < 0 || tempCol >= colSize) {
                                continue;
                            }
                            if (intMap[tempRow][tempCol] == -1) {
                                continue;
                            }
                            q.add(new int[]{tempRow, tempCol});
                        }
                    }
                    answer.add(islandFood);
                }
            }
        }

        int[] arr = answer.stream()
                    .mapToInt(i -> i)
                    .toArray();

        if (arr.length == 0) {
            return new int[]{-1};
        }
        Arrays.sort(arr);
        return arr;
    }
}
