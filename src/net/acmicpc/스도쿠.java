package net.acmicpc;

import java.util.Scanner;

public class 스도쿠 {
    static int[][] sudoku;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
                if (sudoku[i][j] == 0) {
                    cnt++;
                }
            }
        }
            setSudoku(0, 0);
        print();
    }
    //수를 하나하나 넣어서 되는지 체크하고 true이면 계속 아니면 다시한다.
    public static boolean setSudoku(int x, int y) {
        if(x == 9) {
            return true;
        }
        if(y == 9) {
            return setSudoku(x+1, 0);
        }
        if(sudoku[x][y] != 0) {
            return setSudoku(x, y+1);
        }
        for(int i = 1; i <= 9; i++) {
            if(check(x, y, i)) {
                sudoku[x][y] = i;
                if(setSudoku(x, y+1)) {
                    return true;
                }
                sudoku[x][y] = 0;
            }
        }
        return false;
    }

    public static boolean check(int x, int y, int num) {
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == num || sudoku[i][y] == num){
                return false;
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(sudoku[3*(x/3)+i][3*(y/3)+j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void print() {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*
    //하나씩 넣어서 겹치는 수가 있는지 확인하는 코드. 앞에서 이미 값이 정해져있는 경우에는 틀릴 수 있다.
    public static void sudoku(int left, int right, int cnt) {
        System.out.println("cnt: "+cnt);
        print();
        System.out.println();
        if(cnt == 0) {
            return;
        }
        if(right == 9) {
            sudoku(left+1, 0, cnt);
        }
        if(left == 9) {
            print();
            System.out.println();
            sudoku(0, 0, cnt);
        }
//        print();
//        System.out.println();
        if(sudoku[left][right] != 0) {
            sudoku(left, right+1, cnt);
        }
        else if(sudoku[left][right] == 0) {
            for(int i = 1; i < 10; i++) {
                sudoku[left][right] = i;
                if(isPossible(left, right)) {
                    sudoku(left, right + 1, cnt-1);
                    return;
                }
            }
        }
    }

    public static boolean isPossible(int left, int right) {
        HashSet<Integer> ver = new HashSet<>();
        HashSet<Integer> hor = new HashSet<>();
        HashSet<Integer> square = new HashSet<>();
        for (int i = 0, a = 0; i < 9; i++) {
//            System.out.print(sudoku[i][right]+" ");
            if (sudoku[i][right] != 0 && !ver.add(sudoku[i][right])) {
//                System.out.println();
                return false;
            }
        }
//        System.out.println();
        for(int i = 0; i < 9; i++) {
//            System.out.print(sudoku[left][i]+" ");
            if (sudoku[left][i] != 0 && !hor.add(sudoku[left][i])) {
//                System.out.println();
                return false;
            }
        }
        for(int a = 0; a < 3; a++) {
//            if(a < 3) {
                for (int b = 0; b < 3; b++) {
                    if (sudoku[3 * (left / 3) + a][3 * (right / 3) + b] != 0 && !square.add(sudoku[3 * (left / 3) + a][3 * (right / 3) + b])) {
                        return false;
                    }
//                }
//                a++;
                }
        }
//        System.out.println();
        return true;
    }
    public static void print() {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
}
//재귀를 쓰지 않은 코드. 시간초과나 틀린답이 나오게 됨.
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (sudoku[i][j] == 0) {
//                    setSudoku(i, j);
//                }
//            }
//        }
//        print();

//    public static void setSudoku(int left, int right) {
//        for (int i = 1; i <= 9; i++) {
//            sudoku[left][right] = i;
//            if (isSudoku(left, right)) {
//                return;
//            }
//        }
//    }
//

//
//    public static boolean isSudoku(int left, int right) {
//        HashSet<Integer> ver = new HashSet<>();
//        HashSet<Integer> hor = new HashSet<>();
//        HashSet<Integer> square = new HashSet<>();
//        for (int i = 0, a = 0; i < 9; i++) {
//            if (sudoku[i][right] != 0 && !ver.add(sudoku[i][right])) {
//                return false;
//            }
//            if (sudoku[i][right] != 0 && !hor.add(sudoku[left][i])) {
//                return false;
//            }
//            if(a < 3) {
//                for (int b = 0; b < 3; b++) {
////                    System.out.print("["+(3*(left/3)+a)+"]["+(3*(right/3)+b)+"] ");
//                    if (sudoku[3 * (left / 3) + a][3 * (right / 3) + b] != 0 && !square.add(sudoku[3 * (left / 3) + a][3 * (right / 3) + b])) {
////                        System.out.println();
//                        return false;
//                    }
//                }
////                System.out.println();
//                a++;
//            }
//        }
//        return true;
//    }
//}*/
