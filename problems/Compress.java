public class Compress {
    private static String compress(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<input.length(); ++i) {
            char currChar = input.charAt(i);
            int counter=0;
            while (i < input.length() && input.charAt(i) == currChar) {
                ++i;
                ++counter;
            }
            sb.append(currChar).append(counter);
            --i;
        }
        if (sb.length() >= input.length())
            return input;
        return sb.toString();
    }

    public static void main(String[] args) {
        assert compress("AAAA").equals("A4");
        assert compress("AABBBCC").equals("A2B3C2");
        assert compress("AABBCCDDEE").equals("AABBCCDDEE");
        assert compress("AABBBCCDDEE").equals("A2B3C2D2E2");
        System.out.println("✓");
    }
}
