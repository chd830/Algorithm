package co.kr.programmers;

import java.util.*;

// https://fbtmdwhd33.tistory.com/249
public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4}));
    }
    public static List<String> solution(String[] orders, int[] course) {
        // 알파벳 순서대로 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[j].length())
                    comb(orders[j], sb, 0, 0, course[i]);
            }
            for(String key : map.keySet())
                max = Math.max(max, map.get(key));
            for(String key : map.keySet()) {
                if(max >= 2 && map.get(key) == max)
                    answer.add(key);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    static HashMap<String, Integer> map;
    static void comb(String str, StringBuilder sb, int idx, int cnt, int n) {
        if(cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        for(int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            comb(str, sb, i+1, cnt+1, n);;
            sb.delete(cnt, cnt+1);
        }
    }
}