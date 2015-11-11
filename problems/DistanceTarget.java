import java.util.*;

class DistanceTarget {
    public static void main(String[] args) {
        HashSet<String> s1 = new HashSet<String>();
        s1.add("sample");
        s1.add("problem");
        assert distance("This is a sample problem", s1) == 2;
        assert distance("This sample is another string problem sample", s1) == 2;
        assert distance("This sample is another string problem", s1) == 5;
        System.out.println("OK");
    }

    public static int distance(String s, HashSet<String> set) {
        String[] words = s.split(" ");
        int[] endsAt = new int[words.length];
        for (int i=0; i<endsAt.length; ++i)
            endsAt[i] = endsAt.length*2;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; ++i) {
            String word = words[i];
            if (set.contains(word))
                map.put(word, i+1);
            if (map.size() != set.size())
                continue;
            int min = Collections.min(map.values());
            int max = Collections.max(map.values());
            endsAt[i] = max-min+1;
        }
        int min = endsAt[0];
        for (int i : endsAt)
            min = Math.min(min, i);
        return min;
    }
}
