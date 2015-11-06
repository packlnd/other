public class Compress {
    private static String compress(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        char currChar = input.charAt(0);
        for (int i=1; i<input.length(); ++i)

        return sb.toString();
    }

    public static void main(String[] args) {
        assert compress("AAAA").equals("A4");
        assert compress("AABBBCC").equals("A2B3C2");
        System.out.println("✓");
    }
}
