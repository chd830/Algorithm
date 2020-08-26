package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakao01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length(), ans = len;
        //str을 k부터 len/2개까지 쪼개서 압축된 글자의 수를 확인한다.
        for (int i = 1; i <= len / 2; i++) {
            int cnt = 0;
            int n = 0;
            //비교대상 n
            while (n < len) {
                int same = 0;
                int next = 0;
                if (n + i > len) {
                    cnt += len - n;
                    break;
                }
                //샘플 j
                for (int j = n + i; j < len; j += i) {
                    //비교시작
                    int t = 0;
                    //n부터 t 까지의 값과 j부터 t 까지의 값이 같다면
                    for (t = 0; t < i; t++) {
                        //다른게 하나라도 있으면 0으로
                        if (str.charAt(n + t) != str.charAt(j + t)) {
                            break;
                        }
                    }
                    //압축된 글자의 수와 비교하는 글자의 길이가 같을 때 same을 증가시킨다.
                    if (t == i) {
                        same++;
                    }
                    //압축된 글자와 비교하는 글자수가 다르면 루프를 끝낸다.
                    else {
                        next = j;
                        break;
                    }
                }
                //압축환 횟수를 나타낼 때 10 이상 이면 2자리 100 이상 이면 3자리가 된다.
                if (same == 1) {
                    if (same + 1 <= 9) {
                        cnt += i + 1;
                    } else if (same + 1 <= 99) {
                        cnt += i + 2;
                    } else if (same + 1 <= 999) {
                        cnt += i + 3;
                    } else {
                        cnt += i + 4;
                    }
                } else {
                    cnt += i;
                }
                if (next == 0) {
                    break;
                }
                n = next;
            }
            //ans에 k의 cnt중 제일 작은 값을 넣는다.
            if (cnt < ans) {
                ans = cnt;
            }
        }
        System.out.println(ans);
    }
}
