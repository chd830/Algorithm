package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
    static int[] dwarfs = new int[9];
    static int[] sub = new int[7];
    static boolean[] visited = new boolean[dwarfs.length];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        perm(0);
    }
    public static void perm(int idx) {
        if(idx == sub.length) {
            int sum = 0;
            for(int i = 0; i < sub.length; i++) {
                sum += sub[i];
            }
            if(sum == 100) {
                Arrays.sort(sub);
                for(int i = 0; i < sub.length; i++) {
                    System.out.println(sub[i]);
                }
                System.exit(0);
            }
            return;
        }
        for(int i = 0; i < dwarfs.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = dwarfs[i];
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}
