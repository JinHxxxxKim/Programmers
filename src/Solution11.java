package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution11 {
    // 리코쳇 로봇
    public static int solution11(String[] board) {
        // 변수 초기화
        int answer = 0;
        int rowSize = board.length;
        int colSize = board[0].length();
        char[][] map = new char[rowSize][colSize];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        // 남 북 동 서 순서
        int startRow = -1;
        int startCol = -1;
        int destRow = -1;
        int destCol = -1;

        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    startRow = i;
                    startCol = j;
                }
                if (map[i][j] == 'G') {
                    destRow = i;
                    destCol = j;
                }

            }
        }
        // 알고리즘
        // 노드의 변호는 i*colSize + j

        boolean[] visited = new boolean[rowSize * colSize];
        int[] dist = new int[rowSize * colSize];
        Arrays.fill(dist, 0);

        int currRow = startRow;
        int currCol = startCol;

        Queue<Integer> q = new LinkedList<>();
        q.add(currRow * colSize + currCol);
        while (!q.isEmpty()) {
            int currNode = q.poll();
            currRow = currNode / colSize;
            currCol = currNode % colSize;
            if (visited[currNode]) {
                continue;
            }
            visited[currNode] = true;

            if (map[currRow][currCol]=='G') {
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int tempRow = currRow;
                int tempCol = currCol;
                while (tempRow + dx[i] > -1 && tempRow + dx[i] < rowSize &&
                        tempCol + dy[i] > -1 && tempCol + dy[i] < colSize &&
                        map[tempRow + dx[i]][tempCol + dy[i]] != 'D') {
                    tempRow += dx[i];
                    tempCol += dy[i];
                }

                if ((currRow != tempRow || currCol != tempCol) && // 움직이고
                        !visited[tempRow * colSize + tempCol]) { // 방문한적이 없는 노드 일 경우 q에 추가
                    if (dist[tempRow * colSize + tempCol] != 0) {
                        Math.min(dist[tempRow * colSize + tempCol], dist[currRow * colSize + currCol] + 1);
                    } else {
                        dist[tempRow * colSize + tempCol] = dist[currRow * colSize + currCol] + 1;
                    }
                    q.add(tempRow * colSize + tempCol);
                }
            }
        }

        if (dist[destRow * colSize + destCol] == 0) {
            answer = -1;
        } else {
            answer = dist[destRow * colSize + destCol];
        }

        return answer;
    }
}
