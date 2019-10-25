package test;

public class Test {
    public static void main(String[] args) {
        int[][] ints = new int[1][1];
        int[][] ints1 = ints;
        ints[0][0] = 1;
        System.out.println(ints1[0][0]);
        int i = 0;
        int j = i;
        i = 1;
        System.out.println(j);
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
