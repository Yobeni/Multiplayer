public class TestDrive {
    public static void main(String[] args) {
        System.out.println("Hola");
        System.out.println("Buenas tardes");

        for (int i = 0; i <= 5; i++) {
            System.out.println("Numero " + i);
        }
        test();
    }
    public static void test() {
        System.out.println("tests");
    }
    public static int sumar(int a, int b) {
        return a+b;
    }
    private String name;

    Persona persona = new Persona();
}
