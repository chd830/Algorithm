package com.swexpertacademy;

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Scanner;
        import java.util.Stack;

//단순 2진 암호코드
public class d3_1240 {
    public static void main(String[] args) {
        int[] num = {13, 25, 19, 61, 35, 49, 47, 59, 55, 11};
        int[] result = new int[8];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(13, 0);
        map.put(25, 1);
        map.put(19, 2);
        map.put(61, 3);
        map.put(35, 4);
        map.put(49, 5);
        map.put(47, 6);
        map.put(59, 7);
        map.put(55, 8);
        map.put(11, 9);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String[] pwd = new String[M];
//            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < N; i++) {
                pwd[i] = sc.next();
            }
            boolean check = false;
            for (int i = 0; i < N; i++) {
                for (int j = M - 1, idx = 0; j >= 0; ) {
                    if (pwd[i].charAt(j) != '1') {
                        j--;
                        continue;
                    }
                    j++;
                    String sub = pwd[i].substring(j - 7, j);
                    j -= 7;
                    int sum = 0;
                    for (int k = 6; k >= 0; k--) {
                        sum += (sub.charAt(k) - '0') * (int) Math.pow(2, sub.length() - k - 1);
                        check = true;
                    }
                    result[idx] = map.get(sum);
                    idx++;
//                    stack.push(map.get(sum));
                }
                if (check) {
                    break;
                }
            }
//            int even = 0;
//            int odd = 0;
//            int idx = 0;
//            while(!stack.isEmpty()) {
//                if(idx%2 == 0) {
//                    even += stack.pop();
//                }
//                else {
//                    odd += stack.pop();
//                }
//                idx++;
//            }
//            System.out.println("#"+t+" "+(((even*3)+odd)%10 == 0 ? even+odd : 0));
            System.out.println(Arrays.toString(result));
            int sum = (result[0] + result[2] + result[4] + result[6]) * 3 + result[1] + result[3] + result[5] + result[7];
            if (sum % 10 == 0) {
                int res = result[0] + result[1] + result[2] + result[3] + result[4] + result[5] + result[6] + result[7];
                System.out.println("#" + t + " " + res);
            }
            else {
                System.out.println("#" + t + " " + 0);
            }
        }
    }
}