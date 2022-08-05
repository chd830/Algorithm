package STL;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class P_같은숫자는싫어 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {4, 4, 4, 3, 3})));
    }
    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int a : arr) {
            if(stack.isEmpty() || stack.peek() != a) {
                list.add(a);
            }
            stack.push(a);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
