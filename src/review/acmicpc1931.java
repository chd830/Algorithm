package review;

import java.util.*;
import java.io.*;

// 회의실 배정
public class acmicpc1931 {
    static class Room implements Comparable<Room> {
        int start;
        int end;
        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if(this.end == o.end)
                return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }

        @Override
        public String toString() {
            return "Room{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];
        StringTokenizer token = null;
        int max = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
            max = Math.max(max, Math.max(rooms[i].start, rooms[i].end));
        }
        Arrays.sort(rooms);
        int last = rooms[0].end;
        int cnt = 1;
        for(int i = 1; i < N; i++) {
            if(rooms[i].start >= last) {
                cnt++;
                last = rooms[i].end;
            }
        }
        System.out.println(cnt);
    }
}
