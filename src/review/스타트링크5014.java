package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int floor = Integer.parseInt(token.nextToken());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());
        int up = Integer.parseInt(token.nextToken());
        int down = Integer.parseInt(token.nextToken());
        int[] cnt = new int[floor+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        cnt[start] = 1;
        while(!que.isEmpty()) {
            int cur = que.poll();
            if(cur == end) {
                System.out.println(cnt[cur]-1);
                System.exit(0);
            }
            if (cur + up <= floor && cnt[cur+up] == 0) {
                que.add(cur + up);
                cnt[cur+up] = cnt[cur]+1;
            }
            if (cur - down > 0 && cnt[cur-down] == 0) {
                que.add(cur - down);
                cnt[cur-down] = cnt[cur]+1;
            }
        }
        System.out.println("use the stairs");
    }
}
