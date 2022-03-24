package co.kr.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수re {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {6, 10, 2}));
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int[] {97, 978}));
    }
    public static String solution(int[] nums) {
        if(nums[0] == 0 && nums[1] == 0) {
            return "0";
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        };
        String[] numsToStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            numsToStr[i] = ""+nums[i];
        Arrays.sort(numsToStr, comp);
        String answer = "";
        for(String s : numsToStr)
            answer += s;
        return answer;
    }
}