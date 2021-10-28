package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2621
public class 카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        char[] alph = new char[5];
        int[] nums = new int[5];
        for(int i = 0; i < 5; i++) {
            token = new StringTokenizer(br.readLine());
            alph[i] = token.nextToken().charAt(0);
            nums[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(alph);
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }

        // 1. 5개가 모두 같은 색이고 숫자가 연속: 높은숫자+900
        if (alph[0] == alph[4] && map.size() == 5 && nums[4] - nums[0] == 4)
            System.out.println(nums[4] + 900);
            // 5. 5장의 연속적인 숫자: 가장높은숫자+500
        else if (map.size() == 5 && nums[4]-nums[0] == 4)
            System.out.println(nums[4] + 500);
            // 4. 5장의 같은 색: 높은숫자+600
        else if (alph[0] == alph[4])
            System.out.println(nums[4] + 600);
            // 2. 4개가 같은 숫자: 같은숫자+800
        else if (nums[0] == nums[3] || nums[1] == nums[4])
            System.out.println(nums[2] + 800);
            // 3. 3장의 같은 숫자, 2장의 같은 숫자: 3장의 같은숫자+10+2장의같은숫자+700
        else if (nums[0] == nums[2] && nums[3] == nums[4])
            System.out.println(nums[0] * 10 + nums[3] + 700);
        else if (nums[0] == nums[1] && nums[2] == nums[4])
            System.out.println(nums[2] * 10 + nums[0] + 700);
            // 6. 3장의 같은 숫자: 같은 숫자+400
        else if (nums[0] == nums[2] || nums[1] == nums[3])
            System.out.println(nums[1] + 400);
        else if (nums[2] == nums[4])
            System.out.println(nums[2] + 400);
            // 7. 2장의 같은 숫자, 2장의 같은 숫자: 같은 숫자 중 큰 숫자*10+같은 숫자 중 작은숫자
        else if (map.size() == 3) {
            int min = 0;
            int max = 0;
            for (int i : map.keySet()) {
                if (map.get(i) == 2 && min == 0)
                    min = i;
                else if (map.get(i) == 2)
                    max = i;
            }
            if (min > max) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            System.out.println(max * 10 + min + 300);
        }
        // 8. 2장의 같은 숫자: 같은숫자+200
        else if (map.size() == 4) {
            for (int i : map.keySet()) {
                if (map.get(i) == 2) {
                    System.out.println(i + 200);
                    break;
                }
            }
        }
        // 해당없음: 가장큰숫자+100
        else {
            System.out.println(nums[4] + 100);
        }
    }
}
