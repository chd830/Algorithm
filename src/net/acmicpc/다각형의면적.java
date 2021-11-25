package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2166
public class 다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(arr, comp);
        double result = 0;
        // 점과 직선 사이의 거리 구하기
        for(int i = 1; i < N-1; i++) {
            double line = Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[i+1][0]), 2)+Math.pow(Math.abs(arr[i][1]-arr[i+1][1]), 2));
            // 직선의 방정식이 ax+by+c=0일 때 a/b는 x값의 증가량/y값의 증가량
            double a = Math.abs(arr[i][1] - arr[i+1][1]);
            double b = Math.abs(arr[i][0] - arr[i+1][0]);
            double c = -(a*arr[i][0]+b*arr[i][1]);
            // 점의 위치(i, j)
            double dist = Math.abs(a*arr[0][0]+b*arr[0][1]+c)/Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
            // |ai+bj+c| / root(a^2+b^2)
            result += Math.round((line*dist/2*100)/100.0);
            System.out.print(a+"x + "+b+"y + "+c+" = 0\t\t");
            System.out.println("("+arr[i][0]+", "+arr[i][1]+")\t("+arr[i+1][0]+", "+arr[i+1][1]+")\t\t"+line+" X "+dist+" = "+Math.round(line*dist*100)/100.0);
        }
        System.out.println(result);
    }
}
