import java.util.HashMap;
import java.util.List;

class Solution {

    public static int[] solution(String[] park, String[] routes) {
        final String[][] parks = createParks(park);
        int[] start = findStartCoordinates(parks);

        final HashMap<String, List<Integer>> movements = new HashMap<>();
        movements.put("E", List.of(0, 1));
        movements.put("W", List.of(0, -1));
        movements.put("N", List.of(-1, 0));
        movements.put("S", List.of(1, 0));

        for (final String route : routes) {
            start = move(parks, start, movements, route);
        }

        return start;
    }

    private static int[] move(final String[][] parks, int[] start, final HashMap<String, List<Integer>> movements, final String route) {
        final String[] array = route.split(" ");
        final String direction = array[0];
        final int distance = Integer.parseInt(array[1]);

        return move(parks, start, distance, movements, direction);
    }

    private static int[] move(final String[][] parks, final int[] start, final int distance, final HashMap<String, List<Integer>> movements, final String dir) {
        final List<Integer> movement = movements.get(dir);

        final int row = start[0];
        final int column = start[1];

        final int rowMovement = movement.get(0);
        final int columnMovement = movement.get(1);

        final int newRow = row + rowMovement * distance;
        final int newColumn = column + columnMovement * distance;

        if (isOutOfPark(parks, newRow, newColumn)) {
            return start;
        }

        if (isObstacle(parks, distance, row, column, rowMovement, columnMovement)) {
            return start;
        }

        start[0] = newRow;
        start[1] = newColumn;
        return start;
    }

    public static String[][] createParks(final String[] park) {
        final String[][] parks = new String[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            final String[] row = park[i].split("");
            for (int j = 0; j < park[0].length(); j++) {
                parks[i][j] = row[j];
            }
        }

        return parks;
    }

    public static int[] findStartCoordinates(final String[][] parks) {
        for (int i = 0; i < parks.length; i++) {
            final String[] row = parks[i];
            for (int j = 0; j < row.length; j++) {
                final String one = row[j];
                if (one.equals("S")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isOutOfPark(final String[][] parks, final int newRow, final int newColumn) {
        return newRow > parks.length || newRow < 0 || newColumn > parks[0].length || newColumn < 0;
    }

    private static boolean isObstacle(final String[][] parks, final int distance, final int row, final int column, final int rowMovement, final int columnMovement) {
        boolean isObstacle = false;
        for (int i = 1; i <= distance; i++) {
            String way = findWay(parks, row, column, rowMovement, columnMovement, i);
            if (way.equals("X")) {
                isObstacle = true;
                break;
            }
        }
        return isObstacle;
    }

    private static String findWay(final String[][] parks, final int row, final int column, final int rowMovement, final int columnMovement, final int i) {
        try {
            return parks[row + i * rowMovement][column + i * columnMovement];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return "X";
        }
    }
}
