import java.util.Stack;
//t
class Balance {
    public static void main(String[] args) {
        assert brackets("<()>");
        assert !brackets("<(>)");
        assert brackets("<([{}])>");
        assert !brackets("<<<<<<<<<<<<<");
        assert !brackets(">>>>>>>>>>>>>");
        assert brackets("<<<<<<<<<<<<<>>>>>>>>>>>>>");
        System.out.println("✓");
    }

    public static boolean brackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); ++i) {
            if ("<{[(".indexOf(s.charAt(i))>=0)
                stack.push(s.charAt(i));
            if (">}])".indexOf(s.charAt(i))>=0)
                if (stack.isEmpty() || !matches(stack.pop(), s.charAt(i)))
                    return false;
        }
        return stack.isEmpty();
    }

    public static boolean matches(char a, char b) {
        return (a == '[' && b == ']') || (a == '<' && b == '>') ||
               (a == '(' && b == ')') || (a == '{' && b == '}');
    }
}
