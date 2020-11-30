package review;

import java.io.*;

public class 분해합 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 1000000; i++) {
            recur(i, i, i);
            if(i >= N) {
                System.out.println(0);
                System.exit(0);
            }
        }
    }
    public static void recur(int res, int num, int start) {
        if(num == 0) {
            if(res == N) {
                System.out.println(start);
                System.exit(0);
            }
            return;
        }

        if(num < 10) {
            recur(res + num, 0, start);
        }
        else if(num == 10) {
            recur(res + 1, 0, start);
        }
        else {
            recur(res + num%10, num/10, start);
        }
    }
}
