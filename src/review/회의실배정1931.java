package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정1931 {
    static class Session implements Comparable<Session> {
        int start;
        int end;
        Session(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Session o) {
            if(this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return "Session{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Session> list = new ArrayList<>();
        StringTokenizer token;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            list.add(new Session(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }
        Collections.sort(list);
        int cnt = 0;
        int cur = 0;
        for(Session s : list) {
            if(cur <= s.start) {
                cnt++;
                cur = s.end;
            }
        }
        System.out.println(cnt);
    }
}
