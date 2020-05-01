package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정식이의은행업무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        loop: for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            String str = br.readLine();
            char[] binary = str.toCharArray();
            str = br.readLine();
            char[] ternary = str.toCharArray();
            //이진수를 앞에서 한자리씩 바꾸기
            for(int i = 0; i < binary.length; i++) {
                binary[i] = binary[i] == '0' ? '1' : '0';
                long bin = toDecimal(binary, 2);
                for(int j = ternary.length-1; j >= 0; j--) {
                    long ter = 0;
                    if(ternary[j] == '0') {
                        ternary[j] = '1';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '2';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '0';
                    }
                    else if(ternary[j] == '1') {
                        ternary[j] = '0';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '2';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '1';
                    }
                    else {
                        ternary[j] = '1';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '0';
                        ter = toDecimal(ternary, 3);
                        if(bin == ter) {
                            sb.append(ter).append("\n");
                            continue loop;
                        }
                        ternary[j] = '2';
                    }
                }
                binary[i] = binary[i] == '1' ? '0' : '1';
            }
        }
        System.out.println(sb);
    }
    static long toDecimal(char[] arr, int n) {
        long num = 0;
        for(int i = arr.length-1, j = 0; i >= 0; i--, j++) {
            num += (arr[i]-48) * Math.pow(n, j);
        }
        return num;
    }
}
