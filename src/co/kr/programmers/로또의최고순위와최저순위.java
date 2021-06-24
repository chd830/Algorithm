package co.kr.programmers;

import java.util.*;

public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35})));
    }
    static int[] grade = {6, 6, 5, 4, 3, 2, 1};
    public static int[] solution(int[] lottos, int[] win_nums) {
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int win : win_nums)
            set.add(win);
        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                max++;
                continue;
            }
            if(set.contains(lottos[i])) {
                min++;
            }
        }
        max += min;
        return new int[] {grade[max], grade[min]};
    }
}
