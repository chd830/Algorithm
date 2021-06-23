package co.kr.programmers;

import java.util.*;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[] {10}));
        System.out.println(solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int result = 1;
        Queue<Integer> que = new LinkedList<>();
        int max = 0;
        for(int truck : truck_weights) {
            while(true) {
                // 다리에 트럭이 없을 때 트럭 추가
                if(que.isEmpty()) {
                    que.add(truck);
                    max += truck;
                    break;
                }
                // 다리길이만큼의 시간이 지났을 때 맨처음에 들어간 트럭을 제거
                else if(que.size() == bridge_length)
                    max -= que.poll();
                else {
                    // 새로운 트럭이 다리의 하중을 넘으면 의미없는 값인 0을 넣고 아닐 땐 트럭을 추가
                    result++;
                    if(max+truck > weight) {
                        que.add(0);
                    }
                    else {
                        que.add(truck);
                        max += truck;
                        break;
                    }
                }

            }
        }
        // 지나가는데 걸린시간 + 다리의 길이
        return result + bridge_length;
    }
}
