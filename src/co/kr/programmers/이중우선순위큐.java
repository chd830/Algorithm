package co.kr.programmers;

import java.util.*;

public class 이중우선순위큐 {
    /*
    입력값 〉	["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
    기댓값 〉	[0, 0]

    입력값 〉	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]
    기댓값 〉	[333, -45]
     */
    static List<Integer> list;
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
    public static int[] solution(String[] operations) {
        list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(String oper : operations) {
            String[] splitOper = oper.split(" ");
            switch (splitOper[0]) {
                case "I":
                    list.add(Integer.parseInt(splitOper[1]));
                    break;
                case "D":
                    if(splitOper[1].equals("1")) {
                        if(!list.isEmpty())
                            list.remove(list.size()-1);
                    }
                    else {
                        if (!list.isEmpty())
                            list.remove(list.remove(0));
                    }
                    break;
            }
            Collections.sort(list);
        }
        if(!list.isEmpty()) {
            max = Math.max(max, list.get(list.size() - 1));
            min = Math.min(min, list.get(0));
        }
        return new int[] {max, min == Integer.MAX_VALUE ? 0 : min};
    }
}
