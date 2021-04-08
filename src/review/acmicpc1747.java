package review;

import java.util.*;
import java.io.*;

// 소수&팰린드롬
public class acmicpc1747 {
    static boolean[] prime = new boolean[1234567];
    static void checkPrime() {
        Arrays.fill(prime, true);
        prime[1] = false;
        for(int i = 2; i*i <= prime.length; i++) {
            for(int j = i*i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }
    }
    static boolean isPalindrome(int num) {
        int copy = num;
        StringBuilder sb = new StringBuilder();
        while(copy >= 10) {
            sb.append(copy%10);
            copy /= 10;
        }
        sb.append(copy);
        return String.valueOf(num).equals(sb.toString());
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        checkPrime();
        while(true) {
            if(prime[N] && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            N++;
        }
    }
}
