package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15787
public class 기차가어둠을헤치고은하수를 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1 i x: i번 기차 x좌석 사람추가
        // 2 i x: i번 기차 x좌석 하차
        // 3 i: i번 기차 좌석 한칸씩 뒤으로 이동. 마지막은 하차
        // 4 i: i번 기차 좌석 한칸씩 앞으로 이동. 1번째는 하차
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] trains = new int[N+1];
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(token.nextToken());
            int num = Integer.parseInt(token.nextToken());
            switch (command) {
                case 1:
                    int seat = Integer.parseInt(token.nextToken());
                    // num기차를 set만큼 왼쪽으로 비트이동
                    trains[num] |= (1 << seat);
                    break;
                case 2:
                    // num기차를 set만큼 오른쪽으로 비트이동
                    seat = Integer.parseInt(token.nextToken());
                    trains[num] &= ~(1 << seat);
                    break;
                case 3:
                    // 비트를 오른쪽으로 이동 후 21번째 값을 제거
                    trains[num] <<= 1;
                    trains[num] &= ((1 << 21)-1);
                    break;
                case 4:
                    // 비트를 왼쪽으로 이동 후 첫번째 값을 제거
                    trains[num] >>= 1;
                    trains[num] &= ~1;
                    break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            set.add(trains[i]);
        }
        System.out.println(set.size());
    }
}
