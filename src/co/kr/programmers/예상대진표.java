package co.kr.programmers;

public class 예상대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
        System.out.println(solution(8, 2, 3));
        System.out.println(solution(8, 1, 2));
    }
    public static int solution(int n, int a, int b) {
        int res = 0;
        while(a != b) {
            // 4/2 == 2 5/2 == 2이고
            // 4+1/2 == 2 5+1/2 == 3이므로
            // 주어진 값+1/2가 다음라운드의 값이 된다.
            // 같은 라운드의 값을 가질 때까지 진행
            a = (a+1)/2;
            b = (b+1)/2;
            res++;
        }
        return res;
    }
}
