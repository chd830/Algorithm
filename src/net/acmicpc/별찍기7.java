package net.acmicpc;

import java.io.*;
import java.util.Scanner;

public class 별찍기7 {
    static int num;
//    public static void main(String[] args) throws IOException{
    public 별찍기7() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num = Integer.parseInt(br.readLine());
        recur(1, 0);
    }
    public static void recur(int start, int count) {
        if(count > num*2) {
            return;
        }
        for(int i = start; i < num; i++) {
            System.out.print(" ");
        }
        for(int i = 0; i < 2*start-1; i++) {
            System.out.print("*");
        }
        System.out.println();
        if(count + 1 >= num) {
            recur(start-1, count+1);
        }
        else {
            recur(start+1, count+1);
        }

    }
}
