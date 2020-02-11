package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기8 {
    static int num;
//    public static void main(String[] args) throws IOException {
    public 별찍기8() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        recur(1, 0);
    }
    public static void recur(int start, int count) {
        if(count + 1 >= num*2) {
            return;
        }
        for(int i = 0; i < start && start <= num; i++) {
            System.out.print("*");
        }
        for(int i = (num-start)*2; i > 0; i--) {
            System.out.print(" ");
        }
        for(int i = 0; i < start && start <= num; i++) {
            System.out.print("*");
        }
        System.out.println("");
        if(count+1 >= num) {
            recur(start - 1, count+1);
        }
        else if(count < num) {
            recur(start + 1, count+1);
        }
    }
}
