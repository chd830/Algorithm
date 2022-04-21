package Concept;

import java.util.*;

// 최장 증가 부분 수열
public class LIS {
    static final int SIZE = 6;
    static int[] arr = {10, 20, 10, 30, 50, 20};
    static int[] d = new int[SIZE];
    public static void main(String[] args) {
        // 원소를 저장하는 위치
        int LIS = 0;
        for(int i = 0; i < SIZE; i++) {
            // 삽입될 위치 탐색
            int idx = binarySearch(arr[i], 0, LIS, LIS+1);
            if(idx == -1)
                d[LIS++] = arr[i];
            else
                d[idx] = arr[i];
        }
        System.out.println(Arrays.toString(d));
        System.out.println(LIS);
    }

    static int binarySearch(int num, int start, int end, int size) {
        int result = 0;
        // 삽입될 위치 탐색
        while(start <= end) {
            int mid = (start+end)/2;
            if(num <= d[mid]) {
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        // 삽입될 위치가 없음. 모든 수 보다 큼
        if(start == size)
            return-1;
        return result;
    }
    static void dynamic() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] <= arr[i])
                    d[i] = Math.max(d[i], d[j]+1);
            }
        }
        System.out.println(Arrays.toString(d));
    }
}
