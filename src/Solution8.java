package src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution8 {
    // 과제 진행하기
    public static String[] solution8(String[][] plans) {
        String[] answer = new String[plans.length];
        Homework[] hwList = new Homework[plans.length];
        for (int i = 0; i < plans.length; ++i) {
            hwList[i] = new Homework(plans[i][0], plans[i][1], plans[i][2]);
        }
        Arrays.sort(hwList, new Comparator<Homework>() {
            @Override
            public int compare(Homework c1, Homework c2) {
                return Integer.compare(c1.getStartTime(),c2.getStartTime());
            }
        });
        int completeHwCnt = 0;
        Stack<Homework> stack = new Stack<>();

        int currTime = hwList[0].getStartTime();
        for (int i = 0; i < hwList.length; ++i) {
            Homework currHomework = hwList[i];
            currTime = currHomework.getStartTime();

            if (i < hwList.length - 1) { // 마지막 과제가 아닌 경우
                int nextHwStartTime = hwList[i + 1].getStartTime();
                if (currTime + currHomework.getRequiredTime() < nextHwStartTime) {
                    // 다음 과제 시작 시간 전에 끝나는 경우
                    answer[completeHwCnt++] = currHomework.getName();
                    currTime += currHomework.getRequiredTime();
                    while (!stack.isEmpty()) {
                        currHomework = stack.pop();
                        if (currTime + currHomework.getRequiredTime() < nextHwStartTime) {
                            // 다음 과제 시작 시간 전에 끝나는 경우
                            answer[completeHwCnt++] = currHomework.getName();
                            currTime += currHomework.getRequiredTime();
                        } else if (currTime + currHomework.getRequiredTime() > nextHwStartTime) {
                            // 다음 과제 시작 시간보다 늦게 끝나는 경우
                            currHomework.setRequiredTime(currHomework.requiredTime - (nextHwStartTime - currTime));
                            stack.push(currHomework);
                            break;
                        } else {
                            // 다음 과제 시작 시간과 동일하게 끝나는 경우
                            answer[completeHwCnt++] = currHomework.getName();
                            currTime += currHomework.getRequiredTime();
                            break;
                        }
                    }
                } else if (currTime + currHomework.getRequiredTime() > nextHwStartTime) {
                    // 다음 과제 시작 시간보다 늦게 끝나는 경우
                    currHomework.setRequiredTime(currHomework.requiredTime - (nextHwStartTime - currTime));
                    stack.push(currHomework);
                } else {
                    // 다음 과제 시작 시간과 동일하게 끝나는 경우
                    answer[completeHwCnt++] = currHomework.getName();
                    currTime += currHomework.getRequiredTime();
                }
            } else {
                answer[completeHwCnt++] = currHomework.getName();
                currTime += currHomework.getRequiredTime();
            }
        }
        while (!stack.isEmpty()) {
            Homework currHomework = stack.pop();
            answer[completeHwCnt++] = currHomework.getName();
            currTime += currHomework.getRequiredTime();
        }

//        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
    static class Homework{
        private String name;
        private int startTime;
        private int requiredTime;

        public Homework(String name, String startTime, String requiredTime) {
            this.name = name;
            StringTokenizer st = new StringTokenizer(startTime, ":");
            this.startTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            this.requiredTime = Integer.parseInt(requiredTime);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setRequiredTime(int requiredTime) {
            this.requiredTime = requiredTime;
        }

        public String getName() {
            return name;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getRequiredTime() {
            return requiredTime;
        }
    }
}

