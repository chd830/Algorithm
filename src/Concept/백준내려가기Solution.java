package Concept;

import java.util.Scanner;

public class 백준내려가기Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //map에서 항상 마지막 한 줄만 알면되므로, 한줄(3칸)만 기억
        int[] map = new int[3];
        int[][] max = new int[2][3];
        int[][] min = new int[2][3];
        //처음 한 줄 입력
        for(int j = 0; j < 3; j++) {
            map[j] = sc.nextInt();
        }
        //max와 min에도 첫줄을 입력
        for(int i = 0; i < 3; i++) {
            max[0][i] = map[i];
            min[0][i] = map[i];
        }
        //두번째줄 부터
        for(int i = 1; i < N; i++)	{
            //한줄입력받고
            map[0] = sc.nextInt();
            map[1] = sc.nextInt();
            map[2] = sc.nextInt();
            //max와 min의 각 자리에 최대 최소값을 찾아두자
            max[1][0] = Math.max(max[0][0], max[0][1]);
            max[1][2] = Math.max(max[0][1], max[0][2]);
            max[1][1] = Math.max(max[1][0], max[1][2]);

            min[1][0] = Math.min(min[0][0], min[0][1]);
            min[1][2] = Math.min(min[0][1], min[0][2]);
            min[1][1] = Math.min(min[1][0], min[1][2]);
            //자기 자리의 값을 포함시킨 후  위로 올린다.
            for(int j = 0; j < 3; j++) {
                max[1][j] += map[j];
                min[1][j] += map[j];
                max[0][j] = max[1][j];
                min[0][j] = min[1][j];
            }
        }
        int result_min = 987654321;
        int result_max = 0;
        for(int i = 0; i < 3; i++) {
            result_max = Math.max(max[0][i], result_max);
            result_min = Math.min(min[0][i], result_min);
        }
        System.out.println(result_max + " " + result_min);
    }
}