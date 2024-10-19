package codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퀵정렬 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) {
        int N = nextInt();
        int[] quickArray = new int[N];
        for (int i = 0; i < quickArray.length; i++) {
            quickArray[i] = nextInt();
        }

        quickSort(quickArray, 0, quickArray.length - 1);

        for (int i : quickArray) {
            System.out.print(i +  " ");
        }
    }

    private static void quickSort(int[] quickArray, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = low + (high - low) / 2;
        int pivot = quickArray[pivotIndex];

        int left = low;
        int right = high;

        while (left <= right) {
            while (quickArray[left] < pivot) {
                left++;
            }

            while (quickArray[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(quickArray, left, right);
                left++;
                right--;
            }
        }

        quickSort(quickArray, low, right);
        quickSort(quickArray, left, high);
    }
    public static void swap(int[] quickArray, int i, int j) {
        int tmp = quickArray[i];
        quickArray[i] = quickArray[j];
        quickArray[j] = tmp;
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
