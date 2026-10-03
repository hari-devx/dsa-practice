package Searching.BinarySearch;

public class SearchRotatedArray {
    public static void main(String[] args) {
        // Sorted array [1..7] rotated so that it starts at 6.
        int[] arr = { 6, 7, 1, 2, 3, 4, 5 };
        // Values to look up; 9 is not in the array, so it returns -1.
        int[] targets = { 2, 6, 5, 9 };
        // Search for each target and print its index.
        for (int target : targets) {
            int index = searchRotatedArray(arr, target);
            System.out.println("Found index at: " + index);
        }
    }

    // Assumes all elements are distinct.
    // Time: O(log n) - one half is always sorted, so half the range is dropped
    // on every step. (With duplicates, arr[low] == arr[mid] can hide which half
    // is sorted, and the worst case degrades to O(n).)
    // Space: O(1)
    public static int searchRotatedArray(int[] arr, int target) {
        // Left end of the search range (inclusive).
        int low = 0;
        // Right end (inclusive), so the range is [low, high] like normal binary search.
        int high = arr.length - 1;
        // Keep searching while the range has at least one element.
        while (low <= high) {
            // Middle index without int overflow.
            int mid = low + (high - low) / 2;
            // Direct hit: return the index.
            if (arr[mid] == target) {
                return mid;
            }
            // Cutting a rotated array at mid always leaves at least one half sorted.
            // left half is sorted if its first value is not bigger than mid's value.
            // (<= handles low == mid, where the left half is one element.)
            if (arr[low] <= arr[mid]) {
                // Target lies inside the sorted left half's range [arr[low], arr[mid]).
                if (arr[low] <= target && target < arr[mid]) {
                    // So search only the left half.
                    high = mid - 1;
                } else {
                    // Not in the left half, so it can only be in the right half.
                    low = mid + 1;
                }

                // right half is sorted (the rotation point is in the left half).
            } else {
                // Target lies inside the sorted right half's range (arr[mid], arr[high]].
                if (arr[mid] < target && target <= arr[high]) {
                    // So search only the right half.
                    low = mid + 1;
                } else {
                    // Not in the right half, so it can only be in the left half.
                    high = mid - 1;
                }

            }
        }
        // Range became empty without a match.
        return -1;
    }

}
