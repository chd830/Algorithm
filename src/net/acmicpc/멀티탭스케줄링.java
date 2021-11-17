package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1700
public class 멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[K];
        token = new StringTokenizer(br.readLine());
        boolean[] check = new boolean[101];
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int cnt = 0;
        int tmp = N;
        for(int i = 0; i < K; i++) {
            if(check[arr[i]])
                continue;
            if(tmp > 0) {
                tmp--;
                check[arr[i]] = true;
            }
            else {
                if(check[arr[i]])
                    continue;
                List<Integer> list = new ArrayList<>();
                // 뒤에서도 쓰이는 콘센트 체크
                for(int j = i; j < K; j++) {
                    if(check[arr[j]] && !list.contains(arr[j]))
                        list.add(arr[j]);
                }
                // 나중에 사용해도 되는 콘센트의 개수가 구멍보다 작을 때
                // 제일 처음 중복되는 콘센트를 제거한다.
                if(list.size() != N) {
                    for(int j = 0; j < check.length; j++) {
                        if (check[j] && !list.contains(j)) {
                            check[j] = false;
                            break;
                        }
                    }
                }
                // 모든 콘센트가 사용빈도가 동일할 경우
                else {
                    check[list.get(list.size()-1)] = false;
                }
                check[arr[i]] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
