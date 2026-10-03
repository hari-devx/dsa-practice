package Searching.BinarySearch;

public class FirstOccurrence {
    public static void main(String[] args) {
        // Sorted array that can contain duplicates (4 appears three times).
        int[] arr = { 1, 2, 3, 4, 4, 4, 5 };
        // Value whose FIRST (leftmost) index we want.
        int target = 6;
        // Left end of the search range (inclusive).
        int low = 0;
        // Right end is arr.length (exclusive), so the range is [low, high).
        // Using arr.length lets the search land "after the last element".
        int high = arr.length;
        // Index of the first occurrence, or -1 if target is not in the array.
        int result = firstOccurrence(arr,target,low,high);
        System.out.println(result);
    }

    // Time: O(log n) - the range [low, high) is halved on every step.
    // Space: O(1)
     static int firstOccurrence(int[] arr, int target, int low, int high) {
         // Half-open range: stop when low == high (range is empty).
         // At that point low is the first index with arr[low] >= target (lower bound).
         while (low < high) {
             // Middle index; written this way to avoid int overflow of (low + high).
             int mid = low + (high - low) / 2;
             // mid is target or bigger, so the first occurrence is at mid or to its left.
             if (arr[mid] >= target) {
                 // Keep mid in the range (it might be the answer), so high = mid, not mid - 1.
                 // Even on a match we keep going left to find the FIRST one.
                 high = mid;
             } else {
                 // mid is smaller than target, so mid and everything left of it are not the answer.
                 low = mid + 1;
             }
         }
         // low can be arr.length when every element is smaller than target, so check bounds first.
         // If the value at low equals target, low is its first occurrence.
         if (low < arr.length && arr[low] == target) {
             return low;
         }
         // Otherwise the target is not in the array.
         return -1;

    }
}
