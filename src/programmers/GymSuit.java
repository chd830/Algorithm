package programmers;

import java.util.Arrays;

public class GymSuit {
    public int solution(int n, int[] lost, int[] extra) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(extra);

        //같은 값이 있는지를 확인해서 lost, extra 둘 다에서 제외한 후  1 차이나는 값 찾기
        for(int i = 0; i < lost.length; i++) {
            for(int j = extra.length - 1; j >= 0; j--) {
                if(lost[i] == extra[j]) {
                    System.out.println("same value "+lost[i]+", "+extra[j]);
                    lost[i] = Integer.MIN_VALUE;
                    extra[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return answer;
    }
}
