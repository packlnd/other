public class WordPuzzle {
    public static void main(String[] args) {
        char[][] board =
            new char[][]{{'C','X','Q'},
                         {'F','A','U'},
                         {'E','P','T'}};
        System.out.println(hasWord(board, "CAT"));
    }

    public static boolean hasWord(char[][] b, String x) {
        for (int i=0; i<b.length; ++i) {
            for (int j=0; j<b[0].length; ++j) {
                if (b[i][j] == x.charAt(0)) {
                    boolean[][] v = new boolean[b.length][b[0].length];
                    if (play(b, i, j, 1, x, v))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean play(char[][] b, int r, int c, int index, String x, boolean[][] v) {
        if (index==x.length())
            return true;
        v[r][c] = true;
        for (int i=r-1; i<r+1; ++i) {
            for (int j=c-1; j<c+1; ++j) {
                if (i<0 || i>=b.length || j<0 || j>=b[0].length ||
                        v[i][j] || b[i][j] == x.charAt(index))
                    continue;
                if (play(b,i,j,index+1,x,v))
                    return true;
            }
        }
        v[r][c] = false;
        return false;
    }
}
