package co.kr.programmers;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[] {"c", "p", "c", "c", "p"}, new int[] {500, 600, 150, 800, 2500})));
//        System.out.println(Arrays.toString(solution(new String[] {"c", "c", "c", "c", "p"}, new int[] {500, 600, 150, 800, 2500})));
//        System.out.println(Arrays.toString(solution(new String[] {"c", "d", "d", "c", "p"}, new int[] {500, 600, 150, 800, 2500})));
//        System.out.println(Arrays.toString(solution(new String[] {"a", "b", "c", "d"}, new int[] {500, 600, 150, 800})));
        System.out.println(Arrays.toString(solution(new String[] {"c", "p", "c", "p", "c", "c"}, new int[] {400, 600, 150, 2500, 500, 500})));
        /*
        genres ["classic", "pop", "classic", "pop", "classic", "classic"]
        plays [400, 600, 150, 2500, 500, 500]
        Return [3, 1, 4, 5]
         */
    }
    static class Music implements Comparable<Music> {
        String genre;
        int play;
        Music(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Music o) {
            return -Integer.compare(this.play, o.play);
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", play=" + play +
                    '}';
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> music = new HashMap<>();
        int len = genres.length;
        for(int i = 0; i < len; i++) {
            if(music.containsKey(genres[i]))
                music.put(genres[i], music.get(genres[i])+plays[i]);
            else
                music.put(genres[i], plays[i]);
        }
        Music[] musics = new Music[music.size()];
        int idx = 0;
        for(String key : music.keySet())
            musics[idx++] = new Music(key, music.get(key));
        Arrays.sort(musics);
        int size = 0;
        List<Integer>[] musicList = new ArrayList[music.size()];
        for(int i = 0; i < musics.length; i++) {
            musicList[i] = new ArrayList<>();
            for(int j = 0; j < len; j++) {
                if(musics[i].genre.equals(genres[j])) {
                    musicList[i].add(j);
                }
            }
            if(musicList[i].size() < 2)
                size += 1;
            else
                size += 2;
        }

        idx = 0;
        int[] result = new int[size];
        for(int i = 0; i < musicList.length; i++) {
            int cnt = 0;
            while(cnt != 2) {
                int max = 0;
                int maxIdx = Integer.MAX_VALUE;
                int remove = 0;
                if(musicList[i].size() == 0)
                    break;
                for(int j = 0; j < musicList[i].size(); j++) {
                    int val = musicList[i].get(j);
                    if(max < plays[val]) {
                        max = plays[val];
                        maxIdx = val;
                        remove = j;
                    }
                    else if(max == plays[val] && maxIdx > val) {
                        remove = j;
                        maxIdx = val;
                    }
                }
                result[idx++] = maxIdx;
                musicList[i].remove(remove);
                cnt++;
            }
        }
        return result;
    }
}
