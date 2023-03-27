public class TestDrive {
    public static void main(String[] args) {
        System.out.println("Hola");
        System.out.println("Buenas tardes");

        for (int i = 0; i <= 5; i++) {
            System.out.println("Numero " + i);
        }
        test();
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        p1.setEdad(18);
        p2.setEdad(25);

        int suma = sumar(p1.getEdad(), p2.getEdad());
        System.out.println(suma);
        System.out.println("sdadfafasd");
    }
    public static void test() {
        System.out.println("tests");
    }
    public static int sumar(int a, int b) {
        return a+b;
    }
}
