package Concept;

import java.util.Scanner;
 
public class Solution_D4_4530_극한의청소작업 {
 
    public static void main(String[] args) {
        long[] four=new long[13];
        four[1]=1;
        for (int i = 2; i < four.length; i++) {
            four[i]=9*four[i-1]+(long)Math.pow(10, i-1);
        }
        Scanner sc=new Scanner(System.in);
 
        int T=sc.nextInt();
        for (int i = 1; i <=T; i++) {
            boolean check=false;
            long a1=sc.nextLong();
            long b1=sc.nextLong();
            if((a1>0&&b1>0)||(a1<0&&b1<0)) {
                check=false;
            }else {
                check=true;
            }
            String a=""+Math.abs(a1);
            String b=""+Math.abs(b1);
             
            String ss=b;
            long sum1=0;
            for (int j = 0; j < ss.length(); j++) {
                int s=Integer.parseInt(ss.substring(j, j+1));
                int index=ss.length()-j-1;
                if(s>4) {
                    sum1=sum1+(s-1)*four[index]+(long)Math.pow(10, index);
                }else {
                    sum1=sum1+s*four[index];
                }
            }
            ss=a;
            long sum2=0;
            for (int j = 0; j < ss.length(); j++) {
                int s=Integer.parseInt(ss.substring(j, j+1));
                int index=ss.length()-j-1;
                if(s>4) {
                    sum2=sum2+(s-1)*four[index]+(long)Math.pow(10, index);
                }else {
                    sum2=sum2+s*four[index];
                }
            }
            if(check) {
            System.out.println("#"+i+" "+(Long.parseLong(b)+Long.parseLong(a)-(sum1+sum2)-1));
            }else {
                System.out.println("#"+i+" "+(Math.abs((Long.parseLong(b)-sum1)-(Long.parseLong(a)-sum2))));
                     
            }
        }
    }
 
}
