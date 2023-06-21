package src;

import java.util.*;

public class Solution15 {
    // 뒤에 있는 큰 수 구하기
    public static int[] solution15(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        int[][] list = new int[numbers.length][2];
        for (int i = 0; i < numbers.length; ++i) {
            list[i][0] = i;
            list[i][1] = numbers[i];
        }
        Stack<int[]> stk = new Stack<>();
        stk.push(list[0]);
        for (int i = 1; i < numbers.length; ++i) {
            int[] tempNode = list[i];
            int tempIdx = tempNode[0];
            int tempNum = tempNode[1];

            int[] currNode = stk.peek();
            int currIdx = currNode[0];
            int currNum = currNode[1];

            while (!stk.isEmpty() && tempNum > stk.peek()[1]) {

                currNode = stk.pop();
                currIdx = currNode[0];
                currNum = currNode[1];

                answer[currIdx] = tempNum;
            }
            stk.push(tempNode);
        }

        return answer;
    }
}
