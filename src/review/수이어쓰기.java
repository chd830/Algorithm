package review;

import java.io.*;

public class 수이어쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        int len = (int) Math.log10(N);
        long res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.pow(10, i) * 9 * (i + 1);
        }
        res += (len + 1) * (N - Math.pow(10, len) + 1);
        System.out.println(res);
    }
}
