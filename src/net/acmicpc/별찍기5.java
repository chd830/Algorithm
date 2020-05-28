package net.acmicpc;

import java.io.*;

public class 별찍기5 {
//    public static void main(String[] args) throws IOException {
    public 별찍기5() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
//        for(int i = 0; i < num; i++) {
//            for(int j = num - 1 - i;j > 0; j--) {
//                bw.write(" ");
//            }
//            for(int j = 0; j < i * 2 + 1; j++) {
//                bw.write("*");
//            }
//            bw.write("\N");
//        }
//        bw.flush();
        recur(1);
    }
    static int num;
    public static void recur(int start) {
        if(start > num) {
            return;
        }
        for(int i = num-start; i > 0; i--) {
            System.out.print(" ");
        }
        for(int i = 0; i < 2*start-1; i++) {
            System.out.print("*");
        }
        System.out.println();
        recur(start+1);
    }
}
