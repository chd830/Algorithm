package Concept;

public class QuickSort {
    static int[] arr = {3, 5, 1, 6, 2, 23, 61};
    public static void main(String[] args) {
    }
    static void quickSort(int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = partition(left, right);
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }
    static int partition(int left, int right) {
        //오른쪽 끝이 비교 기준
        int pivot = arr[right];
        //맨 왼쪽이 바뀌는 기준
        int i = left;
        //왼쪽부터 시작한 값이 기준점보다 작으면 매개변수로 받은 바뀌는 기준과 바꾼다.
        for(int j = left; j < right; j++) {
            if(arr[j] < pivot) {
                swap(i, j);
                i++;
            }
        }
        swap(right, i);
        return i;
    }
    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
