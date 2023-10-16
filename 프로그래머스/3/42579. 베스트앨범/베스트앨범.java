import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, GenreAlbum> map = new HashMap<>();
        for (String genre : genres) {
            map.put(genre, new GenreAlbum(genre));
        }

        for (int i = 0; i < plays.length; i++) {
            final GenreAlbum genreAlbum = map.get(genres[i]);
            genreAlbum.add(i, plays[i]);
        }

        List<GenreAlbum> albums = new ArrayList<>(map.values());

        Collections.sort(albums, new Comparator<GenreAlbum>() {
            @Override
            public int compare(final GenreAlbum o1, final GenreAlbum o2) {
                return o2.playCount - o1.playCount;
            }
        });


        List<Integer> answer = new ArrayList<>();
        for (GenreAlbum album : albums) {
            final List<Integer> sort = album.sort();
            answer.add(sort.get(0));
            if(sort.size() > 1) {
                answer.add(sort.get(1));
            }
        }
        return answer.stream().mapToInt(each -> each).toArray();
    }

    class GenreAlbum {

        private final String genre;
        private int playCount = 0;
        private Map<Integer, Integer> uniques = new HashMap<>();

        public GenreAlbum(final String genre) {
            this.genre = genre;
        }

        public void add(int index, int plays) {
            this.uniques.put(index, plays);
            this.playCount += plays;
        }

        public List<Integer> sort() {
            List<Integer> list = new ArrayList<>();
            final ArrayList<Entry<Integer, Integer>> entries = new ArrayList<>(uniques.entrySet());
            Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(final Entry<Integer, Integer> o1, final Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            for (Entry<Integer, Integer> entry : entries) {
                list.add(entry.getKey());
            }
            return list;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final GenreAlbum that = (GenreAlbum) o;
            return Objects.equals(genre, that.genre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(genre);
        }
    }
}