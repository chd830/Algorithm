package Dynamic;

// https://school.programmers.co.kr/learn/courses/30/lessons/12900
public class P_2xn타일링 {
    public static void main(String[] args) {
        System.out.println(solution(4));

    }
    public static int solution(int n) {
        int[] d = new int[60001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 3;
        for(int i = 4; i <= n; i++)
            d[i] = (d[i-1]%1000000007+d[i-2]%1000000007)%1000000007;
        return d[n];
    }
}
