package Concept;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {58, 8, 28, 3, 18, 6, 33, 20};
        sort(arr, 0, arr.length-1);
    }
    //분할
    static void sort(int[] arr, int m, int n) {
        if(m < n) {
            int mid = (m+n / 2);
            sort(arr, m, mid-1);
            sort(arr, mid+1, n);
            merge(arr, m, mid, n);
        }
    }
    //병합
    static void merge(int[] arr, int m, int mid, int n) {
        //정렬된 배열 arr[m to mid], arr[mid to n]을 합병
        int[] result = new int[arr.length];
        int left = m;
        int right = mid+1;
        int i = 0;
        while(left <= mid && right <= n) {
            if(arr[left] < arr[right]) {
                result[i++] = arr[left++];
            }
            else {
                result[i++] = arr[right++];
            }
        }
        while(left <= mid) {
            result[i++] = arr[left++];
        }
        while(right <= n) {
            result[i++] = arr[right++];
        }
        for(left = m; left <= n; left++) {
            arr[left] = result[left];
        }
    }
}
