package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class GymSuit {
    public int solution(int n, int[] lost, int[] extra) {
        HashSet<Integer> set = new HashSet<>();
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(extra);

        for(int e : extra) {
            set.add(e);
        }
        for(int i = 0; i < lost.length; i++) {
            if(set.contains(lost[i])) {
                answer++;
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }

        for(int i = 0; i < lost.length; i++) {
            if(set.contains(lost[i] - 1)) {
                answer++;
                set.remove(lost[i] - 1);
            }
            else if(set.contains(lost[i] + 1)) {
                answer++;
                set.remove(lost[i] + 1);
            }

        }


//        //같은값을 찾아서 Integer.MIN_VALUE로 바꿈
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = extra.length - 1; j >= 0; j--) {
//                if (lost[i] == extra[j]) {
//                    System.out.println("same value " + lost[i] + ", " + extra[j]);
//                    lost[i] = Integer.MIN_VALUE;
//                    extra[j] = Integer.MIN_VALUE;
//                    answer++;
//                    break;
//                }
//            }
//        }
//        //1 차이나는 값이 있는지를 확인
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = extra.length - 1; j >= 0; j--) {
//                if (Math.abs(lost[i] - extra[j]) == 1) {
//                    System.out.println("1차이 남. " + lost[i] + ", " + extra[j]);
//                    lost[i] = Integer.MIN_VALUE;
//                    extra[j] = Integer.MIN_VALUE;
//                    answer++;
//                    break;
//                }
//            }
//        }
        return answer;
    }
}
