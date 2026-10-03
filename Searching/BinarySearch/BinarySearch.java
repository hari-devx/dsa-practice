package Searching.BinarySearch;

public class BinarySearch {
    public static void main(String args[]) {
        System.out.println();
        System.out.println("Binary Search : ");
        System.out.println();

        // Array MUST be sorted in ascending order for binary search to work.
        int[] num = { 10, 20, 30, 40, 50, 80, 100, 102, 150 };
        // Value we are looking for.
        int target = 2;
        // Left end of the search range (inclusive).
        int low = 0;
        // Right end of the search range (inclusive), so the range is [low, high].
        int high = num.length - 1;
        // Step counter, only used to print how many steps the search takes.
        int i = 0;
        // Flag to check whether the element was found in the array or not.
        boolean isFound = false;
        // Time: O(log n) - the search range is halved on every step.
        // Space: O(1) - only a few index variables are used.
        // Keep searching while the range [low, high] has at least one element.
        while (low <= high) {
            // Print the current step number, then increase it.
            System.out.printf("Step %d%n", i++);
            // Find the mid value: the middle index of the current range.
            // Note: (low + high) can overflow int for very large arrays;
            // low + (high - low) / 2 gives the same mid without overflowing.
            int mid = (low + high) / 2;
            // System.err.printf("Mid : %d%n", mid);
            // Check whether the mid value is equal to the target value.
            if (num[mid] == target) {
                // Target found at index mid.
                System.out.printf("Found : Element %d at index of %d%n", target, mid);
                // Remember that we found it, so the "not found" message is skipped.
                isFound = true;
                // Stop searching.
                break;
            } else if (target < num[mid]) {
                // If the target value is less than mid value, decrease the high value.
                // The array is sorted, so the target can only be on the left of mid.
                // mid itself is already checked, so it is excluded with - 1.

                high = mid - 1;
            } else {
                // If the target value is greater than mid value, increase the low value.
                // The array is sorted, so the target can only be on the right of mid.
                // mid itself is already checked, so it is excluded with + 1.

                low = mid + 1;
            }
        }
        // The loop ended because low passed high (empty range) without a match.
        if (!isFound) {
            // If the target value was not found, print this statement.
            System.err.printf("Element %d was not found in this array", target);
        }

    }
}
