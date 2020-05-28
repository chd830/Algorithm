package net.acmicpc;

import java.io.*;

public class 별찍기4 {
    //    public static void main(String[] args) throws IOException {
    public 별찍기4() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         num = Integer.parseInt(br.readLine());
//        for(int i = num; i > 0; i--) {
//            for(int j = num; j >i; j--) {
//                bw.write(" ");
//            }
//            for(int j = i; j > 0; j--) {
//                bw.write("*");
//            }
//            bw.write("\N");
//        }
//        bw.flush();
        recur(num);
    }
    static int num;
    public static void recur(int start) {
        if(start < 0) {
            return;
        }
        for(int i = 0; i < num - start; i++) {
            System.out.print(" ");
        }
        for(int i = 0; i < start; i++) {
            System.out.print("*");
        }
        System.out.println();
        recur(start-1);
    }
}
