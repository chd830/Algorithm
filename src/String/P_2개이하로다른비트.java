package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/77885
public class P_2개이하로다른비트 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[] {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100})));
//        System.out.println(Arrays.toString(solution(new long[] {100})));
    }
    public static long findChangeIdx(long n) {
        long idx = 0;
        while(n > 0) {
            if(n%2 == 0) {
                return idx;
            }
            n /= 2;
            idx++;
        }
        return idx;
    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int i = 0;
        loop: for(long num : numbers) {
            // 기준 숫자
            long idx = findChangeIdx(num);
            if(idx == 0)
                num++;
            else
                num += Math.pow(2, idx) - Math.pow(2, idx-1);
            answer[i++] = num;
        }
        return answer;
    }
}
