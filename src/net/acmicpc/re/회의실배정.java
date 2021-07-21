package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 1931
public class 회의실배정 {
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
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(rooms);
        int cnt = 1;
        int idx = 0;
        int val = rooms[0].end;
        while(++idx < N) {
            if(rooms[idx].start >= val) {
                val = rooms[idx].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
