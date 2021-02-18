package ru.job4j.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftDemo {
    public static void main(String[] args)  {
        example1();
        //example2();

    }
    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }
    private static void example2()  {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));

        }
        System.gc();
        int liveObjects = 0;
        for( SoftReference<Object> obj : objects) {
            Object object = obj.get();
            if (object != null) {
                liveObjects++;
            }
        }
        System.out.println(liveObjects);
    }
}
