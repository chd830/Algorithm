package review;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환 {
    // 가장 짧은 변환 과정은 bfs사용
    static class Node {
        String str;
        int cnt;
        Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
    public static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(begin, 0));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.str.equals(target)) {
                return n.cnt;
            }
            for(int i = 0; i < words.length; i++) {
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++) {
                    if(n.str.charAt(j) == words[i].charAt(j)) {
                        cnt++;
                    }
                }
                if(cnt == words[0].length()-1 && !visited[i]) {
                    visited[i] = true;
                    que.add(new Node(words[i], n.cnt+1));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
    }
}
