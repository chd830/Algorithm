package net.acmicpc;


import java.io.*;

public class 별찍기1 {
//    public static void main(String[] args) throws IOException {
    public 별찍기1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        recur(1);
//        for(int i = 0; i < num; i++) {
//            for(int j = 0; j <= i; j++) {
//                bw.write("*");
//            }
//            bw.write("\N");
//        }
//        bw.flush();
    }
    static int num;
    public void recur(int start) {
        if(start > num) {
            return;
        }
        for(int i = 0; i < start; i++) {
            System.out.print("*");
        }
        System.out.println();
        recur(start+1);
    }
}
