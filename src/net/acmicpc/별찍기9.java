package net.acmicpc;

import java.io.*;

public class 별찍기9 {
    static int num;
//    public static void main(String[] args) throws IOException {
    public 별찍기9() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        recur(0, 0);
    }
    public static void recur(int start, int count) {
        if(count + 1 >= num * 2) {
            return;
        }
        for(int i = start; i < num; i++) {
            System.out.print(" ");
        }
        for(int i = 2*(num - start)-1; i > 0; i--) {
            System.out.print("*");
        }
    }
}
