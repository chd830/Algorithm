package review;

import java.io.*;
import java.util.StringTokenizer;

public class 숫자야구 {
    static boolean[] visited = new boolean[9];
    static String[] numArray = new String[504];
    static int[] sub = new int[3];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = 0;
        int strike = 0;
        int ball = 0;

        //111부터 999까지 담겨있는 배열을 만든다.
        perm(0);
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            strike = Integer.parseInt(token.nextToken());
            ball = Integer.parseInt(token.nextToken());
            //리스트를 처음부터 끝까지 가면서 해당하지 않은 답은 삭제한다.
            check(String.valueOf(N), strike, ball);
        }
        //남은 리스트의 수 출력
        System.out.println(countArrays());
    }

    public static int countArrays() {
        int cnt = 0;
        for(int i = 0; i < numArray.length; i++) {
            if(!numArray[i].equals("") || numArray[i] != "") {
                cnt++;
            }
        }
        return cnt;
    }
    public static boolean checkStrike(String nums, String N, int strike) {
        int num = 0;
        for(int i = 0; i < nums.length(); i++) {
            if(N.charAt(i) == nums.charAt(i)) {
                num++;
            }
        }
        return num == strike;
    }
    public static boolean checkBall(String nums, String N, int ball) {
        int num = 0;
        for(int i = 0; i < nums.length(); i++) {
            for(int j = 0; j < N.length(); j++) {
                if(i == j) {
                    continue;
                }
                if(N.charAt(i) == nums.charAt(j)) {
                    num++;
                }
            }
        }
        return num == ball;
    }

    public static void check(String N, int strike, int ball) {
        for(int i = 0; i < numArray.length; i++) {
            if(checkStrike(numArray[i], N, strike) && checkBall(numArray[i], N, ball)) {
                continue;
            }
            else {
                numArray[i] = "";
            }
        }
    }

    public static void perm(int idx) {
        if(idx == sub.length) {
            String num = "";
            for(int i = 0; i < sub.length; i++) {
                num += sub[i];
            }
            numArray[cnt++] = num;
            return;
        }
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                sub[idx] = i+1;
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
