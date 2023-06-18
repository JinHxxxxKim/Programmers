package src;

public class Solution7 {
    // 연속된 부분 수열의 합
    public static int[] solution7(int[] sequence, int k) {
        int[] answer = new int[2];
        int realStart = -1;
        int realEnd = 1000000;

        int tempStart = 0;
        int tempEnd;

        int sum = 0;
        for (tempEnd = 0; tempEnd < sequence.length; ++tempEnd) {
            sum += sequence[tempEnd];

            if (sum > k) {
                while(sum>k) {
                    sum -= sequence[tempStart++];
                }
            }
//            System.out.println("sum = " + sum);
//            System.out.println("tempStart = " + tempStart);
//            System.out.println("tempEnd = " + tempEnd);
            if (sum == k) {
                if (tempEnd - tempStart < realEnd - realStart) {
                    realStart = tempStart;
                    realEnd = tempEnd;

                }
            }

        }
        answer[0] = realStart;
        answer[1] = realEnd;
        return answer;
    }

}
