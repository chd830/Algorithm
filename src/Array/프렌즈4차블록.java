package Array;

import java.util.*;

public class 프렌즈4차블록 {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
    static boolean[][] change;
    static Character[][] arr;
    public static int solution(int m, int n, String[] board) {
        arr = new Character[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        change = new boolean[m][n];
        while(check(m, n)) {
            setArr(m, n);
            change = new boolean[m][n];
        }
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == ' ')
                    count++;
            }
        }
        return count;
    }
    static void print() {
        for(int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    static void setArr(int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(change[i][j])
                    arr[i][j] = ' ';
            }
        }
//        print();
        for(int i = 0; i < n; i++) {
            int idx = 0;
            for(int j = m-1; j >= 0; j--) {
                if(arr[j][i] == ' ' && idx == 0) {
                    idx = j;
                }
                if(idx != 0 && arr[j][i] != ' ') {
                    arr[idx][i] = arr[j][i];
                    arr[j][i] = ' ';
                    idx--;
                }
            }
//            print();
        }
    }
    static boolean check(int m, int n) {
        boolean flag = false;
        for(int i = 0; i < m-1; i++) {
            for(int j = 0; j < n-1; j++) {
                if(arr[i][j] != ' ' && arr[i][j] == arr[i][j+1] && arr[i+1][j] == arr[i+1][j+1] && arr[i][j] == arr[i+1][j+1]) {
                    change[i][j] = change[i][j+1] = change[i+1][j] = change[i+1][j+1] = true;
                    flag = true;
                }
            }
        }
        return flag;
    }
}
