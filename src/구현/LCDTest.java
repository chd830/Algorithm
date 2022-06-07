package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2290
public class LCDTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        size = Integer.parseInt(token.nextToken());
        String str = token.nextToken();
        list = new ArrayList[2*(size+1)+1];
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            set(str.charAt(i)-'0');
            setNext();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.length; i++) {
            for(String s : list[i])
                sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int size;
    static List<String>[] list;
    static void setNext() {
        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < 1; j++)
                list[i].add(" ");
        }
    }
    static void set(int num) {
        switch (num) {
            case 0:
                idx = 0;
                hor();
                both();
                blank();
                both();
                hor();
                break;
            case 1:
                idx = 0;
                blank();
                right();
                blank();
                right();
                blank();
                break;
            case 2:
                idx = 0;
                hor();
                right();
                hor();
                left();
                hor();
                break;
            case 3:
                idx = 0;
                hor();
                right();
                hor();
                right();
                hor();
                break;
            case 4:
                idx = 0;
                blank();
                both();
                hor();
                right();
                blank();
                break;
            case 5:
                idx = 0;
                hor();
                left();
                hor();
                right();
                hor();
                break;
            case 6:
                idx = 0;
                hor();
                left();
                hor();
                both();
                hor();
                break;
            case 7:
                idx = 0;
                hor();
                right();
                blank();
                right();
                blank();
                break;
            case 8:
                idx = 0;
                hor();
                both();
                hor();
                both();
                hor();
                break;
            case 9:
                idx = 0;
                hor();
                both();
                hor();
                right();
                hor();
                break;
        }
    }
    static int idx;
    static void both() {
        for(int j = size; j > 0; j--) {
            list[idx].add("|");
            for(int k = size; k > 0; k--)
                list[idx].add(" ");
            list[idx++].add("|");
        }
    }
    static void left() {
        for(int j = size; j > 0; j--) {
            list[idx].add("|");
            for(int k = size; k > 0; k--)
                list[idx].add(" ");
            list[idx++].add(" ");
        }
    }
    static void hor() {
        list[idx].add(" ");
        for(int j = size; j > 0; j--)
            list[idx].add("-");
        list[idx++].add(" ");
    }
    static void right() {
        for(int j = size; j > 0; j--) {
            for(int k = size; k > 0; k--)
                list[idx].add(" ");
            list[idx].add(" ");
            list[idx++].add("|");
        }
    }
    static void blank() {
        list[idx].add(" ");
        for(int j = size; j > 0; j--)
            list[idx].add(" ");
        list[idx++].add(" ");
    }
}
