package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가르침1062 {
    static int N;
    static int K;
    static int max;
    static int[] alph;
    static String[] strs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        alph = new int[26];
        alph[0] = 1;
        alph[2] = 1;
        alph[8] = 1;
        alph[13] = 1;
        alph[19] = 1;
        max = 0;
        strs = new String[N];
        for(int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }
        setAlph(1, 0);
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        }
        else if(K == 26) {
            System.out.println(N);
            System.exit(0);
        }
        System.out.println(max);
    }
    //alph배열에서 0인자리에 1을 K-5개 만큼 넣는다.
    static void setAlph(int idx, int cnt) {
        if(cnt == K-5) {
            check();
            return;
        }
        if(idx >= 26) {
            return;
        }
        setAlph(idx+1, cnt);
        if(alph[idx] == 0) {
            alph[idx] = 1;
            setAlph(idx + 1, cnt + 1);
            alph[idx] = 0;
        }
    }
    static void check() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            boolean check = true;
            for(int j = 0, size = strs[i].length(); j < size; j++) {
                //각각의 strs에서 모든 charAt의 자리가 1이 아니라면 cnt++
                if(alph[strs[i].charAt(j)-97] == 0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                cnt++;
            }
        }
        //max = Math.max(max, cnt)로 가장 많이 해당하는 개수가 몇개인지 찾아서 출력
        max = Math.max(max, cnt);
    }
}
