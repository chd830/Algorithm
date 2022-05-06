package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16953
public class AtoB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());
        int k = 0;
        while(true) {
            if(end == start) {
                k++;
                break;
            }
            else if(end < start) {
                k = -1;
                break;
            }
            if(end%10 == 1)
                end /= 10;
            else if(end%2 == 0)
                end /= 2;
            else {
                k = -1;
                break;
            }
            k++;
        }
        System.out.println(k);
    }
}
