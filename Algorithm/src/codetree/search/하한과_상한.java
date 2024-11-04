package codetree.search;

public class 하한과_상한 {

    public static void main(String[] args) {

        int[] arr1 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        int firstLowerBound = lowerBound(arr1, 16);
        int firstUpperBound = upperBound(arr1, 16);

        System.out.println("하한 값: " + firstLowerBound);
        System.out.println("상한 값: " + firstUpperBound);

        int[] arr2 = {1, 3, 9, 12, 17, 21, 24, 28, 32, 35};
        int secondLowerBound = lowerBound(arr2, 20);
        int secondUpperBound = upperBound(arr2, 20);

        System.out.println("하한 값: " + secondLowerBound);
        System.out.println("상한 값: " + secondUpperBound);

        int[] arr3 = {4, 8, 9, 12, 15, 18, 23, 24, 24, 26, 27, 29, 31};
        int thirdLowerBound = lowerBound(arr3, 24);
        int thirdUpperBound = upperBound(arr3, 24);

        System.out.println("하한 값: " + thirdLowerBound);
        System.out.println("상한 값: " + thirdUpperBound);

        int[] arr4 = {8, 10, 12, 14, 14, 16, 16, 16, 18, 20, 22};
        int customBound = customBound(arr4, 16);
        System.out.println(customBound);

    }

    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }

    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }

    static int customBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
                minIdx = Math.max(minIdx, mid);
            } else {
                right = mid - 1;
            }
        }

        return minIdx;
    }
}
