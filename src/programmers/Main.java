package programmers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 리더 생성
        int n = Integer.parseInt(br.readLine());
        // 사이즈 입력
        int[] arr = new int[n];
        // 배열 생성
        int[] ans = new int[n];
        // 정답 배열 생성
        String[] temp = br.readLine().split(" ");
        // 임시로 받고
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
            // int로 변환
        }
        Stack<Integer> stack = new Stack<>();
        // 스택 생성
        stack.push(0);
        // 첫번째 인덱스 저장
        for (int index = 1; index < n; index++) {
            if (stack.isEmpty()) {
                stack.push(index);
                // 반복문에 들어올 때 스택이 비어있으면 인덱스 저장
            }
            while (!stack.isEmpty() && arr[stack.peek()] < arr[index]) {
                // 비어있지 않고 숫자가 인덱스 가장 위쪽 숫자보다 크면
                ans[stack.pop()] = arr[index];
                // 정답 배열 중 스택의 가장 위쪽 숫자와 같은 인덱스에 i번째 숫자를 넣는다
            }
            stack.push(index);
            // 다음번에 비교할 숫자를 stack에 집어넣는다
        }

        while (!stack.empty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
            ans[stack.pop()] = -1;
            // stack에 쌓인 index에 -1을 넣고
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
            // 출력한다
        }
        bw.write("\n");
        bw.flush();
    }

    /* static int manny(int[] arr) { // 최빈값을 구하는 메소드
         int cnt[] = new int [8001]; // 절대값 4000까지의 정수를 저장해야하므로 총 8000개를 만들었는데, 런타임 에러가 나서 +1 해줬다.
         ArrayList<Integer> arrayList = new ArrayList<Integer>();
         int max = Integer.MIN_VALUE; // 최빈값을 찾기위한 비교변수
         for(int x:arr) {

             if(x<0) { // 음수의 경우 4000을 더해서 해당 인덱스를 증가
                 cnt[Math.abs(x)+4000]++;
             }else cnt[x]++; // 나머지는 인덱스만 증가

         }

         int idx =0;
         for(int i=0;i<cnt.length;i++) {
             if(cnt[i]!=0 && cnt[i]>max) {	//카운트 배열에서 최빈값을 찾는다.
                 max = cnt[i];
                 idx = i;
             }
         }

         for(int i=0;i<cnt.length;i++) {
             int x=i;
             if(cnt[i]==max) { // 카운트 배열의 값들과 최빈값과 일치하면,
                 if(i>4000) { // 4000이상은 음수를 바꿔준것이므로 다시 원래의 숫자로 바꿔준다
                     x-=4000;
                     x*=-1;
                     arrayList.add(x); // 어레이 리스트에 추가
                 }else
                     arrayList.add(i); // 나머지는 그냥 i값을 추가
             }
         }
         Collections.sort(arrayList); // 추가 된 최빈값들이 다수 존재하면 오름차순 정렬

         if(arrayList.size()>1) return arrayList.get(1); // 최빈값이 여러개 존재한다면, 가장 작은 숫자에서 두 번째 숫자를 반환
         else return 	arrayList.get(0); // 그외에는 그냥 최빈값을 반환
     }*/
    public static boolean solution(String s) {
        System.out.println(s.length());
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            System.out.println(Character.isDigit(c) + ", " + Character.isAlphabetic(c));
            if (Character.isAlphabetic(c))
                return false;
        }
        return true;
    }
}