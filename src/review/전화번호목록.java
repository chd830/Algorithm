package review;

import java.util.*;
import java.io.*;

public class 전화번호목록 {
    static int N;
    static String[] arr;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        loop: for(int t = 0; t < T; t++) {
            check = false;
            N = Integer.parseInt(br.readLine());
            arr = new String[N];
            for(int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            for(int i = 0; i < N-1; i++) {
                if(arr[i].length() < arr[i+1].length()) {
                    int num = arr[i+1].indexOf(arr[i]);
                    check = num == -1 || num > 0;
                    if(!check) {
                        sb.append("NO").append("\n");
                        continue loop;
                    }
                }
            }
            sb.append("YES").append("\n");
        }
        System.out.println(sb.toString());
    }
    static void recur(String num1, String num2) {
        if(num1.length() < num2.length()) {
            check = num2.substring(0, num1.length()).equals(num1);
        }
        else {
            check = num1.substring(0, num2.length()).equals(num2);
        }
    }
}
