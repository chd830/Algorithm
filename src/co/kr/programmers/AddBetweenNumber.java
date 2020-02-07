package co.kr.programmers;

public class AddBetweenNumber {
    public long solution(int a, int b) {
        long answer = 0;
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println("a: "+a+", b: "+b);
        for(; a <= b; a++) {
            answer += a;
        }
        return answer;
    }
}
