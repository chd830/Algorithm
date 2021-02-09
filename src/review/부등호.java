package review;

import java.util.*;
import java.io.*;
public class 부등호 {
    static int K;
    static Long max = Long.MIN_VALUE;
    static Long min = Long.MAX_VALUE;
    static int[] arr;
    static int[] maxArr;
    static boolean[] visited;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        arr = new int[K+1];
        maxArr = new int[K+1];
        visited = new boolean[K+1];
        check = new boolean[K];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            if(token.nextToken().equals("<")) {
                check[i] = true;
            }
            else {
                check[i] = false;
            }
        }
        perm(0);
        for(int i = 0; i < maxArr.length; i++) {
            maxArr[i] = 9-(K-maxArr[i]);
        }
        System.out.println(arrToInt(maxArr));
        System.out.println(Math.log10(min) <= K ? "0"+min : min);
    }
    static Long arrToInt(int[] arr) {
        String sum = "";
        for(int a : arr) {
            sum += a;
        }
        return Long.parseLong(sum);
    }
    static boolean check() {
        for(int i = 0; i < K; i++) {
            if(check[i] && arr[i] < arr[i+1]) {
                continue;
            }
            else if(!check[i] && arr[i] > arr[i+1]) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    static void perm(int idx) {
        if(idx == K+1) {
//            System.out.println(Arrays.toString(arr)+"\t"+check());
            if(check()) {
                Long res = arrToInt(arr);
                if(max < res) {
                    max = res;
                    maxArr = arr.clone();
                }
                min = Math.min(min, res);
            }
            return;
        }
        for(int i = 0; i < K+1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
