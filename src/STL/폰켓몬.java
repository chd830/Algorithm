package STL;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
public class 폰켓몬 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 2, 3}));
    }
    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        return set.size() > nums.length/2 ? nums.length/2 : set.size();
    }
}
