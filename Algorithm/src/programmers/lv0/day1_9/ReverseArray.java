package programmers.lv0.day1_9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseArray {

    public int[] solution(int[] num_list) {

        int startPositionPointer = 0;
        int endPositionPointer = num_list.length - 1;

        while (true) {

            if (startPositionPointer >= endPositionPointer) {
                break;
            }

            int tmp = num_list[startPositionPointer];
            num_list[startPositionPointer++] = num_list[endPositionPointer];
            num_list[endPositionPointer--] = tmp;
        }

        return num_list;
    }

    public int[] solution2(int[] num_list) {
        Stack<Integer> stack = new Stack<>();

        for (int i : num_list) {
            stack.push(i);
        }

        int i = 0;
        while (!stack.empty()) {
            num_list[i++] = stack.pop();
        }

        return num_list;
    }

    public int[] solution3(int[] numList) {
        List<Integer> list = Arrays.stream(numList)
                .boxed().collect(Collectors.toList());

        Collections.reverse(list);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}

