package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1107
public class 리모컨 {
    static int answer;
    static boolean[] nums = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Arrays.fill(nums, true);
        if(M != 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                nums[Integer.parseInt(token.nextToken())] = false;
            }
        }

        if(N.equals("100")) {
            System.out.println(0);
            System.exit(0);
        }
        int tmp = Integer.parseInt(N);
        // 모든 숫자가 접근할 수 없을 경우의 값
        answer = Math.abs(100-tmp);
        for(int i = 1000000; i >= 0; i--) {
            if(check(i))
                answer = Math.min(answer, (""+i).length()+Math.abs(i-tmp));
        }
        System.out.println(answer);
    }
    static boolean check(int i) {
        while(i >= 10) {
            if(nums[i%10])
                i /= 10;
            else
                return false;
        }
        return nums[i];
    }
}
