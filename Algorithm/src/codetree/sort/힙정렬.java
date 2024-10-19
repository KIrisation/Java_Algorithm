package codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 힙정렬 {

    static StringTokenizer st;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

    }

    static void heapify(int[] heapArray, int n, int i) {
        int largestIndex = i;
        int leftIndex = i * 2;
        int rightIndex = i * 2 + 1;

        if (leftIndex <= n && heapArray[leftIndex] > heapArray[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex <= n && heapArray[rightIndex] > heapArray[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != i) {
            swap(heapArray, i, largestIndex);
            heapify(heapArray, n, largestIndex);
        }
    }

    static void heapSort(int[] heapArray, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(heapArray, n, i);
        }

        for (int i = n; i > 1; i--) {
            swap(heapArray, 1, i);
            heapify(heapArray, i - 1, 1);
        }
    }
    static void swap(int[] heapArray, int i, int j) {
        int tmp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = tmp;
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
