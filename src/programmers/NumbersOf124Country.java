package programmers;

public class NumbersOf124Country {
    public String solution(int n) {
        //3진법을 이용해서 0대신에 4가 들어갈 수 있게 바꾸기
        String answer = "";
        int rmd;

        while (n > 0) {
            rmd = n % 3;
            n = n / 3;

            if (rmd == 0) {
                //3으로 나눠떨어지면 주어진수에서 1을 뺀 후에 진행해야됨.
                n -= 1;
                rmd = 4;
            }
            System.out.println(rmd + ", " + answer+", total: "+(rmd + answer));
            answer = rmd + answer;
        }

        return answer;
    }
}