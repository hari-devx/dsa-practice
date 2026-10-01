package Searching.BinarySearch;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 6, 7, 1, 2, 3, 4, 5 };
        int[] targets = { 2, 6, 5, 9 };
        for (int target : targets) {
            int index = searchRotatedArray(arr, target);
            System.out.println("Found index at: " + index);
        }
    }

    // Assumes all elements are distinct.
    public static int searchRotatedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            // left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

                // right half is sorted
            } else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }
        return -1;
    }

}
