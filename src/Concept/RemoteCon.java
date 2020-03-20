package Concept;


import java.util.Scanner;

public class RemoteCon {
    static int start;
    static int end;
    static int min = 40;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        end = sc.nextInt();
        remote(start, 0);
        System.out.println(min);
    }
    static void remote(int temp, int cnt) {
        if(cnt > min) {
            return;
        }
        if(temp == end) {
            if(cnt < min) {
                min = cnt;
            }
            return;
        }
        if(temp < end) {
            remote(temp+10, cnt+1);
            remote(temp+5, cnt+1);
            remote(temp+1, cnt+1);
        }
        else {
            remote(temp-10, cnt+1);
            remote(temp-5, cnt+1);
            remote(temp-1, cnt+1);
        }
    }
}
