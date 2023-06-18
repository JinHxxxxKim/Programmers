package src;

import java.util.ArrayList;
import java.util.Collections;

public class Solution9 {
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

}
