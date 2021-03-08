package review;

import java.util.*;
import java.io.*;

// 병든 나이트
public class acmicpc1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        // 높이에 제한이 있을 경우에 사용할 수 있는 방법의 수
        if(N == 1) {
            System.out.println(1);
        }
        else if(N == 2) {
            System.out.println(Math.min(4, (M+1)/2));
        }
        // 이동 횟수가 4칸 이상
        else if(M < 7) {
            System.out.println(Math.min(4, M));
        }
        // 제약 없이 이동할 수 있는 경우
        else {
            System.out.println(M-2);
        }
    }
}
