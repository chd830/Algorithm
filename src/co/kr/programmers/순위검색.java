package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/72412
public class 순위검색 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})));
    }
    public static int[] solution(String[] information, String[] query) {
        int[] answer = new int[query.length];
        infomap = new HashMap<>();
        for(String info : information) {
            String[] split = info.split(" ");
            makeMap(split, "", 0);
        }
        for(String key : infomap.keySet())
            Collections.sort(infomap.get(key));
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] tmp = query[i].split(" ");
            answer[i] = infomap.containsKey(tmp[0]) ? search(tmp[0], Integer.parseInt(tmp[1])): 0;
        }
        return answer;
    }
    // list에서 해당하는 점수만큼을 반환해준다.
    static int search(String key, int score) {
        List<Integer> list = infomap.get(key);
        int start = 0;
        int end = list.size()-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(list.get(mid) < score)
                start = mid+1;
            else
                end = mid-1;
        }
        return list.size()-start;
    }
    // 될 수 있는 모든 조합을 infomap에 저장
    static HashMap<String, List<Integer>> infomap;
    static void makeMap(String[] info, String str, int cnt) {
        if(cnt == 4) {
            if(!infomap.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                infomap.put(str, list);
            }
            infomap.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        makeMap(info, str+"-", cnt+1);
        makeMap(info, str+info[cnt], cnt+1);
    }
}
