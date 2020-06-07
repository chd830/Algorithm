package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수1780 {
    static int N;
    static int[][] map;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        cut(N, 0, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
    public static boolean equal(int size, int x, int y){
        //시작하는 위치의 값을 가져오고
        int target = map[x][y];
        for(int i = x; i < x+size ; i++){
            for(int j = y; j < y+size ; j++){
                //시작하는 위치와 같은 값이 아니라면 false반환
                if(target !=  map[i][j]){
                    return false;
                }
            }
        }

        result[target+1]++;
        return true;
    }

    //size/3만큼 반복하면서 0/1/-1로 채워져있는지를 확인한다.
    public static void cut(int size, int x, int y){
        if(equal(size, x, y))
            return;

        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                //N/3으로 (0,0)부터 (N-1, N-1)까지 확인하고 N/3을 /3한다.
                cut(size / 3, x + j * (size / 3), y + i * (size / 3));
            }
        }
    }
}
