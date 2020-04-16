package Concept;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP01_gwangju_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        if(N < 4) {
            System.out.println(D[N]);
            System.exit(0);
        }
        for(int i = 4; i <= N; i++) {
            D[i] = D[i-3] + D[i-2] + D[i-1];
        }
        System.out.println(D[N]);
    }
}
