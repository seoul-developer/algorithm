class Solution {

    public int solution(String ineq, String eq, int n, int m) {
        final boolean res = result(ineq, eq, n, m);
        return res ? 1 : 0;
    }

    private boolean result(final String ineq, final String eq, final int n, final int m) {
        if (ineq.equals("<") && eq.equals("=")) {
            return n <= m;
        }
        if (ineq.equals(">") && eq.equals("=")) {
            return n >= m;
        }
        if (ineq.equals("<") && eq.equals("!")) {
            return n < m;
        }
        if (ineq.equals(">") && eq.equals("!")) {
            return n > m;
        }
        throw new IllegalArgumentException();
    }
}