package net.acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정 {
    static int[][] arr;
    static int max;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            max = Math.max(arr[i][1], max);
        }
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(arr, comp);
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i][0]+" "+arr[i][1]);
//        }
//        System.out.println();
        int cnt = 1;
        int[] cur = new int[] {arr[0][0], arr[0][1]};
        for(int i = 1; i < N; i++) {
            if(cur[1] <= arr[i][0]) {
                cur[0] = arr[i][0];
                cur[1] = arr[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
//        Comparator<int[]> comp = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] < o2[0]) {
//                    return o1[0] - o2[0];
//                }
//                else if(o1[0] == o2[0]) {
//                    if (o1[1] - o1[0] < o2[1] - o2[0]) {
//                        return (o1[1] - o1[0]) - (o2[1] - o2[0]);
//                    } else if (o1[1] - o1[0] == o2[1] - o2[0]) {
//                        return o1[0] - o2[0];
//                    }
//                }
//                return 0;
//            }
//        };
//        Arrays.sort(arr, comp);
////        powerset(0);
//        System.out.println(result);
//        //모든 부분집합을 구해서 그 부분집합이 차지하는 크기.
//    }
//    static int cnt = 0;
//    static void powerset(int idx) {
//        if(idx == visited.length) {
//            boolean[] maxV = new boolean[max+1];
//            boolean check = false;
//            for(int i = 0; i < visited.length; i++) {
//                if(visited[i]) {
////                    System.out.print(arr[i][0] + " " + arr[i][1] + ". ");
//                    for(int j = arr[i][0]; j <= arr[i][1]; j++) {
//                        if(maxV[j]) {
//                            check = false;
//                            break;
//                        }
//                        check = true;
//                        maxV[j] = true;
//                    }
//                    if(check) {
//                        cnt++;
//                    }
//                }
//            }
//            if(cnt != 0 && result < cnt) {
//                result = cnt;
//            }
//            cnt = 0;
//            Arrays.fill(maxV, false);
//            return;
//        }
//        visited[idx] = true;
//        powerset(idx+1);
//        visited[idx] = false;
//        powerset(idx+1);
//    }
//}
//        int[] maxArray = new int[max+1];
//        for(int i = 0; i  < W; i++) {
//            for(int j = arr[i][0]; j <= arr[i][1]; j++) {
//                maxArray[j]++;
//            }
//        }
//        System.out.println(Arrays.toString(maxArray));

//        boolean[] check = new boolean[max+1];
//        Comparator<int[]> comp = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] < o2[0]) {
//                    return o1[0] - o2[0];
//                }
//                else if(o1[0] == o2[0]) {
//                    if (o1[1] - o1[0] < o2[1] - o2[0]) {
//                        return (o1[1] - o1[0]) - (o2[1] - o2[0]);
//                    } else if (o1[1] - o1[0] == o2[1] - o2[0]) {
//                        return o1[0] - o2[0];
//                    }
//                }
//                return 0;
//            }
//        };
//        Arrays.sort(arr, comp);
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i][0]+" "+arr[i][1]);
//        }
//        System.out.println();
//
//        int cnt = 0;
//        boolean b = false;
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = arr[i][0]; j <= arr[i][1]; j++) {
//                if(!check[j]) {
//                    b = true;
//                    check[j] = true;
//                }
//                else {
//                    break;
//                }
//            }
//            if(b)
//                cnt++;
//            b = false;
//            System.out.println(Arrays.toString(check));
//        }
//        System.out.println(cnt);
//    }
//}
