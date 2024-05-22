package programmers.lv2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumber {

    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        Set<String> collect = new HashSet<>();

        Collections.addAll(collect, phone_book);

        for (String s : phone_book) {
            for (int j = 1; j <= s.length(); j++) {
                String str = s.substring(0, j);

                if (collect.contains(str) && !str.equals(s)) {
                    return false;
                }
            }
        }

        return true;
    }
}
