public class Rotate {
    public static void rotate(int[][] V) {
        int N = V.length-1;
        for (int i=0; i<(N+1)/2; ++i) {
            for (int j=0; j<(N+1)/2; ++j) {
                int tmp = V[i][j];
                V[i][j] = V[N-j][i];
                V[N-j][i] = V[N-i][N-j];
                V[N-i][N-j] = V[j][N-i];
                V[j][N-i] = tmp;
            }
        }
    }

    public static void print(int[][] V) {
        for (int i=0; i<V.length; ++i) {
            for (int j=0; j<V.length; ++j) {
                System.out.printf("%d ", V[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[][] V = new int[][] {{1,2,3},
                                 {4,5,6},
                                 {7,8,9}};
        print(V);
        System.out.println("--------");
        rotate(V);
        print(V);
    }
}
