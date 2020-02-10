package net.acmicpc;

import java.io.*;

public class 별찍기4 {
    //    public static void main(String[] args) throws IOException {
    public 별찍기4() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for(int i = num; i > 0; i--) {
            for(int j = num; j >i; j--) {
                bw.write(" ");
            }
            for(int j = i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
