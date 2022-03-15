package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/20207
public class 달력 {
    static class Date implements Comparable<Date> {
        int start;
        int end;
        Date(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Date o) {
            return Integer.compare(this.end, o.end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        int[] d = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        for(int i = 0 ;i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            start = Math.min(n1, start);
            end = Math.max(n2, end);
            while(n1 <= n2)
                d[n1++]++;
        }
        int result = 0;
        int height = 0;
        for(int i = start; i <= end+1; i++) {
            if(d[i] == 0) {
                result += height * (i-start);
                height = 0;
                start = -1;
            }
            else if(start == -1)
                start = i;
            height = Math.max(height, d[i]);
        }
        System.out.println(result);
    }
}