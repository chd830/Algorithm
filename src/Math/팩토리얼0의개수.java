package Math;

import java.util.*;
import java.io.*;

public class 팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        while(N >= 5) {
            answer += N/5;
            N /= 5;
        }
        System.out.println(answer);
    }
}
