package net.acmicpc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 스도쿠 {
    static int[][] sudoku;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }
        sudoku(0, 0);
        print();
    }

    public static void sudoku(int x, int y) {
        if(y == 9) {
            sudoku(x+1, 0);
            return;
        }
        if(x == 9) {
            return;
        }
//        print();
//        System.out.println();
        if(sudoku[x][y] != 0) {
            sudoku(x, y+1);
        }
        else if(sudoku[x][y] == 0) {
            for(int i = 1; i < 10; i++) {
                sudoku[x][y] = i;
                if(isPossible(x, y)) {
                    sudoku(x, y + 1);
                    return;
                }
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        HashSet<Integer> ver = new HashSet<>();
        HashSet<Integer> hor = new HashSet<>();
        HashSet<Integer> square = new HashSet<>();
        for (int i = 0, a = 0; i < 9; i++) {
//            System.out.print(sudoku[i][y]+" ");
            if (sudoku[i][y] != 0 && !ver.add(sudoku[i][y])) {
//                System.out.println();
                return false;
            }
        }
//        System.out.println();
        for(int i = 0; i < 9; i++) {
            System.out.print(sudoku[x][i]+" ");
            if (sudoku[i][y] != 0 && !hor.add(sudoku[x][i])) {
                System.out.println();
                return false;
            }
        }
        System.out.println();
        for (Iterator<Integer> it = hor.iterator(); it.hasNext(); ) {
            int key = it.next();
            System.out.print(key+" ");
        }
        System.out.println();
        for(int a = 0; a < 3; a++) {
//            if(a < 3) {
                for (int b = 0; b < 3; b++) {
                    if (sudoku[3 * (x / 3) + a][3 * (y / 3) + b] != 0 && !square.add(sudoku[3 * (x / 3) + a][3 * (y / 3) + b])) {
                        return false;
                    }
//                }
//                a++;
                }
        }
        System.out.println();
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

//    public static void setSudoku(int x, int y) {
//        for (int i = 1; i <= 9; i++) {
//            sudoku[x][y] = i;
//            if (isSudoku(x, y)) {
//                return;
//            }
//        }
//    }
//

//
//    public static boolean isSudoku(int x, int y) {
//        HashSet<Integer> ver = new HashSet<>();
//        HashSet<Integer> hor = new HashSet<>();
//        HashSet<Integer> square = new HashSet<>();
//        for (int i = 0, a = 0; i < 9; i++) {
//            if (sudoku[i][y] != 0 && !ver.add(sudoku[i][y])) {
//                return false;
//            }
//            if (sudoku[i][y] != 0 && !hor.add(sudoku[x][i])) {
//                return false;
//            }
//            if(a < 3) {
//                for (int b = 0; b < 3; b++) {
////                    System.out.print("["+(3*(x/3)+a)+"]["+(3*(y/3)+b)+"] ");
//                    if (sudoku[3 * (x / 3) + a][3 * (y / 3) + b] != 0 && !square.add(sudoku[3 * (x / 3) + a][3 * (y / 3) + b])) {
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
//}