package co.kr.programmers;

import java.util.*;
import java.io.*;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < signs.length; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }
        return answer;
    }

}
