package co.kr.programmers;

import java.util.*;
import java.io.*;

public class 여행경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}})));
    }
    static boolean[] visited;
    static List<String> list;
    static boolean check(String[] s1, String[] s2) {
        return s1[0].equals(s2[0]) && s1[1].equals(s2[1]);
    }
    public static String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        Comparator<String[]> comp = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])) {
                    return Integer.compare(o1[1].charAt(0), o2[1].charAt(0));
                }
                return Integer.compare(o1[0].charAt(0), o2[0].charAt(0));
            }
        };

        Arrays.sort(tickets, comp);
        List<String[]> delete = new ArrayList<>();
        delete.add(tickets[0]);
        for(int i = 1; i < tickets.length; i++) {
            if(check(tickets[i-1], tickets[i])) {
                continue;
            }
            delete.add(tickets[i]);
        }
        String[][] deletedTickets = new String[delete.size()][2];
        for(int i = 0; i < delete.size(); i++) {
            deletedTickets[i] = delete.get(i);
        }
        visited = new boolean[delete.size()];
        list.add("ICN");
//        for(int i = 0; i < deletedTickets.length; i++) {
//            System.out.println(Arrays.toString(deletedTickets[i]));
//        }
        recur("ICN", deletedTickets);
        String[] result = new String[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    static void recur(String str, String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(str)) {
                visited[i] = true;
                list.add(tickets[i][1]);
                recur(tickets[i][1], tickets);
            }
        }
    }
}
