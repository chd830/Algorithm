package review;

import java.util.*;
import java.io.*;

public class 로또 {
    static int[] sub;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while(true) {
            StringTokenizer token = new StringTokenizer(str);
            arr = new int[Integer.parseInt(token.nextToken())];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            sub = new int[6];
            visited = new boolean[arr.length];
            Arrays.sort(arr);
            lotto(0, 0);
            System.out.println();
            str = br.readLine();
            if(str.equals("0")) {
                break;
            }
        }
    }
    static void lotto(int idx, int subIdx) {
        if(subIdx == sub.length) {
            for(int i : sub) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = arr[i];
                lotto(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
}
