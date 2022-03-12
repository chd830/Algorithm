package 구현;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    //    public static void main(String[] args) {
//        System.out.println(solution(4578, new int[] {1, 4, 99, 35, 50, 1000}));
//    }
//    static int[] value = {1, 5, 10, 50, 100, 500};
//    public static int solution(int money, int[] costs) {
//        int answer = 0;
//        Arrays.sort(costs);
//        int len = costs.length;
//        int[][] dp = new int[len][len];
//        for(int i = 0; i < len; i) {
//            for(int j = 0; j < len; j) {
//
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        int[][] result = solution(7, true);
//        for (int i = 0; i < result.length; i++)
//            System.out.println(Arrays.toString(result[i]));
//        System.out.println();
//    }

    //    static int next(int current, int count) {
//        return current - count;
//    }
//
//    static int x;
//    static int y;
//    static int value;
//    static int[][] answer;
//
//    public static int[][] solution(int n, boolean clockwise) {
//        answer = new int[n][n];
//        int cnt = 0;
//        answer[n/2][n/2] = 1;
//        while(next(n-1, cnt) > 0) {
//            answer[n / 2][n / 2] += next(n - 1, cnt);
//            cnt += 2;
//        }
//        if (clockwise) {
//            // 시계방향 (0, 0) (0, N-1) (N-1, N-1) (N-1, 0)에서 진행
//            x = 0;
//            y = 0;
//            value = 1;
//            n = n - 1;
//            cnt = 2;
//            right(next(n, 0));
//            while (true) {
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//            }
//            x = 0;
//            y = n;
//            value = 1;
//            cnt = 2;
//            down(next(n, 0));
//            while (true) {
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//            }
//            x = n;
//            y = 0;
//            value = 1;
//            cnt = 2;
//            up(next(n, 0));
//            while (true) {
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//            }
//            x = n;
//            y = n;
//            value = 1;
//            cnt = 2;
//            left(next(n, 0));
//            while (true) {
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//            }
//        } else {
//            // 반시계방향
//            x = 0;
//            y = 0;
//            value = 1;
//            cnt = 2;
//            n = n-1;
//            down(next(n, 0));
//            while (true) {
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//            }
//            x = 0;
//            y = n;
//            value = 1;
//            cnt = 2;
//            left(next(n, 0));
//            while (true) {
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//            }
//            x = n;
//            y = 0;
//            value = 1;
//            cnt = 2;
//            right(next(n, 0));
//            while (true) {
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//            }
//            x = n;
//            y = n;
//            value = 1;
//            cnt = 2;
//            up(next(n, 0));
//            while (true) {
//                y--;
//                if (next(n, cnt) <= 0)
//                    break;
//                left(next(n, cnt));
//                cnt += 2;
//                x++;
//                if (next(n, cnt) <= 0)
//                    break;
//                down(next(n, cnt));
//                cnt += 2;
//                y++;
//                if (next(n, cnt) <= 0)
//                    break;
//                right(next(n, cnt));
//                cnt += 2;
//                x--;
//                if (next(n, cnt) <= 0)
//                    break;
//                up(next(n, cnt));
//                cnt += 2;
//            }
//        }
//        return answer;
//    }
//
//    static void right(int size) {
//        while (size-- > 0)
//            answer[x][y++] = value++;
//        y--;
//    }
//
//    static void down(int size) {
//        while (size-- > 0)
//            answer[x++][y] = value++;
//        x--;
//    }
//
//    static void left(int size) {
//        while (size-- > 0)
//            answer[x][y--] = value++;
//        y++;
//    }
//
//    static void up(int size) {
//        while (size-- > 0)
//            answer[x--][y] = value++;
//        x++;
//    }
//}
    public static void main(String[] args) {
        System.out.println(solution(2, 2, new int[][] {{1, 1}, {2, 2}}));
//        System.out.println(solution(51, 37, new int[][] {{1, 1}, {2, 2}}));
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {-1, 0}, {-1, -1}, {1, 1}};
    static boolean[][] visited;
    static boolean[][] diagonalsArr;
    static int answer;
    static int W;
    static int H;
    public static int solution(int width, int height, int[][] diagonals) {
        W = width;
        H = height;
        diagonalsArr = new boolean[W + 1][H + 1];
        visited = new boolean[W + 1][H + 1];
        answer = 0;
        for (int i = 0; i < diagonals.length; i++)
            diagonalsArr[diagonals[i][0]][diagonals[i][1]] = true;
        for (int i = 0; i < W / 2; i++) {
            for (int j = 0; j <= H; j++) {
                boolean tmp = diagonalsArr[i][j];
                diagonalsArr[i][j] = diagonalsArr[W - i][j];
                diagonalsArr[W - i][j] = tmp;
            }
        }
        boolean[][] check = new boolean[W + 1][H + 1];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= H; j++) {
                if (diagonalsArr[i][j] && !check[i][j]) {
                    check[i + 1][j] = true;
                    diagonalsArr[i + 1][j] = true;
                    diagonalsArr[i][j] = false;
                }
            }
        }
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= H - i; j++) {
                if (diagonalsArr[i][j])
                    diagonalsArr[W - i][H - j] = true;
                else if (diagonalsArr[W - i][H - j])
                    diagonalsArr[i][j] = true;
            }
        }
        int[][][] count = new int[W+1][H+1][2];
        for(int i = W; i >= 0; i--) {
            for(int j = 0; j <= H; j++) {
                for(int d =0 ; d < 4; d++) {
                    int dx = i + dir[d][0];
                    int dy = j + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx <= W && dy <= H) {
                        if((d == 3 || d == 4) && count[dx][dy][1] == 0 && diagonalsArr[dx][dy]) {
                            count[dx][dy][1] += count[i][j][0]+1;
                        }
                        count[dx][dy][0] += count[i][j][0]+1;
                    }
                }
            }
        }
        for(int i = 0; i <= W; i++) {
            for(int j =0 ; j <= H; j++) {
                System.out.print(count[i][j][0]+"\t");
            }
            System.out.print("\t\t");
            for(int j =0 ; j <= H; j++) {
                System.out.print(count[i][j][1]+"\t");
            }
            System.out.println();
        }
        return count[W+1][H+1][1];
    }
}