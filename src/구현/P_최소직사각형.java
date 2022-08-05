package 구현;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class P_최소직사각형 {
    public static void main(String[] args) {

    }
    public static int solution(int[][] sizes) {
        for(int[] size : sizes) {
            if(size[0] > size[1]) {
                int tmp = size[1];
                size[1] = size[0];
                size[0] = tmp;
            }
        }
        int width = 0;
        int height = 0;
        for(int i = 0; i < sizes.length; i++) {
            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);
        }
        return width*height;
    }
}
