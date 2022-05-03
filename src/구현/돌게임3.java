package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9657
public class 돌게임3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N%7 == 0 || N%7 == 2 ? "CY" : "SK");
    }
}
