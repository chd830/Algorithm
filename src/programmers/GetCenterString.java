package programmers;

public class GetCenterString {
    public String solution(String s) {
        int center = s.length()/2;
        System.out.println("가운데 값: "+center+", result: "+s.charAt(center));
        if(s.length() % 2 == 1) {
            return s.charAt(center)+"";
        }
        else {
            return "" + s.charAt(center - 1) + s.charAt(center)+"";
        }
    }
}
