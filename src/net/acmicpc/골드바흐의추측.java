package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6588
public class 골드바흐의추측 {
    static boolean[] prime = new boolean[12345678];
    static void setOdd() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i < prime.length; i++) {
            for(int j = i+i; j < prime.length; j += i)
                prime[j] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        setOdd();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        loop: while(target != 0) {
            int start = 0;
            int end = target;
            for(int i = 0; i <= target/2; i++) {
                if(prime[start] && prime[end])
                    break;
                start++;
                end--;
            }
            if(start == 0 && end == target)
                System.out.println("Goldbach's conjecture is wrong.");
            else
                System.out.println(target+" = "+start+" + "+end);
            target = Integer.parseInt(br.readLine());
        }
    }
}
