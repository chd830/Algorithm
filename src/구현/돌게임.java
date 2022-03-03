package 구현;

import java.io.*;

// https://www.acmicpc.net/problem/9655
public class 돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N%2 == 0 ? "CY" : "SK");
    }
}
