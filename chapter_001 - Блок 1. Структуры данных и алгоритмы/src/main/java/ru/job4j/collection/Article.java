package ru.job4j.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Article {

    public static boolean generateBy(String origin, String line) {

        Map<String, Integer> originStringsMap = new HashMap<>();

        String[] strings = origin.split("[\\s,.!;:]+");

        for(String str : strings) {
            String lowerCaseStr = str.toLowerCase();
            Integer count = originStringsMap.get(lowerCaseStr);
            if (count == null) {
                originStringsMap.put(lowerCaseStr, 1);
            } else {
                originStringsMap.put(lowerCaseStr, ++count);
            }
        }

        strings = line.split("[\\s,.!;:]+");
        for(String str : strings) {
            String lowerCaseStr = str.toLowerCase();
            Integer count = originStringsMap.get(lowerCaseStr);
            if (count == null || count == 0) {
                return false;
            }
            originStringsMap.put(lowerCaseStr, --count);
        }
        return true;
    }

    public static boolean generateBy2(String origin, String line) {

        List<String> originStringsArray = new ArrayList<>();

        String[] strings = origin.split("[\\s,.!;:]+");

        for(String str : strings) {
            String lowerCaseStr = str.toLowerCase();
            originStringsArray.add(lowerCaseStr);
        }

        strings = line.split("[\\s,.!;:]+");
        for(String str : strings) {
            String lowerCaseStr = str.toLowerCase();
            if (!originStringsArray.contains(lowerCaseStr)) {
                return false;
            }
            originStringsArray.remove(lowerCaseStr);
        }
        return true;
    }
}
