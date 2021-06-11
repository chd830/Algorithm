package co.kr.programmers;

import java.util.ArrayList;
import java.util.List;

public class 조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); //56
        System.out.println(solution("JAN")); //23
        System.out.println(solution("ABAAAAAAAAABB")); //7
        System.out.println(solution("AZAAZ")); //5
    }
    public static int solution(String name) {
        int res = 0;
        int len = name.length();
        int min = len-1;

        for(int i =0 ; i < len; i++) {
            // 위아래로 이동하는 최솟값
            res += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            // A가 연속으로 나오는 지점을 벗어난 위치 구하기
            int next = i+1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            // i+len-next: 뒤에서 부터 접근하는 A가 연속으로 나오는 지점의 다음위치의 이동횟수
            min = Math.min(min, i+len-next+i);
        }
        res += min;
        return res;
    }
}
