package co.kr.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Truck {
    int time;
    int distance;

    public Truck(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }
}

public class TruckPassingByABridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //시간과 남은 견딜 수 있는 무게를 선언.
        int time = 0;
        int weightLeft = weight;

        Truck truck = null;

        //대기중인 트럭
        Queue<Truck> outside = new LinkedList();
        //다리 위 트럭
        List<Truck> inside = new ArrayList<Truck>();

        for (int t : truck_weights) {
            outside.add(new Truck(t, bridge_length));
        }

        while (!inside.isEmpty() && outside.isEmpty()) {
            time++;

            //다리 위 트럭이 distance이상 지나갔으면 inside리스트에서 제거하고 무게를 증가시킨다.
            if (!inside.isEmpty() && inside.get(0).time <= 0) {
                weightLeft += inside.get(0).distance;
                inside.remove(0);
            }

            //남은 무게보다 가벼운 트럭이 있으면 inside로 넣어준다.
            if (!outside.isEmpty() && weightLeft - outside.peek().distance >= 0) {
                weightLeft -= outside.peek().distance;
                inside.add(outside.poll());
            }

            //다리 위 트럭의 distance를 1씩 감소시킨다.
            for (int i = 0; i < inside.size(); i++) {
                truck = inside.get(i);
                truck.time--;
            }
        }
        //다리위 트럭, 대기중 트럭 모두 비어있을 때 while문을 탈출해서 return
        return time;
    }
}
