package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 가장 가까운 같은 글자 문제 설명 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다. 예를 들어,
 * s="banana"라고 할 때, 각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
 * <p>
 * b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다. a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다. n은 처음 나왔기 때문에 자신의 앞에
 * 같은 글자가 없습니다. 이는 -1로 표현합니다. a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다. n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다. a는 자신보다 두 칸, 네 칸
 * 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다. 따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
 * <p>
 * 문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
 * <p>
 * 제한사항 1 ≤ s의 길이 ≤ 10,000 s은 영어 소문자로만 이루어져 있습니다. 입출력 예 s	result "banana"	[-1, -1, -1, 2, 2, 2]
 */

/*
    고려 해야할 점

    1. 처음 발견된 글자를 저장 할 공간이 필요하다.
        - 무엇을 저장하나?
        - 해당 위치의 인덱스에 -1을 집어넣을 배열이 필요하다.
        - 즉 index 값과 value를 보관 해야한다.
    2. 이후 발견된 글자의 위치는 (이후 발견된 글자 위치의 인덱스 - 원래 위치의 인덱스) 를 뺀 값을 가진다.
 */
public class NearestIdenticalLetter {

    public static void main(String[] args) {

    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                answer[i] = -1;
                map.put(s.charAt(i), i);
                continue;
            }

            answer[i] = i - map.get(s.charAt(i));
            map.put(s.charAt(i), i);
        }

        return answer;
    }
}