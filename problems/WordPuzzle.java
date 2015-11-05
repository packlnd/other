public class WordPuzzle {
    public static void main(String[] args) {
        char[][] board =
            new char[][]{{'F','X','C'},
                         {'F','A','U'},
                         {'T','P','T'}};
        assert hasWord(board, "CAT");
        assert hasWord(board, "F");
        assert !hasWord(board, "CATA");
        assert !hasWord(board, "CATAC");
        assert hasWord(board, "TAPTFFXCU");
        assert !hasWord(board, "TAPTFFXCUT");
        System.out.println("✓");
    }

    public static boolean hasWord(char[][] b, String x) {
        if (x == null)
            throw new IllegalArgumentException();
        for (int i=0; i<b.length; ++i) {
            for (int j=0; j<b.length; ++j) {
                if (b[i][j] == x.charAt(0)) {
                    boolean[][] v = new boolean[b.length][b.length];
                    if (play(b, x, 1, i, j, v))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean play(char[][] b, String x, int idx, int r, int c, boolean[][] v) {
        if (idx == x.length())
            return true;
        v[r][c] = true;
        for (int i=Math.max(0, r-1); i<Math.min(b.length, r+2); ++i) {
            for (int j=Math.max(0, c-1); j<Math.min(b.length, c+2); ++j) {
                if ((i==r && j==c) || b[i][j] != x.charAt(idx) || v[i][j])
                    continue;
                if (play(b, x, idx+1, i, j, v))
                    return true;
            }
        }
        return false;
    }
}
