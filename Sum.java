public class Sum {
    public static void main(String[] a) {
        Calculater c = new Calculater();
        System.out.println(c.powerInt(5, 3) == (int) Math.pow(5, 3));
        System.out.println(c.powerDouble(4, 4) == Math.pow(4, 4));
    }
}

/**
 * Calculater
 */ 
class Calculater {
    public int powerInt(int n1, int n2) {
        int n = 1;
        for (int i = 0; i < n2; i++) {
            n *= n1;
        }
        return n;
    }
    
    public double powerDouble(double n1, double n2) {
        double n = 1;
        for (int i = 0; i < n2; i++) {
            n *= n1;
        }
        return n;
    }
}
