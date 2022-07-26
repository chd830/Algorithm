package 구현;

// https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class 약수의개수와덧셈 {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
        System.out.println(solution(1, 2));
    }
    static int getMeasure(int n) {
        boolean[] check = new boolean[n+1];
        int cnt = 0;
        for(int i = 1; i <= n/2; i++) {
            if(n%i == 0) {
                if(check[i])
                    continue;
                if(n/i == i) {
                    check[n/i] = true;
//                    System.out.print(i+"\t");
                    cnt++;
                }
                else {
                    check[n/i] = true;
                    check[i] = true;
//                    System.out.print(i+"\t"+(n/i)+"\t");
                    cnt += 2;
                }
            }
        }
        return n == 1 ? 1 : cnt;
    }
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
//            System.out.println(i);
            if(getMeasure(i)%2 == 0) {
//                System.out.println("ODD");
                answer += i;
            }
            else {
//                System.out.println("EVEN");
                answer -= i;
            }
        }
        return answer;
    }
}
