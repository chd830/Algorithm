package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2525
public class 오븐시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(token.nextToken());
        int minute = Integer.parseInt(token.nextToken());
        int time = Integer.parseInt(br.readLine());
        minute += time;
        if(minute >= 60) {
            hour += minute/60;
            minute %= 60;
        }
        if(hour >= 24) {
            hour %= 24;
        }
        System.out.println(hour+" "+minute);
    }
}
