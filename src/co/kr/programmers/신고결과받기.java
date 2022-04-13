package co.kr.programmers;

import java.util.*;
import java.io.*;

// https://programmers.co.kr/learn/courses/30/lessons/92334
public class 신고결과받기 {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(solution(new String[] {"muzi", "frodo", "apeach", "neo"}, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[] {"con", "ryan"}, new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }
    public static int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer =  new int[id_list.length];
        HashSet<String> set = new HashSet<>();
        // report가 중복되는 값이 없도록 set에 넣어서 확인
        for(String report : reports)
            set.add(report);
        // map의 값이 있다면 값을 반환하고 없다면 null을 반환하여 map에 신고당한 횟수(list.size()) 기록
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String report : set) {
            String key = report.split(" ")[0];
            String value = report.split(" ")[1];
            ArrayList<String> list = map.getOrDefault(value, null);
            if(list == null)
                list = new ArrayList<>();
            list.add(key);
            map.put(value, list);
        }
        // 신고당한 횟수가 k보다 많은지 count
        HashMap<String, Integer> hash = new HashMap<>();
        for(ArrayList<String> l : map.values()) {
            if(l.size() >= k) {
                for(String key : l)
                    hash.put(key, hash.getOrDefault(key, 0)+1);
            }
        }
        for(int i = 0; i < id_list.length; i++)
            answer[i] = hash.getOrDefault(id_list[i], 0);
        return answer;
    }
}
