package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1253
public class 좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            if(map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }
        Arrays.sort(arr);
        // 다른 두 수의 합으로 나타낼 수 있는 수의 개수
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                sum = arr[i]+arr[j];
                int tmp = 0;
                if(map.containsKey(sum)) {
                    tmp = map.get(sum);
                    if(arr[i] == 0 && arr[j] == 0) {
                        // 0이 세개 이상있을 때 0의 수가 세개 이상이어야 함
                        if(tmp >= 3) {
                            cnt += tmp;
                            map.remove(sum);
                        }
                    }
                    else if(arr[i] == 0 || arr[j] == 0) {
                        // 0이 하나라도 있을 때 0의 수가 두개 이상이어야 함
                        if(tmp >= 2) {
                            cnt += tmp;
                            map.remove(sum);
                        }
                    }
                    else {
                        cnt += tmp;
                        map.remove(sum);
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}