package programmers;

public class NumbersOf124Country {
    public String solution(int n) {
        //3진법을 이용해서 0대신에 4가 들어갈 수 있게 바꾸기
        String[] num = {"1","2","4"};
        String answer = "";
        for(int i = 0, j = 0; j <= n; i++, j++) {
            if(i > 2) {
                i -= 2;
            }
            answer += num[i];
        }
        return answer;
    }
}
