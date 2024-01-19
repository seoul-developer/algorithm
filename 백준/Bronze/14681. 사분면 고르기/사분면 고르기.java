import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int x = scanner.nextInt();
        final int y = scanner.nextInt();

        System.out.println(findResult(x, y));
    }

    private static int findResult(final int x, final int y) {
        if (x * y > 0) {
            return x + y > 0 ? 1 : 3;
        }
        return x > 0 ? 4 : 2;
    }
}
