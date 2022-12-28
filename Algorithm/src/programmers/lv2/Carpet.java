package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {

    static List<YellowSquare> yellowSquares = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        makeYellowSquare(yellow);
        return calculateCorrectYellowSquare(brown);
    }

    private static int[] calculateCorrectYellowSquare(int brown) {
        for (YellowSquare yellowSquare : yellowSquares) {
            if (brown == (yellowSquare.getWidth() * 2) + (yellowSquare.getLength() * 2) + 4) {
                return new int[]{yellowSquare.getWidth() + 2, yellowSquare.getLength() + 2};
            }
        }

        return null;
    }

    private static void makeYellowSquare(int yellow) {
        for (int column = 1; column * column <= yellow; column++) {
            if (yellow % column == 0) {
                yellowSquares.add(new YellowSquare(yellow / column, column));
            }
        }
    }
}


/**
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 */
class YellowSquare {
    private int width;
    private int length;

    public YellowSquare(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}