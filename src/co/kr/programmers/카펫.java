package co.kr.programmers;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(10, 2)));
//        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
//        System.out.println(Arrays.toString(solution(14, 4)));
//        System.out.println(Arrays.toString(solution(18, 6)));
//        System.out.println(Arrays.toString(solution(20, 7)));
    }
    static int[] solution(int brown, int yellow) {
        int sum = brown+yellow;
        int n = 3;
        int m = 3;
        while(true) {
            for(m = 3; n*m <= sum; m++) {
                if(n*m == sum && (n-2)*(m-2) == yellow) {
                    if(n > m)
                        return new int[] {n, m};
                    else
                        return new int[] {m, n};

                }
            }
            n++;
        }
    }
}
