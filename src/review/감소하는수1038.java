package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= 1023; i++) { // {0, 1, 2, 3, .. , 9}의 공집합이 아닌 부분집합을 뽑아내기 위해서.
            long num = 0; // i에 대응되는 감소하는 수
            int temp = i;
            for (int idx = 9; idx >= 0; idx--) {
                if (temp % 2 == 1)
                    num = 10 * num + idx; // idx를 1의 자리에 넣음
                temp /= 2;
            }
            list.add(num); // i에 대응되는 감소하는 수를 list에 넣음
        }
        Collections.sort(list);
        if(N > 1022) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(N));
        }
    }
}
