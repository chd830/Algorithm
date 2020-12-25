package review;

import java.io.*;

public class 신기한소수 {
    static StringBuilder sb;
    static int[] nums = {1, 2, 3, 5, 7, 9};
    static int[] sub;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        sub = new int[N];
        dfs("", 0);
        System.out.println(sb);
    }
    static void dfs(String s, int idx) {
        if(idx == N) {
            sb.append(s).append("\n");
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            //자릿수가 추가될때마다 소수인지 체크한 후 다음 dfs함수로 넘어간다.
            //수를 먼저 만든 후 자릿수를 나눠서 소수인지 체크하면 메모리 초과 에러
            if(check(Integer.parseInt(s+nums[i]))) {
                dfs(s+nums[i], idx+1);
            }
        }
    }
    static boolean check(int num) {
        if(num == 1) {
            return false;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
