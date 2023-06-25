package src;

public class Solution20 {
    public static int solution(int n, long l, long r) {
        int answer = 0;
        for (long i = l - 1; i < r; ++i) {
            if (n == 1) {
                if (i == 2) {
                    continue;
                } else {
                    answer++;
                }
            }
            int k = n - 1;
            long tempI = i;
            long areaNum;
            while (k > 0) {
                areaNum = tempI / (long) Math.pow(5, k);
                if (areaNum == 2) {
                    break;
                }
                tempI -= areaNum * (long) Math.pow(5, k);
                if (tempI < 5 && tempI != 2) {
                    answer++;
                    break;
                }
                --k;
            }
        }
        return answer;
    }
}
