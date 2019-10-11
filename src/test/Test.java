package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
//        System.out.println(16 << 1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.trimToSize();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
        System.out.println(hashSet.isEmpty());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("", "");
        hashMap.get("");
    }
}
