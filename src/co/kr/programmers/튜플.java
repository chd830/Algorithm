package co.kr.programmers;

import java.util.Arrays;

public class 튜플 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }
    static int[] nums = new int[1000001];
    public static int[] solution(String s) {
        s = s.replaceAll("\\{", "").replaceAll("\\},", " ").replaceAll("\\}", "");
        String[] splits = s.split(" ");
        System.out.println(Arrays.toString(splits));
        for(String split : splits) {
            String[] num = split.split(",");
            for(String n : num) {
                nums[Integer.parseInt(n)]++;
            }
//            System.out.println(Arrays.toString(num));
        }
        int[] answer = new int[splits.length];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != 0) {
                answer[splits.length-nums[i]] = i;
            }
        }
        return answer;
    }
}
