public class IsRotation {
    public static void main(String[] args) {
        assert isRotationOf("aterbottlew", "waterbottle");
        assert !isRotationOf("aterbottle", "waterbottle");
        System.out.println("OK");
    }

    public static boolean isRotationOf(String s1, String s2) {
        if (s1 == null || s2 == null)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s1);
        return sb.toString().contains(s2);
    }
}
