package com.code;

public class MaximumProductSubarray {
    public int maxProduct(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int max = A[0];
        int min = A[0];
        int result = A[0];

        for (int i = 1; i < A.length; i++) {
            int temp = max;
            //A[i]가 양수일때는 max*A[i], A[i]가 음수일 때는 min*A[i]가 max값이 된다.
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            //A[i]가 음수일 때 최댓값이 되는 것을 감안하기 위해 최솟값을 구한다.
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
            System.out.println("max: "+max+", min: "+min+", A["+i+"]: "+A[i]);
        }
        return result;
    }
}
