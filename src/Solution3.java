package src;

import java.util.StringTokenizer;

public class Solution3 {
    // 공원 산책
    public static int[] solution3(String[] park, String[] routes) {
        int[] answer = new int[2];

        int currRow = -1;
        int currCol = -1;

        int rowSize = park.length;
        int colSize = park[0].length();

        char[][] parkMap = new char[rowSize][colSize];
        for (int i = 0; i < park.length; ++i) {
            parkMap[i] = park[i].toCharArray();
            if(park[i].contains("S")){
                for (int j = 0; j < park[i].length(); ++j) {
                    if(park[i].charAt(j)=='S'){
                        currRow = i;
                        currCol = j;
                    }
                }
            }
        }
        StringTokenizer st;

        for (int i = 0; i < routes.length; ++i) {
            st = new StringTokenizer(routes[i]);
            char direction = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            boolean canMove = true;

            switch (direction) {
                case 'E':
                    for (int cnt = 1; cnt <= count; ++cnt) {
                        if (currCol + count > colSize - 1) {
                            canMove = false;
                            break;
                        }
                        if(parkMap[currRow][currCol+cnt]=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if (canMove) {
                        currCol += count;
                    }
                    break;
                case 'W':
                    for (int cnt = 1; cnt <= count; ++cnt) {
                        if (currCol - count < 0) {
                            canMove = false;
                            break;
                        }
                        if(parkMap[currRow][currCol-cnt]=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if (canMove) {
                        currCol -= count;
                    }
                    break;
                case 'S':
                    for (int cnt = 1; cnt <= count; ++cnt) {
                        if (currRow + count > rowSize - 1) {
                            canMove = false;
                            break;
                        }
                        if(parkMap[currRow+cnt][currCol]=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if (canMove) {
                        currRow += count;
                    }
                    break;
                case 'N':
                    for (int cnt = 1; cnt <= count; ++cnt) {
                        if (currRow - count < 0) {
                            canMove = false;
                            break;
                        }
                        if(parkMap[currRow-cnt][currCol]=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if (canMove) {
                        currRow -= count;
                    }
                    break;
            }

        }
        answer[0] = currRow;
        answer[1] = currCol;
        return answer;
    }

}
