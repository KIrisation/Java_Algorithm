//package programmers.lv0.devmatching;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// */
//public class problem1 {
//
//}
//
///**
// * 가생이 꼭지점들이 싹다 # 이 되어야 함.
// * 정사각형이며 최소 n >= 3 임.
// * 1. 가장 자리가 # 이 되어야 함.
// * 2. (k / Math.pow(n - 2, 2) * 100) 를 만족 해야함
// * 3. k 는 검은색 칸의 수 임.
// *   low<= (k / Math.pow(n - 2, 2) * 100) && (k / Math.pow(n - 2, 2) * 100) < high
// */
//
//class Solution {
//    // 목표 1. 정사각형 만들기
//    public int solution(int low, int high, String[] img) {
//        int answer = 0;
//        int k = 0;
//        String[][] img2d = new String[img.length][img[0].split("").length];
//        for (int i = 0; i < img.length; i++) {
//            String[] split = img[i].split("");
//            for (int j = 0; j < split.length; j++) {
//                if (split[j].contains("#")) {
//                    img2d[i][j] = split[j];
//                    k++;
//                    continue;
//                }
//
//                img2d[i][j] = split[j];
//            }
//        }
//
//        List<Integer> satisfiedList = new ArrayList<>();
//        for (int i = 3; i < 51; i++) {
//            double v = k / Math.pow(i - 2, 2) * 100;
//            if (low <= v && v < high) {
//                satisfiedList.add(i);
//            }
//        }
//
//        for (int i = 0; i < satisfiedList.size(); i++) {
//            makeSquare(satisfiedList, i);
//        }
//
//        return answer;
//    }
//
//    private List<List<String>> makeSquare(List<Integer> satisfiedList, int i) {
//        for (Integer integer : satisfiedList) {
//            for (int j = 0; j < ; j++) {
//
//            }
//        }
//        return null;
//    }
//
//}
