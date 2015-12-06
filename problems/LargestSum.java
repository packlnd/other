public class LargestSum {
    public static void main(String[] args) {
        assert longest(new int[]{1,2,3}) == 6;
        assert longest(new int[]{-1,1,3,-5,3}) == 4;
        assert longest(new int[]{-1,-2,3,-4,-5,-6}) == 3;
        assert longest(new int[]{3}) == 3;
        System.out.println("OK");
    }

    private static int longest(int[] V) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int e : V) {
            maxEndingHere += e;
            if (maxEndingHere < 0) maxEndingHere = 0;
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
