package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문자열 내 마음대로 정렬하기 문제 설명 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가
 * ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 * <p>
 * 제한 조건 strings는 길이 1 이상, 50이하인 배열입니다. strings의 원소는 소문자 알파벳으로 이루어져 있습니다. strings의 원소는 길이 1 이상, 100이하인 문자열입니다. 모든
 * strings의 원소의 길이는 n보다 큽니다. 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다. 입출력 예 strings	n	return ["sun", "bed",
 * "car"]	1	["car", "bed", "sun"] ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
 */
public class RandomStringsSort {

    public static void main(String[] args) {
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> work = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            work.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(work);

        for (int i = 0; i < work.size(); i++) {
            answer[i] = work.get(i).substring(1);
        }

        return answer;
    }

//    public String[] solution(String[] strings, int n) {
//        String[] answer = new String[strings.length];
//
//        List<SomeStrings> someStringsList = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            someStringsList.add(new SomeStrings(n, strings[i]));
//        }
//
//        Collections.sort(someStringsList);
//
//        for (int i = 0; i < strings.length; i++) {
//            answer[i] = someStringsList.get(i).getValue();
//        }
//
//        return answer;
//    }
//
//    class SomeStrings implements Comparable<SomeStrings> {
//        private int cursor;
//        private int idx;
//        private String value;
//
//        public String getValue() {
//            return value;
//        }
//
//        public SomeStrings(int idx, String value) {
//            this.cursor = idx;
//            this.idx = idx;
//            this.value = value;
//        }
//
//        @Override
//        public int compareTo(SomeStrings o) {
//            if (this.value.charAt(this.idx) > o.value.charAt(o.idx)) {
//                return 1;
//            } else if (this.value.charAt(this.idx) == o.value.charAt(o.idx)) {
//                this.idx = cursor;
//                return compareTo(new SomeStrings(idx++, o.value));
//            }
//
//            return -1;
//        }
//    }
}
