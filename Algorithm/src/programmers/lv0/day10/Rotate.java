package programmers.lv0.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotate {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{4, 455, 6, 4, -1, 45, 6}, "left")));
    }

    public static int[] rotate(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int cursorOne = 1;
        int cursorTwo = 0;
        if (direction.equals("right")) {
            answer[0] = numbers[numbers.length - 1];
            while (true) {
                answer[cursorOne] = numbers[cursorTwo];
                cursorOne++;
                if (cursorOne == numbers.length) {
                    return answer;
                }
                cursorTwo++;
            }
        } else if (direction.equals("left")) {
            answer[numbers.length - 1] = numbers[0];

            cursorOne = 0;
            cursorTwo = 1;

            while (true) {
                answer[cursorOne] = numbers[cursorTwo];
                cursorOne++;
                cursorTwo++;
                if (cursorTwo  == numbers.length) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public List<Integer> solution2(int[] numbers, String direction) {
        List<Integer> answer = new ArrayList<>();

        for (int number : numbers) {
            answer.add(number);
        }

        if(direction.equals("right")){
            answer.add(0, numbers[numbers.length-1]);
            answer.remove(answer.size()-1);

        }else{
            answer.add(numbers[0]);
            answer.remove(0);
        }

        return answer;
    }
}
