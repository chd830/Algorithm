package programmers;

public class Main {
    public static void main(String[] args) {
        GetCenterString g = new GetCenterString();
        System.out.println(g.solution("abcde"));
        System.out.println(g.solution("qwer"));
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