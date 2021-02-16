package review;

import java.util.*;
import java.io.*;

public class 반복수열 {
    static int A;
    static int P;
    static int size;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        size = 0;
        A = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());
        list = new ArrayList<>();
        list.add(A);
        recur(A);
        System.out.println(size);
    }

    static void recur(int num) {
        int sum = 0;
        while(num > 10) {
            sum += Math.pow(num%10, P);
            num /= 10;
        }
        if(num == 10) {
            sum += 1;
        }
        else {
            sum += Math.pow(num, P);
        }
        if(list.contains(sum)) {
            size = list.subList(0, list.indexOf(sum)).size();
            return;
        }
        else {
            list.add(sum);
        }
        recur(sum);
    }
}
