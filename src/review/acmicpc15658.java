package review;

import java.util.*;
import java.io.*;

// 연산자 끼워넣기(2)
public class acmicpc15658 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            nums = new int[N];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(token.nextToken());
            }
            opers = new int[4];
            token = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) {
                opers[i] = Integer.parseInt(token.nextToken());
            }
            calc(0,  "");
            System.out.println(max+"\n"+min);
        }
        static int N;
        static int max = Integer.MIN_VALUE;
        static int min = Integer.MAX_VALUE;
        static int[] nums;
        static int[] opers;
        static void calc(int cnt, String oper) {
            if(cnt == N-1) {
                int sum = nums[0];
//            System.out.print(oper+"\t");
                for(int i = 0; i < oper.length(); i++) {
                    char c = oper.charAt(i);
                    switch (c) {
                        case '+':
                            sum += nums[i+1];
                            break;
                        case '-':
                            sum -= nums[i+1];
                            break;
                        case '*':
                            sum *= nums[i+1];
                            break;
                        case '/':
                            sum /= Math.abs(nums[i+1]);
                            break;
                    }
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
//            System.out.println(max+"\t"+min);
                return;
            }
            for(int i = 0; i < opers.length; i++) {
                if(opers[i] > 0) {
                    opers[i]--;
                    String o = "";
                    switch (i) {
                        case 0:
                            o = "+";
                            break;
                        case 1:
                            o = "-";
                            break;
                        case 2:
                            o = "*";
                            break;
                        case 3:
                            o = "/";
                            break;
                    }
                    calc(cnt+1, oper+o);
                    opers[i]++;
                }
            }
        }
    }