package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
    public String solution(int[] nums) {
        String answer = "";
        String[] arrs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arrs[i] = "" + nums[i];
        }
        Arrays.sort(arrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(arrs[0].equals("0"))
            return "0";
        for(String arr : arrs) {
            answer += arr;
        }
        return answer;
    }
//    시간초과
//    public String solution(int[] nums) {
//        String answer = "";
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int o1 = nums[i];
//                int o2 = nums[j];
//                double o_1 = o1 / Math.pow(10, (int)(Math.log10(o1)));
//                double o_2 = o2 / Math.pow(10, (int)(Math.log10(o2)));
//                if (o_1 < o_2) {
//                    recur(nums, i, j);
//                }
//                else if (o_1 == o_2) {
//                    o_1 = o1 % Math.pow(10, (int)(Math.log10(o1)));
//                    o_2 = o2 % Math.pow(10,(int) (Math.log10(o2)));
//                    if (o_1 > o_2) {
//                        recur(nums, i, j);
//                    }
//                    else if (o_1 == o_2) {
//                        if(o1 > o2)
//                            recur(nums, i, j);
//                    }
//                }
//            }
//        }
//        for (int num : nums)
//            answer += num;
//        return answer;
//    }

    public int[] recur(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
//            public int compare(Integer o1, Integer o2) {
//                if(o1 / (int)(Math.log10(o1) + 1) > o2 / (int)(Math.log10(o2) + 1)) {
//                    return 1;
//                }
//                else if(o1 / (int)(Math.log10(o1) + 1) < o2 / (int)(Math.log10(o2) + 1)) {
//                    return -1;
//                }
//                else {
//                    if(o1 % (int)(Math.log10(o1) + 1) < o2 % (int)(Math.log10(o2) + 1)) {
//                        return -1;
//                    }
//                    else if(o1 % (int)(Math.log10(o1) + 1) >= o2 % (int)(Math.log10(o2) + 1)) {
//                        return 1;
//                    }
//                    return 0;
//                }
//            }

}
