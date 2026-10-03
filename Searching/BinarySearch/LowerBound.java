package Searching.BinarySearch;

public class LowerBound {
    public static void main(String[] args) {
        // Sorted array (duplicates allowed).
        int[] arr = { 1, 2, 3, 3, 3, 4, 5 };
        // We want the first index whose value is >= target.
        // 64 is bigger than every element, so the answer is arr.length (7).
        int target = 64;
        // Left end of the search range (inclusive).
        int lb = 0;
        // Right end (exclusive), so the range is [lb, ub).
        // Starting at arr.length allows "no element >= target" to return arr.length.
        int ub = arr.length;
        // Lower bound index: also the insert position that keeps the array sorted,
        // and the count of elements smaller than target.
        int result = lowerBound(lb, ub, arr, target);
        System.out.println(result);

    }

    // Time: O(log n) - the range [lb, ub) is halved on every step.
    // Space: O(1)
    public static int lowerBound(int lb, int ub, int[] arr, int target) {
        // The array splits into [ values < target | values >= target ].
        // Loop until lb == ub, which is the boundary between the two parts.
        while (lb < ub) {
            // Middle index without int overflow.
            int mid = lb + (ub - lb) / 2;
            // mid is in the ">= target" part, so the answer is mid or to its left.
            if (arr[mid] >= target) {
                // Keep mid in the range because it might be the first such index.
                ub = mid;
            } else {
                // mid is in the "< target" part, so the answer is right of mid.
                lb = mid + 1;
            }
        }
        // First index whose value is >= target (arr.length if none).
        return lb;
    }
}
