import java.util.HashSet;

public class Unique {
    private static boolean uniqueCharacters(String input) {
        if (input == null || input.equals(""))
            throw new IllegalArgumentException();

        HashSet<Character> set = new HashSet<Character>();
        for (int i=0; i<input.length(); ++i) {
            if (set.contains(input.charAt(i)))
                return false;
            set.add(input.charAt(i));
        }
        return true;
    }

    public satic void main(String[] args) {
        for (String s : args)
            System.out.printf("%s -> %s\n", s, uniqueCharacters(s));
    }
}
