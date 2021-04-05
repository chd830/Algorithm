package review;

import java.util.*;
import java.io.*;

// 소수의 연속합
public class acmicpc1644 {
    static int N;
    static boolean[] prime;
    static List<Integer> numbers;
    // 저장된 소수들을 더한 값들을 방문가능으로 체크한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prime = new boolean[N+1];
        prime[0] = prime[1] = true;
        for(int i = 2; i*i <= N; i++){
            if(!prime[i])
                for(int j = i*i; j <= N; j+=i)
                    prime[j]=true;
        }
        numbers = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            if(!prime[i]) {
                numbers.add(i);
            }
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while(true) {
            if(sum >= N) {
                sum -= numbers.get(start++);
            }
            else if(end == numbers.size()) {
                break;
            }
            else {
                sum += numbers.get(end++);
            }
            if(N == sum) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
