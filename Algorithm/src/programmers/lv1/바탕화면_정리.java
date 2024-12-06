package programmers.lv1;

public class 바탕화면_정리 {

    public int[] solution(String[] wallpaper) {
        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;

        for (int y = 0; y < wallpaper.length; y++) {
            for (int x = 0; x < wallpaper[0].length(); x++)  {
                if (wallpaper[y].charAt(x) == '#') {
                    if (startY == -1 && startX == -1 && endY == -1 && endX == -1) { // 맨 처음 발견 했을 때
                        startY = y; // 0
                        startX = x; // 1
                        endY = y + 1; // 1
                        endX = x + 1; // 2
                    }
                }
            }
        }

        return new int[]{startY, startX, endY, endX};
    }
}
