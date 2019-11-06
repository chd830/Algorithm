package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingByABridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList();

        for(int t : truck_weights) {
            truck.add(t);
        }
        //트럭이 있는 큐와 다리위의 트럭큐 두개를 이용한다.
        //다리위의 트럭의 무게가 weight보다 작으면 추가되는지를 확인해서 추가한다.

        bridge.add(truck_weights[0]);
        int total = 0;
        while(!bridge.isEmpty()) {
            total = bridge.peek();
            if(total < weight && total + truck.peek() < weight) {
                
            }
        }

        return time;
    }
}
