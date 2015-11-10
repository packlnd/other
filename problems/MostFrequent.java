import java.util.*;

class MostFrequent {
    public static void main(String[] args) {
        int[] V1 = new int[]{1,2,1,3,4,5,6,7,8};
        assert mostFrequent(V1) == 1;
        int[] V2 = new int[]{3};
        assert mostFrequent(V2) == 3;
        int[] V3 = new int[]{1,1,1,2,2};
        assert mostFrequent(V3) == 1;
        System.out.println("OK");
    }

    public static int mostFrequent(int[] V) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i : V) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                continue;
            }
            int count = map.get(i);
            map.put(i, ++count);
        }
        return Collections.max(map.entrySet(),
                new Comparator<Map.Entry<Integer,Integer>>() {
                public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2) {
                    return e1.getValue().compareTo(e2.getValue());
                }
        }).getKey();
    }
}
