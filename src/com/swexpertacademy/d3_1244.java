package com.swexpertacademy;

import java.util.Scanner;

//최대상금
public class d3_1244 {
    //    static char[] input;
//    static int change;
//    static int ans;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//        for(int tc = 1; tc <= T; tc++) {
//            input = sc.next().toCharArray();
//            change = sc.nextInt();
//            ans = 0;
//
//            dfs(0, 0);
//
//            System.out.println("#"+tc+" "+ans);
//        }
//    }
//
//    private static void dfs(int idx, int cnt) {
//        System.out.println(cnt+" : "+Arrays.toString(input));
//        if(cnt == change) {
//            //System.out.println(Arrays.toString(input));
//
//            int num = 0;
//            for(int i = 0; i < input.length; i++) {
//                num = (num*10)+input[i]-'0';
//            }
//            if(num > ans) {
//                ans = num;
//            }
//
//            return;
//        }
//
//        for(int i = idx; i < input.length; i++) {
//            for(int j = i+1; j < input.length; j++) {
//
//                swap(i,j);
//                dfs(i, cnt+1); // dfs(i+1, cnt+1) 안됨
//                swap(i,j);
//            }
//        }
//    }
//
//    static void swap(int idx1, int idx2) {
//        char tmp = input[idx1];
//        input[idx1] = input[idx2];
//        input[idx2] = tmp;
//    }
//}
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            String str = sc.next();
            int num = sc.nextInt();
            array = new int[str.length()];
            array = makeArray(str);
            int max = Integer.parseInt(str);
            String maxStr = "";
            for(int i = 0; i < num; i++) {
                max = 0;
                maxStr = "";
//88832의 경우는 제일 큰수가 두개 이상이므로
//최솟값과 바꼈을 때 최댓값을 보장해주는 코드가 추가되어야함.
//내가 바꿨던 두 놈의 코드를 바꿔주기
                for(int j = 0; j < str.length()-1; j++) {
                    for(int k = j+1; k < str.length(); k++) {
                        swap(j, k, array);
                        str = toNumber(array);
                        if(max <= Integer.parseInt(str)) {
                            max = Integer.parseInt(str);
                            maxStr = str;
                        }
//                        System.out.print(str+" ");
                        swap(k, j, array);
                    }
//                    System.out.println("\t\tmax: "+maxStr);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }

    public static void recur() {

    }

    public static int[] makeArray(String str) {
        for(int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i) - '0';
        }
        return array;
    }
    public static void swap(int j, int k, int[] array) {
        int temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }
    public static String toNumber(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a);
        }
        return sb.toString();
    }
}
