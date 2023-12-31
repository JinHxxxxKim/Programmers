import src.*;

public class Main {
    public static void main(String[] args) {
        // 달리기 경주
        Solution1.solution1(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        // 추억점수
        // 공원 산책
        Solution3.solution3(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"});
        // 요격 시스템
        Solution5.solution5(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
        Solution5.solution5(new int[][]{{3,6},{2,4},{5,6},{1,3}});
        // 두 원 사이의 정수 쌍
        Solution6.solution6(2, 3);
        // 연속된 부분 수열의 합
        Solution7.solution7(new int[]{1, 2, 3, 4, 5}, 7);
        Solution7.solution7(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        Solution7.solution7(new int[]{2, 2, 2, 2, 2}, 6);
        // 과제 진행하기
        String[][] plan1 = new String[][]{
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };
        String[][] plan2 = new String[][]{
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };
        String[][] plan3 = new String[][]{
                {"aaa", "12:00", "20"},
                {"bbb", "12:10", "30"},
                {"ccc", "12:40", "10"}
        };
        Solution8.solution8(plan1);
        Solution8.solution8(plan2);
        Solution8.solution8(plan3);
        // 광물 캐기
        int[] picks1 = new int[]{1, 3, 2};
        String[] minerals1 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int[] picks2 = new int[]{0, 1, 1};
        String[] minerals2 = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        Solution9.solution9(picks1, minerals1);
        Solution9.solution9(picks2, minerals2);
        // 당구 연습
        Solution10.solution10(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}});
        // 리코쳇 로봇
        Solution11.solution11(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        Solution11.solution11(new String[]{".D.R", "....", ".G..", "...D"});
        // 미로 탈출
        Solution12.solution12(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
        Solution12.solution12(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"});
        // 호텔 대실
        Solution13.solution13(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        Solution13.solution13(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}});
        Solution13.solution13(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}});
        // 무인도 여행
        Solution14.solution14(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        Solution14.solution14(new String[]{"XXX", "XXX", "XXX"});
        // 뒤에 있는 큰 수 찾기
        Solution15.solution15(new int[]{2, 3, 3, 5});
        Solution15.solution15(new int[]{9, 1, 5, 3, 6, 2});
        // 숫자 변환하기
        Solution16.solution(10, 40, 5);
        Solution16.solution(10, 40, 30);
        Solution16.solution(2, 5, 4);
        // 시소 짝꿍
        Solution17.solution(new int[]{100, 180, 360, 100, 270});
        // 택배 배달과 수거하기
        Solution18.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        Solution18.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        // 마법의 엘리베이터
        Solution19.solution(2554);
        Solution19.solution(9999);
        Solution19.solution(16);
        Solution19.solution(95);
        // 유사 칸토어 비트열
        Solution20.solution(3, 4, 17);
    }
}