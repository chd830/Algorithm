package programmers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = null;
        int num = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            token = new StringTokenizer(br.readLine());
            int[] arr = new int[2];
            arr[0] = Integer.parseInt(token.nextToken());
            arr[1] = Integer.parseInt(token.nextToken());
            list.add(arr);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return Integer.compare(o1[0], o2[0]);
                else
                    return Integer.compare(o1[1], o2[1]);
            }
        });
        for(int[] a : list) {
            System.out.println(a[0] +" " + a[1]);
        }
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
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            System.out.println(Character.isDigit(c)+", "+Character.isAlphabetic(c));
            if(Character.isAlphabetic(c))
                return false;
        }
        return true;
    }
}