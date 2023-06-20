package src;

import java.util.*;

public class Solution13 {
    // 호텔 대실
    public static int solution13(String[][] book_time) {
//        int answer = 1;
//        StringTokenizer st;
//        int[][] schedule = new int[book_time.length][2];
//        for (int i = 0; i < book_time.length; ++i) {
//            st = new StringTokenizer(book_time[i][0], ":");
//            schedule[i][0] = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
//            st = new StringTokenizer(book_time[i][1], ":");
//            schedule[i][1] = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + 10;
//        }
//        // 알고리즘
//        Arrays.sort(schedule, (t1, t2) -> t1[1] - t2[1]);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(schedule[0][1]);
//        for (int i = 1; i < schedule.length; ++i) {
//            int startTime = schedule[i][0];
//            int endTime = schedule[i][1];
//            boolean found = false;
//            for (int j = list.size() - 1; j > -1; --j) {
//                if (list.get(j) <= startTime) {
//                    list.remove(j);
//                    found = true;
//                    list.add(endTime);
//                    break;
//                }
//            }
//            if (!found) {
//                list.add(endTime);
//                answer++;
//            }
//        }
//
//        System.out.println("answer = " + answer);
//        return answer;
        int answer = 1;
        int[] pSum = new int[60 * 24 + 10];
        StringTokenizer st;
        for (int i = 0; i < book_time.length; ++i) {
            st = new StringTokenizer(book_time[i][0], ":");
            pSum[Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())] += 1;
            st = new StringTokenizer(book_time[i][1], ":");
            pSum[Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + 10] -= 1;
        }

        answer = pSum[0];
        for (int i = 1; i < pSum.length; ++i) {
            pSum[i] += pSum[i - 1];
            answer = Math.max(answer, pSum[i]);
        }

//        Arrays.sort(schedule, (t1, t2) -> t1[0] - t2[0]);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        pq.offer(schedule[0][1]);
//        for (int i = 1; i < book_time.length; ++i) {
//            if (!pq.isEmpty()) {
//                if (pq.peek() > schedule[i][0]) {
//                    answer++;
//                } else {
//                    pq.poll();
//                }
//            }
//            pq.offer(schedule[i][1]);
//        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
