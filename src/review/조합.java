package review;

import java.util.Arrays;

public class 조합 {
    /*
    A, B, C
    AB, BC, CA
     */
    static int[] arr = {1, 2, 3};
    static int[] sub = new int[2];

    public static void main(String[] args) {
        comb(0, 0);
    }
    public static void comb(int idx, int sub_idx) {
        if(sub_idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[sub_idx] = arr[idx];
        comb(idx+1, sub_idx+1);
        comb(idx+1, sub_idx);
    }
}
