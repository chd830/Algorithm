package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수팰린드롬1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(true) {
            if(isPrimeNumber(N) && isPalindrome(N)) {
                System.out.println(N);
                System.exit(0);
            }
            N++;
        }
    }
    //배수들을 통해서 나눠지는 값이 있는지 확인
    static boolean isPrimeNumber(int N) {
        if(N == 1) {
            return false;
        }
        for(int i = 2; i*i <= N; i++) {
            if(N%i == 0) {
                return false;
            }
        }
        return true;
    }
    //팰린드롬인지 확인
    static boolean isPalindrome(int N) {
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        if(sb.toString().equals(sb.reverse().toString())) {
            return true;
        }
        return false;
    }
}
