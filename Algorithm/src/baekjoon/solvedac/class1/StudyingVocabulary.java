package baekjoon.solvedac.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StudyingVocabulary {
    static Map<Character, Integer> vocabularies = new LinkedHashMap<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String voca = reader.readLine();

        for (int i = 0; i < voca.length(); i++) {
            vocabularies.compute(Character.toUpperCase(voca.charAt(i)), (k,v) -> v == null ? 1 : ++v);
        }

        List<Map.Entry<Character, Integer>> vocabulariesEntry = new ArrayList<>(vocabularies.entrySet());
        int maxCnt = 0;
        char result = 0;

        for (Entry<Character, Integer> characterIntegerEntry : vocabulariesEntry) {
            if (maxCnt < characterIntegerEntry.getValue()) {
                maxCnt = characterIntegerEntry.getValue();
                result = characterIntegerEntry.getKey();

            } else if (maxCnt == characterIntegerEntry.getValue()) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
