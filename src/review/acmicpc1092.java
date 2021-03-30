package review;

import java.util.*;
import java.io.*;

// 배
public class acmicpc1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = Integer.parseInt(br.readLine());
        List<Integer> weight = new ArrayList<>();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            weight.add(Integer.parseInt(token.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(weight);
        Collections.sort(boxes);

//        for(int b : boxes) {
//            System.out.print(b+"\t");
//        }
//        System.out.println();

        if(weight.get(N-1) < boxes.get(M-1)) {
            System.out.println(-1);
            System.exit(0);
        }
        int cnt = 0;
        while(boxes.size() != 0) {
            int idx = N-1;
            for(int i = boxes.size()-1; i >= 0; i--) {
                if(idx == -1)
                    break;
                if(weight.get(idx) >= boxes.get(i)) {
                    idx--;
                    boxes.remove(i);
                }
            }
//            for(int b : boxes) {
//                System.out.print(b+"\t");
//            }
//            System.out.println();
            cnt++;
        }
        System.out.println(cnt);
    }
}
/*
3
6 8 9
9
1 2 3 4 5 6 7 8 9
 */
