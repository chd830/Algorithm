package Concept;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5, 1));
    }
    static int factorial(int N, int res) {
        //기저파트
        if(N == 1) {
            return res;
        }
        //유도파트
        return factorial(N-1, res*=N);
    }
}
