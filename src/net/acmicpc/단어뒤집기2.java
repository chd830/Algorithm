package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기2 {
    //    public static void main(String[] args) {
    public 단어뒤집기2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder b = new StringBuilder();
        String str = br.readLine();
//        str = str.replaceAll(">", "> ");
//        str = str.replaceAll("<", " <");
//        str = str.trim();
//        String[] strs = str.split(" ");

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                while(str.charAt(i) != '>') {
                    b.append(str.charAt(i));
                    i++;
                    System.out.println("StringBuilder: "+b.toString());
                }
                System.out.println(b.toString());
                b.append('>');
            }
            else {
                StringBuilder sb = new StringBuilder();
                while(str.charAt(i) != '<') {
                    sb.append(str.charAt(i));
                }
                b.append(sb.reverse());
            }
        }
        System.out.println(b.toString());
    }
}
