package 구현;

import javax.swing.*;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/8979
public class 올림픽 {
    static class Medal implements Comparable<Medal> {
        int nation;
        int gold;
        int silver;
        int cooper;
        Medal(int nation, int gold, int silver, int cooper) {
            this.nation = nation;
            this.gold = gold;
            this.silver = silver;
            this.cooper = cooper;
        }

        @Override
        public int compareTo(Medal o) {
            if(this.gold == o.gold) {
                if(this.silver == o.silver) {
                    return -Integer.compare(this.cooper, o.cooper);
                }
                return -Integer.compare(this.silver, o.silver);
            }
            return -Integer.compare(this.gold, o.gold);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int target = Integer.parseInt(token.nextToken());
        Medal[] nation = new Medal[N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            nation[i] = new Medal(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        Arrays.sort(nation);
        int rank = 1;
        int cnt = 0;
        Medal prev = null;
        for(int i = 0; i < N; i++) {
            if(prev != null && (prev.gold != nation[i].gold || prev.silver != nation[i].silver || prev.cooper != nation[i].cooper)) {
                rank += cnt;
                cnt = 1;
            }
            else
                cnt++;
            if(nation[i].nation == target) {
                System.out.println(rank);
                break;
            }
            prev = nation[i];
        }
    }
}
/*
4 2
1 1 0 0
2 1 0 0
3 2 0 0
4 2 0 0

5 2
1 2 0 0
2 2 0 0
3 4 0 0
4 4 0 0
5 6 0 0
*/