package com.swexpertacademy;

import java.util.Scanner;

//비밀번호
public class d3_1234 {
    public d3_1234() {
        Scanner sc = new Scanner(System.in);
        for (int T = 1; T <= 10; T++) {
            int size = sc.nextInt();
            String str = sc.next();
            int firstIndex = size / 2;
            int nextIndex = size / 2;
            int index = 0;
            while (true) {
                if (index >= str.length() - 1) {
                    break;
                }
                char c = str.charAt(index);
                firstIndex = str.indexOf(c, index);
                nextIndex = str.indexOf(c, firstIndex+1);
                //같은숫자가 두개가 연속할 때
                if (nextIndex - firstIndex == 1 && firstIndex != -1) {
                    str = str.substring(0, firstIndex) + str.substring(nextIndex+1, str.length());
                    if(index >= 3) {
                        index -= 3;
                    }
                    else {
                        index = -1;
                    }
                }
                index++;
            }
            System.out.println("#" + T + " " + str);
        }
    }
}
