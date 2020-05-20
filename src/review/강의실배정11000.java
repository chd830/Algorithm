package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = null;
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(arr, comparator);
        que.add(arr[0][1]);
        for(int i = 1; i < N; i++) {
            if(que.peek() <= arr[i][0]) {
                que.poll();
            }
            que.add(arr[i][1]);
        }
        System.out.println(que.size());
    }
}
