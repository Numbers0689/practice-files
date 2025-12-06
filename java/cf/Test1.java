public class Test1 {
    public static void main(String[] args) {
        System.out.println(utl('A'));
        System.out.println(nextChar('~'));
        System.out.println(large(12, 13));
    }

    private static char utl(char c) {
        return (char) (c + 32);
    }

    private static char nextChar(char c) {
        // if (c < 127) 
        return (char)(c + 1);
        // else return (char) 0;
    }

    public static int large(int a, int b) {
        return (a > b) ? a : b;
    }

    public static String eo(int n) {
        return (n % 2 == 0) ? "even" : "odd";
    }

    public static String vc(char c) {
        String q = "aeiouAEIOU";
        for (char e : q.toCharArray()) {
            if (c == e) return "vowel";
        }

        return "consonant";
    }

    public static String uol(char a) {
        if (a >= 'a' && a <= 'z') return "lowercase";
        else if (a >= 'A' && a <= 'Z') return "uppercase";
        return "invalid alphabet";
    }

}
