public class Rotate {
    public static void rotate(int[][] V) {
        int N = V.length-1;
        int jLimit = (V.length+1)/2;
        int iLimit = V.length % 2==0 ? jLimit : jLimit-1;
        for (int i=0; i<iLimit; ++i) {
            for (int j=0; j<jLimit; ++j) {
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
                System.out.printf("%02d ", V[i][j]);
            }
            System.out.println("");
        }
    }

    public static void action(int[][] V) {
        print(V);
        System.out.println("--------");
        rotate(V);
        print(V);
    }

    public static void main(String[] args) {
        int[][] V1 = new int[][] {{1,2,3},
                                  {4,5,6},
                                  {7,8,9}};
        int[][] V2 = new int[][] {{ 1, 2, 3, 4},
                                  { 5, 6, 7, 8},
                                  { 9,10,11,12},
                                  {13,14,15,16}};
        action(V1);
        System.out.println();
        action(V2);
    }
}
