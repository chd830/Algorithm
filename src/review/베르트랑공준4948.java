package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준4948 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            cnt = 0;
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                break;
            }
            checkDecimal(num);
        }
    }

    static void checkDecimal(int start) {
        for(int i = start; i <= start*2; i++) {

        }
    }
}
