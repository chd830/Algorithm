package BFS.DFS;

import java.io.IOException;
import java.util.*;

public class 카카오3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution(info, query);
    }
    public static int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        String[] conditions = new String[5];
        for(int i = 0; i < queries.length; i++) {
            int idx = 0;
            String[] splitQuery = queries[i].split(" ");
            for(String split : splitQuery) {
                if(split.equals("and")) {
                    continue;
                }
                conditions[idx++] = split;
            }
            int cnt = 0;
            compare:for(int j = 0; j < infos.length; j++) {
                String[] splitInfos = infos[j].split(" ");
                for(int k = 0; k < 4; k++) {
                    if(conditions[k].equals("-") || splitInfos[k].equals("-") || conditions[k].equals(splitInfos[k])) {
                        continue;
                    }
                    continue compare;
                }
                if(Integer.parseInt(conditions[4]) <= Integer.parseInt(splitInfos[4])) {
                    answer[i]++;
                }
            }

        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
