package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 26; i++) {
            System.out.print("\"" + (char) (96 + i) + "\",");
            if (i % 3 == 0) {
                System.out.println();
            }
        }

    }

}
