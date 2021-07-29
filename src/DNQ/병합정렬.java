package DNQ;

import java.util.Arrays;

public class 병합정렬 {
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[arr.length];
        int i = start;
        int j = mid+1;
        int temp = start;

        while(i <= mid && j <= end) {
            if(arr[i] < arr[j])
                tmp[temp++] = arr[i++];
            else
                tmp[temp++] = arr[j++];
        }
        while(i <= mid)
            tmp[temp++] = arr[i++];
        while(j <= end)
            tmp[temp++] = arr[j++];

        for(int idx = start; idx < temp; idx++)
            arr[idx] = tmp[idx];
    }
    public static void mergeSort(int[] arr, int start, int end) {
        if(start == end)
            return;
        int mid = (start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
