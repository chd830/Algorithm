package review;

import java.util.*;
import java.io.*;

// 대회 or 인턴
public class acmicpc2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int total = N+M;
        //K명이 인턴쉽에 참여해야할 때 여자2남자1로 이루어진 대회는 몇팀 나갈수 있는가?
        //몇팀이 나올 수 있는지 체크
        int team = 0;
        team = Math.min(N/2, M);
        //전체인원-팀원수 후 K보다 작다면 팀-1
        while(total-team*3 < K) {
            team--;
        }
        System.out.println(team);
    }
}