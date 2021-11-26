package String;

import java.util.*;

public class 순위검색 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[] {"java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[] {"java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"})));
    }
    public static int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        List<String[]> infolist = new ArrayList<>();
        List<String[]> querylist = new ArrayList<>();
        for(int i = 0; i < info.length; i++)
            infolist.add(info[i].split(" "));
        for(int i = 0; i < query.length; i++)
            querylist.add(query[i].replaceAll(" and", "").split(" "));
        Comparator<String[]> comp = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return -Integer.compare(Integer.parseInt(o1[4]), Integer.parseInt(o2[4]));
            }
        };
        Collections.sort(infolist, comp);
        for(int i = 0; i < querylist.size(); i++) {
            loop: for(int j = 0; j < infolist.size(); j++) {
                if(Integer.parseInt(querylist.get(i)[4]) > Integer.parseInt(infolist.get(j)[4]))
                    break loop;
                for(int k = 0; k < 5; k++) {
                    if(k == 4)
                        result[i]++;
                    if(querylist.get(i)[k].equals("-"))
                        continue;
                    else if(querylist.get(i)[k].equals(infolist.get(j)[k]))
                        continue;
                    else
                        break;
                }
            }
        }
        return result;
    }
}
