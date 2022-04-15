package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42890
public class 후보키 {
    public static void main(String[] args) {
//        System.out.println(solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
        // 02, 03, 04 13 23
        System.out.println(solution(new String[][] {{"a", "1", "aaa", "c", "ng"}, {"a", "1", "bbb", "e", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}}));
    }
    static void subset(int idx, String[][] relation) {
        if(idx == visited.length) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                if(!visited[i])
                    list.add(i);
            }
            HashSet<String> set = new HashSet<>();
            if(list.size() != 0) {
                for(String[] r : relation) {
                    String str = "";
                    for(int i = 0; i < list.size(); i++)
                        str += r[list.get(i)];
                    if(!set.add(str)) {
                        return;
                    }
                }
                String str = "";
                for(int i = 0; i < list.size(); i++)
                    str += list.get(i);
                answerlist.add(str);
            }
            return;
        }
        visited[idx] = true;
        subset(idx+1, relation);
        visited[idx] = false;
        subset(idx+1, relation);
    }
    static List<String> answerlist;
    static boolean[] visited;
    public static int solution(String[][] relation) {
        answerlist = new ArrayList<>();
        visited = new boolean[relation[0].length];
        subset(0, relation);
        Collections.sort(answerlist, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
                return Integer.compare(o1.length(), o2.length());
            }
        });
        HashSet<String> set = new HashSet<>();
        set.add(answerlist.get(0));
        for(int i = 1; i < answerlist.size(); i++) {
            Iterator<String> iter = set.iterator();
            boolean flag = true;
            while(iter.hasNext()) {
                char[] c = iter.next().toCharArray();
                int cnt = 0;
                for(int j = 0; j < c.length; j++) {
                    if(answerlist.get(i).contains(""+c[j]))
                        cnt++;
                }
                if(cnt == c.length)
                    flag = false;
            }
            if(flag)
                set.add(answerlist.get(i));
        }
        return set.size();
    }
}
