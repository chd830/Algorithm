package net.acmicpc;

import java.io.*;

public class 별찍기3 {
    //    public static void main(String[] args) throws IOException {
    public 별찍기3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        recur(num);
//        for(int i = num; i > 0; i--) {
//            for(int j = i; j > 0; j--) {
//                bw.write("*");
//            }
//            bw.write("\n");
//        }
//        bw.flush();
    }
    public static void recur(int start) {
        if(start < 0) {
            return;
        }
        for(int i = 0; i < start; i++) {
            System.out.print("*");
        }
        System.out.println();
        recur(start-1);
    }
}
