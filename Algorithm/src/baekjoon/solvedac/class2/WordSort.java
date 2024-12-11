package baekjoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 백준 1181번: 단어 정렬
 */
public class WordSort {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(reader.readLine());

        Set<Word> words = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            String s = reader.readLine();
            words.add(new Word(s, s.length()));
        }

        List<Word> wordsToList = new ArrayList<>(words);

        Collections.sort(wordsToList);

        for (Word word : wordsToList) {
            System.out.println(word.getValue());
        }
    }
}

class Word implements Comparable<Word> {

    private final String value;
    private final int length;

    public Word(String value, int length) {
        this.value = value;
        this.length = length;
    }

    public String getValue() {
        return value;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int compareTo(Word o) {
        if (this.length == o.length) {
             return this.value.compareTo(o.value);
//            return this.value.compareToIgnoreCase(o.value); 현재 코드에서는 같은 동작을 한다 위의 코드
        }

        return this.length - o.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return length == word.length && Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, length);
    }
}