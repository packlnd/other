import java.util.HashSet;

public class SetToZero {
    public static void main(String[] args) {
        int[][] V1 = new int[][]{{1,2,0},{4,5,6},{7,8,9}};
        print(V1);
        eliminateRowsAndCols(V1);
        System.out.println();
        print(V1);
    }

    public static void eliminateRowsAndCols(int[][] V) {
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for (int i=0; i<V.length; ++i) {
            for (int j=0; j<V[0].length; ++j) {
                if (V[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int r : rowSet)
            for (int j=0; j<V[0].length; ++j)
                V[r][j] = 0;
        for (int c : colSet)
            for (int i=0; i<V.length; ++i)
                V[i][c] = 0;
    }

    public static void print(int[][] V) {
        for (int i=0; i<V.length; ++i) {
            for (int j=0; j<V.length; ++j)
                System.out.printf("%02d ", V[i][j]);
            System.out.println("");
        }
    }
}
