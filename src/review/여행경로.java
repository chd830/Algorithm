package review;

import java.util.*;

public class 여행경로 {
    static boolean[] visited;
    static String[] answer;
    static int idx;
    public static String[] solution(String[][] tickets) {
        idx = 0;
        for(int i = 0; i < tickets.length-1; i++) {
            for(int j = i+1; j < tickets.length; j++) {
                if(tickets[i][0].equals(tickets[j][0].charAt(0))) {
                    if(tickets[i][1].charAt(0) > tickets[j][1].charAt(0)) {
                        String[] tmp = tickets[i];
                        tickets[i] = tickets[j];
                        tickets[j] = tmp;
                    }
                }
                else if(tickets[i][0].charAt(0) > tickets[j][0].charAt(0)) {
                    String[] tmp = tickets[i];
                    tickets[i] = tickets[j];
                    tickets[j] = tmp;
                }
            }
        }
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN");
        return answer;
    }
    static void dfs(String[][] tickets, String str) {
        answer[idx++] = str;
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(str) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1]);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}})));
        System.out.println(Arrays.toString(solution(new String[][] {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}})));
    }
}
