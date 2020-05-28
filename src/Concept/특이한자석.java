package Concept;

import java.util.LinkedList;
import java.util.Scanner;

public class 특이한자석 {
    static int K;
    static LinkedList<Integer>[] magnet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            K = sc.nextInt();
            magnet = new LinkedList[5];
            for(int i = 1; i <= 4; i++) {
                magnet[i] = new LinkedList<>();
                for(int j = 0; j < 8; j++) {
                    magnet[i].add(sc.nextInt());
                }
            }
            for(int k = 0; k < K; k++) {
                int mNum = sc.nextInt();
                boolean dir = sc.nextInt() == 1 ? true : false; //true시계방향. false반시계방향
                if(mNum > 1) {//왼쪽에 자석이 있음
                    action(mNum, 6, dir);
                }
                if(mNum > 1 && mNum < 4) {//중간에 끼어있음
                    rotate(mNum, !dir);
                }
                if(mNum < 4) {//오른쪽에 자석이 있음
                    action(mNum, 2, dir);
                }
            }
            int ans = 0;
            for(int i = 1; i <= 4; i++) {
                ans += (magnet[i].get(0) * (1<<(i-1)));
            }
            System.out.println("#"+t+" "+ans);
        }
    }
    static void action(int mNum, int idx, boolean dir) {
        int mNext = mNum + (idx == 2 ? +1 : -1);
        if(mNext > 0 && mNext < 5 && magnet[mNext].get(idx) != magnet[mNext].get((idx+4)%8)) {
            action(mNext, idx, !dir);
        }
        rotate(mNum, dir);
    }

    static void rotate(int mNum, boolean dir) {
        if(dir) {
            magnet[mNum].addFirst(magnet[mNum].removeLast());
        }
        else {
            magnet[mNum].addLast(magnet[mNum].removeFirst());
        }
    }
}
