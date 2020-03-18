package Concept;

import java.util.HashMap;
import java.util.Scanner;
 
public class Solution_D4_4530_극한의청소작업_수열 {
 
	static HashMap<Long, Long> m=new HashMap<Long, Long>();
	public static void main(String[] args) {
		m.clear();
		m.put(0L, 1L);
		m.put(1L, 2L);
		m.put(2L, 3L);
		m.put(3L, 4L);
		m.put(4L, 4L);
		m.put(5L, 5L);
		m.put(6L, 6L);
		m.put(7L, 7L);
		m.put(8L, 8L);
		m.put(9L, 9L);
		Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int t = 1; t <=T; t++) {
        	 long a1=sc.nextLong();
             long b1=sc.nextLong();
             long c=calc(a1,b1);
             System.out.println("#"+t+" "+c);
        }
		
    }
    public static long calc(long a1, long b1){
    	 if(a1>0 && b1>0) {
             return f(b1)-f(a1);
         }else if(a1<0 && b1<0){
        	 return -f(-b1)+f(-a1);
         }else{
        	 return  f(b1)+f(-a1)+1-4; //음수 양수일때 0 1, -0 -1 제거
         }
    }

	public static long g(long n){
		if(n>=0 && n<4){
			return n+1;
		}else if(n>=4 && n<10){
			return n;
		}else if((n+"").charAt(0)=='4'){
			long v=pow10(len(n));
	    	//System.out.printf("g(%d)=g(%d) \n",n,(n/v-1)*v+n%v);
			return g((n/v-1)*v+n%v);
		}else {
			long v=pow10(len(n));
			//System.out.printf("g(%d)=f(%d)\n",n,n%v);
			return f(n%v);
		}
	}
	public static long f(long n) {
		if(m.containsKey(n)) {
			//System.out.printf("f(%d)=%d\n",n,m.get(n));
			return m.get(n);
		}else if((n+"").charAt(0)=='4'){
			long v=pow10(len(n));// 45 -> 10 (4-1)*v+n%v
			//System.out.printf("f(%d)=f(%d) \n",n,n-1L-n%v);
			m.put(n, f(n-1L-n%v));
			return m.get(n);
		}else{
			long v=pow10(len(n));
			//System.out.printf("f(%d)=f(%d)+g(%d) \n",n,n-1L-n%v,n);
			m.put(n, f(n-1L-n%v)+g(n));
			return m.get(n);
		}
	}
	public static long len(long n){
		return 0L+(n+"").length()-1;
	}
	public static long pow10(long n){
		return (long)Math.pow(10, n);
	}
}