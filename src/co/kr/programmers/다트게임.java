package co.kr.programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17682
public class 다트게임 {
    public static void main(String[] args) {
        // 37, 9, 3, 23
//        System.out.println(solution("1S2D*3T"));
//        System.out.println(solution("1D2S#10S"));
//        System.out.println(solution("1D2S00T"));
        System.out.println(solution("1S*2T*3S"));
    }
    public static int solution(String dartResult) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String prev= "";
        for(char c : dartResult.toCharArray()) {
            switch (c) {
                case 'S':
                    stack.push(prev);
                    prev = "";
                    break;
                case 'D':
                    stack.push(String.valueOf((int)Math.pow((Integer.parseInt(prev)), 2)));
                    prev = "";
                    break;
                case 'T':
                    stack.push(String.valueOf((int)Math.pow((Integer.parseInt(prev)), 3)));
                    prev = "";
                    break;
                case '*': case '#':
                    stack.push(c+"");
                    break;
                default:
                    prev += c;
            }
        }
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty())
            list.add(stack.pop());
        for(int i = list.size()-1; i >= 0; i--) {
            if(list.get(i).equals("*")) {
                answer += Integer.parseInt(list.get(i+1));
                list.add(i+1, ""+Integer.parseInt(list.get(i+1))*2);
                list.remove(i+2);
                int tmp = i+2;
                while(tmp < list.size() && (list.get(tmp).equals("#") || list.get(tmp).equals("*")))
                    tmp++;
                if(tmp != list.size()) {
                    answer += Integer.parseInt(list.get(tmp));
                    list.add(tmp, ""+Integer.parseInt(list.get(tmp))*2);
                    list.remove(tmp+1);
                }
            }
            else if(list.get(i).equals("#")) {
                list.add(i+1, ""+Integer.parseInt(list.get(i+1))*-1);
                list.remove(i+2);
                answer += Integer.parseInt(list.get(i+1))*2;
            }
            else
                answer += Integer.parseInt(list.get(i));
        }
        return answer;
    }
}
