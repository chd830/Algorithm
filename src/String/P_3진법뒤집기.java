package String;

// https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class P_3진법뒤집기 {
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
    public static StringBuilder intToTernary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%3);
            n /= 3;
        }
        return sb;
    }

    public static int ternaryToInt(String str) {
        int result = 0;
        for(int i = str.length()-1; i >= 0; i--) {
            result += (str.charAt(i)-'0')*Math.pow(3, str.length()-1-i);
        }
        return result;
    }
    public static int solution(int n) {
        StringBuilder sb = intToTernary(n);
        return ternaryToInt(sb.toString());
    }
}
