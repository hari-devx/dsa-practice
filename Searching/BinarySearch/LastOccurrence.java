package Searching.BinarySearch;

public class LastOccurrence {
    public static void main(String[] args) {
        // Sorted array that can contain duplicates (4 appears three times).
        int[] arr = { 1, 2, 3, 4, 4, 4, 5 };
        // Value whose LAST (rightmost) index we want.
        int target = 4;
        // Index of the last occurrence, or -1 if target is not in the array.
        int result = lastOccurrence(arr, target);
        System.out.println(result);
    }

    // Time: O(log n) - one upperBound call plus a constant-time check.
    // Space: O(1)
    public static int lastOccurrence(int[] arr, int target) {
        // upperBound gives the first index with a value > target.
        // All copies of target sit just before it, so step back by one.
        // Example: [1,2,3,4,4,4,5], target 4 -> upperBound = 6 -> index = 5.
        int index = upperBound(arr, target)-1;
        // index is -1 when every element is > target, so check it is valid.
        // The value there could also be smaller than target (target absent), so compare.
        if (index >= 0 && arr[index] == target) {
            return index;
        }
        // Target is not in the array.
        return -1;
    }

    // Time: O(log n) - the range [low, high) is halved on every step.
    // Space: O(1)
    public static int upperBound(int[] arr, int target) {
        // Left end of the search range (inclusive).
        int low = 0;
        // Right end (exclusive); arr.length means "no element is > target".
        int high = arr.length;
        // Stop when low == high; that index is the first value > target.
        while (low < high) {
            // Middle index without int overflow.
            int mid = low + (high - low) / 2;
            // mid is bigger than target, so the answer is mid or to its left.
            if (arr[mid] > target) {
                // Keep mid in the range because it might be the answer.
                high = mid;
            } else {
                // mid is <= target, so the answer is strictly to the right of mid.
                low = mid + 1;
            }
        }
        // First index whose value is > target.
        return low;
    }
}
