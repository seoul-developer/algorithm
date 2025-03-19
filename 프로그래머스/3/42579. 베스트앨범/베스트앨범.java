import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genreCount 장르 카운트 {클래식: 1450, 팝: 3100}
        // albums 장르별 개수 {클래식: {500,0}, {150,2}, {800,3}} / {팝: {600,1}, {2500,4}}
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, Map<Integer, Integer>> albums = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            genreCount.put(genres[i], 0);
            albums.put(genres[i], new HashMap<Integer,Integer>());
        }
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            genreCount.put(genre, genreCount.get(genre)+play);
            albums.get(genre).put(i,play);
        }
        
        List<String> keySet = new ArrayList<>(genreCount.keySet()); 
        Collections.sort(keySet, (a,b)->(genreCount.get(b)-genreCount.get(a)));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String key: keySet){
            Map<Integer, Integer> album = albums.get(key);
            List<Integer> keys = new ArrayList<>(album.keySet());
            Collections.sort(keys, (a,b)->(album.get(b)-album.get(a)));
            
            answer.add(keys.get(0));
            if(keys.size()>=2){
                answer.add(keys.get(1));
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}