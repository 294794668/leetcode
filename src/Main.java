public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.print('\'');
    }

//    private void print(char i) {
//        System.out.println(i);
//    }
//
//    private void print(int i) {
//        System.out.println(i);
//    }
//
//    private void print(long i) {
//        System.out.println(i);
//    }
//
//    private void print(double i) {
//        System.out.println(i);
//    }
//    private void print(float i) {
//        System.out.println(i);
//    }

    private void print(char... i) {
        System.out.println(i);
    }

    private void print(Object i) {
        System.out.println(i);
    }
    private void print(Integer i) {
        System.out.println(i);
    }
}
