package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11758
// 참고 https://codecollector.tistory.com/431
public class CCW {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][2];
        for(int i = 0; i < 3; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        int result = (arr[1][0]-arr[0][0])*(arr[2][1]-arr[0][1]) - (arr[1][1]-arr[0][1])*(arr[2][0]-arr[0][0]);
        if(result > 0)
            System.out.println(1);
        else if(result == 0)
            System.out.println(0);
        else
            System.out.println(-1);
    }
}
