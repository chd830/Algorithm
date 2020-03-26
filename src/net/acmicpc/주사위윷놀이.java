//package net.acmicpc;
//
//import java.util.Scanner;
//
//public class 주사위윷놀이 {
//    //모든칸에서 1~5가 나왔을 때의 다음 도착 칸의 번호를 저장해둔 배열
//    //모든 칸에 대해 해당 칸의 점수를 저장해둔 배열을 준비
//    static int[][] map = {{0, 1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}, {4, 5, 6, 7, 8}, {5, 6, 7, 8, 9}, {21, 22, 23, 24, 30}, {7, 8, 9, 10, 11},
//            {8, 9, 10, 11, 12}, {9, 10, 11, 12, 13}, {10, 11, 12, 13, 14}, {27, 28, 24, 25, 26}, {12, 13, 14, 15, 16}, {13, 14, 15, 16, 17}, {14, 15, 16, 17, 18},
//            {15, 16, 17, 18, 19, 20}, {29, 30, 31, 24, 25}, {17, 18, 19, 20}};
//    //4마리의 말이 각각 현재 어느 칸에 위치한지 저장할 배열
//
//    //10개의 주사위가 갖고 있는 값을 각각저장할 배열을 준비
//    static int ans;
//    static int[] pos;
//    static int[] dice;
//    //중복순열의 경우의 수를 구하는 재귀함수
//    static void dfs(int idx, int score) {
//        if(idx == 10) {
//            ans = Math.max(ans, score);
//            return;
//        }
//        out: for(int i = 0; i < 4; i++) {
//            //종료된 말
//            if(pos[i] == -1)
//                continue;
//            //i번째 말을 주사위의 idx번째에 나온 눈금만큼 이동
//            int now = pos[i];
//            int next = map[now][dice[idx]];
//            //끝나는 경우
//            if(next == 0) {
//                pos[i] = -1;
//                dfs(idx+1, score);
//                pos[i] = now;
//            }
//            //다른 말과 겹칠 때
//            for(int j = 0; j < 4; j++) {
//                if(i == j)
//                    continue;
//                if(pos[j] == next) {
//                    continue out;
//                }
//            }
//            pos[i] = next;
//            //다음 주사위 눈금을 수행
//            dfs(idx+1, score /*+ 새로 밟는 칸의 점수*/);
//            //i번째 말을 원래자리로 되돌려놓기
//            pos[i] = now;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        pos = new int[4];
//        dice = new int[];
//        dfs(0, 0);
//        System.out.println(ans);
//    }
//}
