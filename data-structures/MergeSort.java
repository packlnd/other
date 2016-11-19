public class MergeSort {
  public static void mergeSort(int[] V) {
    if (V == null || V.length == 1) return;
    int alen = (V.length+1)/2;
    int blen = (V.length)/2;
    int[] a = new int[alen];
    int[] b = new int[blen];
    for (int i=0; i<alen; ++i) a[i]=V[i];
    for (int i=0; i<blen; ++i) b[i]=V[alen+i];
    mergeSort(a);
    mergeSort(b);
    int ap = 0;
    int bp = 0;
    while (ap < a.length && bp < b.length) {
      if (a[ap] < b[bp]) V[ap+bp] = a[ap++];
      else V[ap+bp] = b[bp++];
    }
    while (ap < a.length) V[ap+bp] = a[ap++];
    while (bp < b.length) V[ap+bp] = b[bp++];
  }

  public static void main(String[] args) {
    int[] a = new int[]{1};
    int[] b = null;
    int[] c = new int[]{1,4,3,9,0};
    int[] d = new int[]{4,3,2,1};
    System.out.println(java.util.Arrays.toString(a));
    mergeSort(a);
    System.out.println(java.util.Arrays.toString(a));
    System.out.println(java.util.Arrays.toString(b));
    mergeSort(b);
    System.out.println(java.util.Arrays.toString(b));
    System.out.println(java.util.Arrays.toString(c));
    mergeSort(c);
    System.out.println(java.util.Arrays.toString(c));
    System.out.println(java.util.Arrays.toString(d));
    mergeSort(d);
    System.out.println(java.util.Arrays.toString(d));
  }
}
