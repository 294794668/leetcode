package test;

public class Test {
    public static void main(String[] args) {
        int i = 1;
        System.out.println((++i) + (++i));

        System.out.println(isFalse() & isTrue());
        System.out.println("------------");
        System.out.println(isFalse() && isTrue());
        System.out.println("------------");
        System.out.println(isTrue() | isFalse());
        System.out.println("------------");
        System.out.println(isTrue() || isFalse());
        System.out.println(~1);
    }


    public static boolean isFalse() {
        System.out.println("go false");
        return false;
    }

    public static boolean isTrue() {
        System.out.println("go true");
        return true;
    }
}
