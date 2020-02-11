package net.acmicpc;

import java.io.*;
import java.util.*;

public class 단어뒤집기2 {
    //    public static void main(String[] args) {
    public 단어뒤집기2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder b = new StringBuilder();
        String str = br.readLine();
//        String[] strs = str.split(">");
//        for(String s : strs)
//            System.out.println(s);
        Stack<Character> stack = new Stack<Character>();
        for(int i =0 ; i < str.length();) {
            if(str.charAt(i) == ' ') {
                b.append(' ');
                i++;
            }
            if(str.charAt(i) == '<') {
                while(str.charAt(i) != '>') {
                    b.append(str.charAt(i));
                    i++;
                }
                b.append('>');
                i++;
            }
            else {
                StringBuilder reverse = new StringBuilder();
                while(i < str.length() && (str.charAt(i) != ' ' && str.charAt(i) != '<')) {
                    reverse.append(str.charAt(i));
                    i++;
                }
                b.append(reverse.reverse());
            }
        }
        System.out.println(b.toString());
    }
}
