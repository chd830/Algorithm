package Dynamic;

import java.util.*;
import java.io.*;

// https://velog.io/@hyeon930/BOJ-2143-%EB%91%90-%EB%B0%B0%EC%97%B4%EC%9D%98-%ED%95%A9-Java
// https://www.acmicpc.net/problem/2143
public class 두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        alist = new ArrayList<>();
        blist = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        // 누적합과 가능한 모든 부분합을 저장
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            B[i] = Integer.parseInt(token.nextToken());
        for(int i = 0; i < N; i++) {
            long sum = 0;
            for(int j = i; j < N; j++) {
                sum += A[j];
                alist.add(sum);
            }
        }
        for(int i = 0; i < M; i++) {
            long sum = 0;
            for(int j = i; j < M; j++) {
                sum += B[j];
                blist.add(sum);
            }
        }
        Collections.sort(alist);
        Collections.sort(blist);
        // answer type이 int면 72%에서 error
        long answer = 0;
        for(int i = 0; i < alist.size(); i++) {
            long target = T-alist.get(i);
            // upperbound(start, end, target): target 값보다 큰 값이 처음으로 나오는 위치
            // lowerbound(start, end, target): target 값 이상인 값이 맨 처음 나오는 위치
            answer += upper(0, blist.size(), target)-lower(0, blist.size(), target);
        }
        System.out.println(answer);
    }
    static List<Long> alist;
    static List<Long> blist;
    // lower bound는 찾고자 하는 값 이상이 처음 나타나는 위치
    private static int lower(int left, int right, long target) {
        while (left < right) {
            int mid = (left + right)/2;
            if (blist.get(mid) < target)
                left = mid+1;
            else
                right = mid;
        }
        return right;
    }

    // upper bound는 찾고자 하는 값보다 큰 값이 처음으로 나타나는 위치
    private static int upper(int left, int right, long target) {
        while (left < right) {
            int mid = (left + right)/2;
            if (blist.get(mid) <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}
