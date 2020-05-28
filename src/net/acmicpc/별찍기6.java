package net.acmicpc;

import java.io.*;

public class 별찍기6 {
//    public static void main(String[] args) throws IOException {
    public 별찍기6() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        recur(num);
//        for(int i = num; i >= 0; i--) {
//            for(int j = 0; j < num - i; j++) {
//                bw.write(" ");
//            }
//            for(int j = 0; j < 2 * i - 1; j++) {
//                bw.write("*");
//            }
//            bw.write("\N");
//        }
//        bw.flush();
    }
    static int num;
    public static void recur(int start) {
        if(start < 0) {
            return;
        }
        for(int i = num-start; i > 0; i--) {
            System.out.print(" ");
        }
        for(int i = start*2-1; i > 0; i--) {
            System.out.print("*");
        }
        System.out.println();
        recur(start-1);
    }
}
