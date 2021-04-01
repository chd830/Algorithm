package review;

import java.util.*;
import java.io.*;

// Base Conversion
public class acmicpc11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // A to hexa
        int hexa = 0;
        for(int i = N-1, j = 0; i >= 0; i--, j++) {
            hexa += (int)Math.pow(A, j)*arr[i];
        }
        // hexa to B
        List<Integer> list = new ArrayList<>();
        while(hexa >= B) {
            list.add(hexa%B);
            hexa /= B;
        }
        list.add(hexa);
        for(int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
    }

}
