import java.util.*;

public class Main {
    public static void main(String[] args) {
//        // 달리기 경주
//        String[] arr = new String[]{"mumu", "soe", "poe", "kai", "mine"};
//        String[] arr2 = new String[]{"kai", "kai", "mine", "mine"};
//        solution1(arr, arr2);
//        // 추억점수
//        // 공원 산책
//        String[] p = new String[]{"SOO","OOO","OOO"};
//        String[] r = new String[]{"E 2","S 2","W 1"};
//        solution3(p, r);
//        // 요격 시스템
//        int[][] target = new int[][]{
//                {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}
//        };
//        solution5(target);
//        int[][] target2 = new int[][]{
//                {3,6},{2,4},{5,6},{1,3}
//        };
//        solution5(target2);
//        int r1 = 2;
//        int r2 = 3;
//        solution6(r1, r2);
//        int[] seq1 = new int[]{1, 2, 3, 4, 5};
//        int[] seq2 = new int[]{1, 1, 1, 2, 3, 4, 5};
//        int[] seq3 = new int[]{2, 2, 2, 2, 2};
//        solution7(seq1, 7);
//        solution7(seq2, 5);
//        solution7(seq3, 6);
        // 과제 진행하기
//        String[][] plan1 = new String[][]{
//                {"korean", "11:40", "30"},
//                {"english", "12:10", "20"},
//                {"math", "12:30", "40"}
//        };
//        String[][] plan2 = new String[][]{
//                {"science", "12:40", "50"},
//                {"music", "12:20", "40"},
//                {"history", "14:00", "30"},
//                {"computer", "12:30", "100"}
//        };
//        String[][] plan3 = new String[][]{
//                {"aaa", "12:00", "20"},
//                {"bbb", "12:10", "30"},
//                {"ccc", "12:40", "10"}
//        };
//        solution8(plan1);
//        solution8(plan2);
//        solution8(plan3);
//    // 광물 캐기
//        int[] picks1 = new int[]{1, 3, 2};
//        String[] minerals1 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//        int[] picks2 = new int[]{0, 1, 1};
//        String[] minerals2 = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
//        solution9(picks1, minerals1);
//        solution9(picks2, minerals2);
        // 당구 연습
        solution10(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
    }
    // 달리기 경주
    public static String[] solution1(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; ++i) {
            map.put(players[i], i);
            answer[i] = players[i];
        }
        for (int i = 0; i < callings.length; ++i) {
            int overTakingRank = map.get(callings[i]);
            String overTakenPlayer = answer[overTakingRank - 1];
            int overTakenRank = map.get(overTakenPlayer);

            map.put(callings[i], overTakingRank - 1);
            map.put(overTakenPlayer, overTakenRank + 1);

            String temp = overTakenPlayer;
            answer[overTakenRank] = callings[i];
            answer[overTakingRank] = temp;
        }
        return answer;
    }
    // 추억 점수
    public static int[] solution2(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; ++i) {
            map.put(name[i], yearning[i]);
        }
        for (int numOfPhoto = 0; numOfPhoto < photo.length; ++numOfPhoto) {
            String[] currPhoto = photo[numOfPhoto];
            for (int numOfPeople = 0; numOfPeople < currPhoto.length; ++numOfPeople) {
                if (map.get(currPhoto[numOfPeople]) == null) {
                    continue;
                }
                answer[numOfPhoto]+=map.get(currPhoto[numOfPeople]);
            }
        }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
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
    // 요격 시스템
    public static int solution5(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->(a[0]-b[0]));

        boolean[] isClear = new boolean[targets.length];
        int targetNum = 0;
        while (targetNum < targets.length) {
            if (!isClear[targetNum]) {
                ++answer;
                isClear[targetNum] = true;
                int endPos = targets[targetNum][1];
                //===//
                if (targetNum < targets.length - 1) {
                    int nextMissileStartPos = targets[targetNum + 1][0];
                    while (nextMissileStartPos < endPos) {
                        targetNum++;
                        isClear[targetNum] = true;
                        if (targetNum == targets.length - 1) {
                            break;
                        }
                        if (targets[targetNum][1] < endPos) {
                            endPos = targets[targetNum][1];
                        }
                        nextMissileStartPos = targets[targetNum+1][0];
                    }
                }
                //===//
            }
            targetNum++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
    // 두 원 사이의 정수 쌍
    public static long solution6(int r1, int r2) {
        long answer = 0;
        int r2_yMax = 0;
        int r1_yMax = 0;

        for (int x = 1; x < r2; ++x) {
            r2_yMax = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));
            if (x >= r1) {
                r1_yMax = 0;
            } else {
                r1_yMax = (int) Math.floor(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
                if (Math.pow(r1_yMax, 2) + Math.pow(x, 2) == Math.pow(r1, 2)) {
                    answer++;
                }
            }

            answer += r2_yMax - r1_yMax;
        }
        return answer * 4 + (r2 - r1 + 1) * 4;
    }
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
    // 광물 캐기
    public static int solution9(int[] picks, String[] minerals) {
        int answer = 0;

        int diamondCnt = 0;
        int ironCnt = 0;
        int stoneCnt = 0;

        int mineralSum = 0;
        int picksTotalNum = 0;

        for (int pick : picks) {
            picksTotalNum += pick;
        }

        ArrayList<MineralSet> mineralList = new ArrayList<>();

        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];

            if (mineral.equals("diamond")) {
                mineralSum += 25;
                diamondCnt++;
            } else if (mineral.equals("iron")) {
                mineralSum += 5;
                ironCnt++;
            } else {
                mineralSum += 1;
                stoneCnt++;
            }

            if (i % 5 == 4) {
                mineralList.add(new MineralSet(mineralSum, diamondCnt, ironCnt, stoneCnt));

                diamondCnt = 0;
                ironCnt = 0;
                stoneCnt = 0;
                mineralSum = 0;

                if (mineralList.size() == picksTotalNum) {
                    break;
                }
            }
        }

        if (mineralSum != 0) {
            mineralList.add(new MineralSet(mineralSum, diamondCnt, ironCnt, stoneCnt));
        }

        mineralList.sort(Collections.reverseOrder());

        for (MineralSet mineralSet : mineralList) {
            System.out.println("mineralSet = " + mineralSet.fatigue);
        }

        for (MineralSet currMineralSet : mineralList) {
            for (int i = 0; i < 3; ++i) {
                if (picks[i] == 0) { // 해당 곡괭이가 없는 경우
                    continue;
                }
                // 곡괭이가 있을 경우
                switch (i) {
                    case 0: // 다이아 곡괭이
                        answer = answer
                                + currMineralSet.numOfDiamond
                                + currMineralSet.numOfIron
                                + currMineralSet.numOfStone;
                        break;
                    case 1: // 철 곡괭이
                        answer = answer
                                + currMineralSet.numOfDiamond * 5
                                + currMineralSet.numOfIron
                                + currMineralSet.numOfStone;
                        break;
                    case 2: // 돌 곡괭이
                        answer = answer
                                + currMineralSet.numOfDiamond * 25
                                + currMineralSet.numOfIron * 5
                                + currMineralSet.numOfStone;
                        break;
                }
                picks[i]--;
                break;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
    static class MineralSet implements Comparable<MineralSet>{
        int fatigue;
        int numOfDiamond;
        int numOfIron;
        int numOfStone;
        public MineralSet(int fatigue, int numOfDiamond, int numOfIron, int numOfStone) {
            this.fatigue = fatigue;
            this.numOfDiamond = numOfDiamond;
            this.numOfIron = numOfIron;
            this.numOfStone = numOfStone;
        }

        @Override
        public int compareTo(MineralSet mineralSet) {
            return this.fatigue - mineralSet.fatigue;
        }
    }
    // 당구 연습
    public static int[] solution10(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int cnt = 0;
        for (int[] ball : balls) {
            int destX = ball[0];
            int destY = ball[1];
            int dist = 0;
            //좌측 y축
            int candidate1 = (int)(Math.pow(startX + destX, 2) + Math.pow(startY - destY, 2));
            //우측 y축
            int candidate2 = (int) (Math.pow(2 * m - startX - destX, 2) + Math.pow(startY - destY, 2));
            //위쪽 x축
            int candidate3 = (int)(Math.pow(startX - destX, 2) + Math.pow(startY + destY, 2));
            //아래측 x축
            int candidate4 = (int) (Math.pow(2 * n - startY - destY, 2) + Math.pow(startX - destX, 2));

            dist = Math.max(candidate1, candidate2);
            dist = Math.min(dist, candidate3);
            dist = Math.min(dist, candidate4);
//            if (destY == startY) {
//                dist = Math.min(candidate3, candidate4);
//            } else if (destX == startX) {
//                dist = Math.min(candidate1, candidate2);
//            } else {
//                dist = Math.max(candidate1, candidate2);
//                dist = Math.min(dist, candidate3);
//                dist = Math.min(dist, candidate4);
//            }
            answer[cnt++] = dist;
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }
}