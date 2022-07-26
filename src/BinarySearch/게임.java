package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1072
public class 게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(token.nextToken());
        int Y = Integer.parseInt(token.nextToken());
        int start = 0;
        int end = X;
        int target = (int)Math.floor((((double)Y*100/X)));
        while(start < end) {
            int mid = (start+end)/2;
            if(Math.floor((((double)Y+mid)*100)/(X+mid)) > target)
                end = mid;
            else
                start = mid+1;
        }
        System.out.println(target == (int)Math.floor((((double)Y+start)*100)/(X+start)) ? -1 : start);
    }
}
