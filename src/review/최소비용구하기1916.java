package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다익스트라
public class 최소비용구하기1916 {
    static int[][] ad;
    static int[] dist;
    static boolean[] visit;
    static int M, N;
    static final int inf = 1000000;

    public static void graph(int start, int end){
        dist[start] = 0;    // 최초 시작 값 distance 초기화
//        String s = "";
        for(int j = 0; j < N; j++) // dist 값을 한번 초기화 했으므로 n-1번만 진행
        {
            int min = inf+1;    // dist 최소값 찾기 위한 임시 값 초기화
            int index = -1;
            for(int k = 1; k <= N; k++){
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            visit[index] = true;
//            s += index + " ";  // 경로를 체크하는 방법
            for(int l = 1; l <= N; l++){
                if(ad[index][l] != 0 && dist[l] > dist[index] + ad[index][l]){ //인접 행렬을 검사하여 최적의 값을 찾아
                    dist[l] = dist[index] + ad[index][l];
                }

            }
        }
        int min = 0;
        for(int i = 1; i <= N; i++){
            min = Math.max(min, dist[i]);
        }
        System.out.println(min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ad = new int[N +1][N +1];
        dist = new int[N +1];
        visit = new boolean[N +1];

        for(int i = 1; i <= N; i++){
            dist[i] = inf;   //임의의 무한한 값으로 거리값 초기화
        }

        StringTokenizer token = null;
        for(int i = 0; i < M; i++){
            token = new StringTokenizer(br.readLine());
            ad[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())] = Integer.parseInt(token.nextToken());
        }
        graph(1,5);
    }
}
