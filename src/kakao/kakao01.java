package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class kakao01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        int ans = size;
        int t;
        int check;
        int total;
        ArrayList<Integer> list = new ArrayList();
        // len/2만큼만 쪼개서 진행한다.
        for (int i = 1; i <= size / 2; i++) {

            list.clear();
            t = size / i;
            check = 1;
            total = 0;
            //i개의 단위로 쪼갰을 때 반복되는 값이 얼마나 나오는지 체크해서 list에 더한다.
            for (int j = 0; j < t - 1; j++) {
//                System.out.println("("+(i*j)+", "+(i*(j+1))+") ("+(i*(j+1))+", "+(i*(j+2))+")"+"\t\t"+check);
                if (str.substring(i * j, i * (j + 1)).equals(str.substring(i * (j + 1), i * (j + 2)))) {
                    check++;
                } else {
                    list.add(check);
                    check = 1;
                }
            }
            list.add(check);
//            System.out.print(i+" "+list.toString());
            //리스트에 있는 값에서 10보다 크면 1씩더하고 100보다 크면 2씩더해주면서 total값을 구한다.
            for (int k : list) {
                if (k == 1) {
                    total += i;
                } else {
                    int ksize = Integer.toString(k).length();
                    total += ksize + i;

                }
            }
            total += size - i * t;
//            System.out.println("\t"+total);
            //ans와 total을 비교해서 더 작은 값을 출력한다.
            ans = Math.min(ans, total);
        }
        System.out.println(ans);
    }
}
