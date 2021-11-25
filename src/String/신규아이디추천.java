package String;

public class 신규아이디추천 {
    public static void main(String[] args) {
//        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println("bat.y.abcdefghi");
        System.out.println(solution("z-+.^."));
        System.out.println("z--");
    }
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String answer = "";
        for(char c : new_id.toCharArray()) {
            if(Character.isDigit(c))
                answer += c;
            else if(Character.isAlphabetic(c))
                answer += c;
            else if(c == '-' || c == '_' || c == '.')
                answer += c;
        }
        while(answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        if(answer.charAt(0) == '.') {
            if(answer.length() == 1)
                answer = "a";
            else
                answer = answer.substring(1, answer.length());
        }
        if(answer.length() >= 16)
            answer = answer.substring(0, 15);
        if(answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);
        char c = answer.charAt(answer.length()-1);
        while(answer.length() <= 2) {
            answer += c;
        }
        return answer;
    }
}
