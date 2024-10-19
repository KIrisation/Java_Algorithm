package codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병합정렬 {

    static int[] mergedArray;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) {
        int N = nextInt();
        mergedArray = new int[N];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = nextInt();
        }

        merge(arr, 0, N - 1);

        for (int i : mergedArray) {
            System.out.print(i + " ");
        }
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

    private static void merge(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            merge(arr, low, mid);
            merge(arr, mid + 1, high);
            mergeSort(arr, low, mid, high);
        }
    }

    private static void mergeSort(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArray[k] = arr[i];
                k += 1;
                i += 1;
            } else {
                mergedArray[k] = arr[j];
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            mergedArray[k] = arr[i];
            k += 1;
            i += 1;
        }

        while (j <= high) {
            mergedArray[k] = arr[j];
            k += 1;
            j += 1;
        }

        for (k = low; k <= high; k++) {
            arr[k] = mergedArray[k];
        }
    }
}
