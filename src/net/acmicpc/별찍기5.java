package net.acmicpc;

import java.io.*;

public class 별찍기5 {
//    public static void main(String[] args) throws IOException {
    public 별찍기5() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            for(int j = num - 1 - i;j > 0; j--) {
                bw.write(" ");
            }
            for(int j = 0; j < i * 2 + 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
