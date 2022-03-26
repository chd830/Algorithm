package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2564
public class 경비원 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int num = Integer.parseInt(br.readLine());
        Node[] shop = new Node[num];
        for(int i = 0; i < num; i++) {
            token = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(token.nextToken())) {
                case 1:
                    shop[i] = new Node(0, Integer.parseInt(token.nextToken()));
                    break;
                case 2:
                    shop[i] = new Node(N-1, Integer.parseInt(token.nextToken()));
                    break;
                case 3:
                    shop[i] = new Node(Integer.parseInt(token.nextToken()), 0);
                    break;
                case 4:
                    shop[i] = new Node(Integer.parseInt(token.nextToken()), N-1);
                    break;
            }
        }

        token = new StringTokenizer(br.readLine());
        Node start = null;
        switch (Integer.parseInt(token.nextToken())) {
            case 1:
                start = new Node(0, Integer.parseInt(token.nextToken()));
                break;
            case 2:
                start = new Node(N-1, Integer.parseInt(token.nextToken()));
                break;
            case 3:
                start = new Node(Integer.parseInt(token.nextToken()), 0);
                break;
            case 4:
                start = new Node(Integer.parseInt(token.nextToken()), N-1);
                break;
        }
        int sum = 0;
        for(Node n : shop) {
            if(n.x == 0) {
                if(start.x == 0)
                    sum += Math.abs(n.y-start.y);
                else if(start.y == 0)
                    sum += start.x+n.y;
                else if(start.x == N-1)
                    sum += Math.min(start.y+N+n.y, M-start.y+N+M-n.y);
                else
                    sum += start.x+M-n.y;
            }
            else if(n.y == 0) {
                if(start.x == 0)
                    sum += start.x+n.y;
                else if(start.y == 0)
                    sum += Math.abs(start.x-n.x);
                else if(start.x == N-1)
                    sum += start.y+N-n.x;
                else
                    sum += Math.min(start.x+M+n.x, N-start.x+M+N-n.y);
            }
            else if(n.x == N-1) {
                if(start.x == 0)
                    sum += Math.min(start.y+N+n.y, M-start.y+N+M-n.y);
                else if(start.y == 0)
                    sum += n.y+N-start.x;
                else if(start.x == N-1)
                    sum += Math.abs(n.y-start.y);
                else
                    sum += M-n.y+N-start.x;
            }
            else {
                if(start.x == 0)
                    sum += n.x+M-start.y;
                else if(start.y == 0)
                    sum += Math.min(start.x+M+n.x, N-start.x+M+N-n.x);
                else if(start.x == N-1)
                    sum += N-n.x+M-start.y;
                else
                    sum += Math.abs(n.x-start.x);
            }
        }
        System.out.println(sum);
    }
}
