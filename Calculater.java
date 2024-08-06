public class Sum {
    public static void main(String[] a) {
        Calculater c = new Calculater();
        System.out.println(c.powerInt(3, 3));
        System.out.println(c.powerDouble(4, 2));
    }
}

/**
 * Calculater
 */ 
public class Calculater {
    public static int powerInt(int n1, int n2) {
        for (int i = 0; i < n2; i++) {
            n1 *= n1;
        }
        return n1;
    }
    
    public static double powerDouble(double n1, double n2) {
        for (int i = 0; i < n2; i++) {
            n1 *= n1;
        }
        return n1;
    }
}
