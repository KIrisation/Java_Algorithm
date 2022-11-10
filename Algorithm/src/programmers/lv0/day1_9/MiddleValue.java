 package programmers.lv0.day1_9;

 import java.util.HashMap;
 import java.util.Map;

 public class MiddleValue {
     public static void main(String[] args) {
        solution(new int[]{2, 1, 10, 7, 11});
     }

     public static int solution(int[] array) {
         System.out.println(array[2]);

         Map<Integer, Integer> map = new HashMap<>();

         int max = 0;
         for (int num : array) {
             if (map.containsKey(num)) {
                 map.put(num, map.get(num) + 1);
                 continue;
             }

             map.put(num, 1);
         }

         boolean flag = false;

         for (Integer num : map.keySet()) {
             if (map.get(num) > max) {
                 max = map.get(num);
                 flag = false;
             }
             if (map.get(num) == max) {
                 flag = true;
             }
         }

         return flag ? max : -1;
     }

 }
