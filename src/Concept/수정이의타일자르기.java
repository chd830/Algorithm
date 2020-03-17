package Concept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수정이의타일자르기 {
    static int N;
    static int M;
    static int cnt;
    static int[] size;
    static class Rectangle implements Comparable<Rectangle> {
        int min;
        int max;
        Rectangle(int width, int height) {
            if(width < height) {
                min = width;
                max = height;
            }
            else {
                min = height;
                max = width;
            }
        }

        @Override
        public int compareTo(Rectangle o) {
            return o.min - this.min;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            cnt = 0;
            size = new int[N];

            token = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                size[i] = Integer.parseInt(token.nextToken());
            }
            cut();
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
    static PriorityQueue<Rectangle> que;
    private static void cut() {
        Arrays.sort(size);
        que = new PriorityQueue<>();
        que.offer(new Rectangle(M, M));
        ++cnt;

        for(int i = N-1; i >= 0; i--) {
            go(1 << size[i]);
        }
    }
    static void go(int size) {
        //que에서 poll(): min값이 최대인 직사각형이 뽑아짐
        //직사각형의 최소변의 길이가 size보다 같거나 크면 원하는 정사각형을 만들 수 있음
        Rectangle r = que.poll();
        if(r.min >= size) {
            que.offer(new Rectangle(r.min-size, size));
            que.offer(new Rectangle(r.min, r.max-size));
        }
        else {
            que.offer(r);
            que.offer(new Rectangle(M-size, size));
            que.offer(new Rectangle(M, M-size));
            ++cnt;
        }
    }
}
