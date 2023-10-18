import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        final List<User> users = getUsers(id_list);
        final HashMap<User, List<User>> reports = generateReports(report);
        final HashMap<User, Integer> reportsCount = countReports(reports);
        final List<User> stoppers = generateStoppers(k, reportsCount);

        final List<Integer> answer = new ArrayList<>();
        for (final User from : users) {
            final List<User> to = reports.getOrDefault(from, new ArrayList<>());
            final List<User> stopUsers = new ArrayList<>(stoppers);
            to.retainAll(stopUsers);
            answer.add(to.size());
        }

        return answer.stream().mapToInt(it -> it).toArray();
    }

    private List<User> getUsers(final String[] id_list) {
        return Arrays.stream(id_list)
                .map(User::new)
                .collect(Collectors.toList());
    }

    private HashMap<User, List<User>> generateReports(final String[] report) {
        final HashMap<User, List<User>> reports = new HashMap<>();
        for (final String ids : report) {
            final String[] idArray = ids.split(" ");
            final User from = new User(idArray[0]);
            final User to = new User(idArray[1]);
            if (reports.getOrDefault(from, new ArrayList<>()).contains(to)) {
                continue;
            }
            final List<User> tos = reports.getOrDefault(from, new ArrayList<>());
            tos.add(to);
            reports.put(from, tos);
        }
        return reports;
    }

    private static HashMap<User, Integer> countReports(final HashMap<User, List<User>> reports) {
        final HashMap<User, Integer> reportsCount = new HashMap<>();
        for (final List<User> user : reports.values()) {
            for (final User it : user) {
                reportsCount.put(
                        it,
                        reportsCount.getOrDefault(it, 0) + 1
                );
            }
        }
        return reportsCount;
    }

    private static List<User> generateStoppers(final int k, final HashMap<User, Integer> reportsCount) {
        final List<User> stoppers = new ArrayList<>();
        for (final User user : reportsCount.keySet()) {
            if (reportsCount.get(user) >= k) {
                stoppers.add(user);
            }
        }
        return stoppers;
    }

    private class User {

        private final String name;

        public User(final String name) {
            this.name = name;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
