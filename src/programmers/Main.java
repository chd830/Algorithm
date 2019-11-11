package programmers;

public class Main {
    public static void main(String[] args) {
        GymSuit g = new GymSuit();
        System.out.println(g.solution(6 , new int[] {2,3,4}, new int[] {1,2,3,6}));
        System.out.println(g.solution(7 , new int[] {2,3,4}, new int[] {1,2,3,6}));
    }

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