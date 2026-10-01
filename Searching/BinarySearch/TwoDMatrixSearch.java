package Searching.BinarySearch;

public class TwoDMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int[] targets = { 16, 1, 60, 13 };
        for (int target : targets) {
            boolean isFound = searchInTwoDMatrix(matrix, target);
            System.out.println(target + " found: " + isFound);
        }
    }

    /*
     * Searches a matrix with binary search in O(log(rows * cols)) time, O(1) space.
     *
     * Assumes: each row is sorted, and the first value of each row is greater
     * than the last value of the previous row.
     *
     * Idea: because of that, reading the matrix row by row gives one fully
     * sorted list. We never build that list; we just pretend it exists and
     * binary search over the indices 0 .. rows * cols - 1.
     * Example: { {1,2,3,7}, {10,11,16,20}, {23,30,34,60} }
     * behaves like [1,2,3,7,10,11,16,20,23,30,34,60].
     */
    public static boolean searchInTwoDMatrix(int[][] matrix, int target) {
        // Nothing to search in a null, empty, or zero-column matrix.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Search range over the imaginary flattened array.
        int low = 0;
        int high = (rows * cols) - 1;

        while (low <= high) {
            // low + (high - low) / 2 avoids int overflow of (low + high) / 2.
            int mid = low + (high - low) / 2;

            // Convert the flat index back to matrix coordinates:
            // row = how many full rows fit before mid, col = leftover position.
            // Example: mid = 6, cols = 4 -> row 1, col 2.
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // Middle is too small, so target can only be to the right.
                low = mid + 1;
            } else {
                // Middle is too big, so target can only be to the left.
                high = mid - 1;
            }
        }
        // Range became empty without a match.
        return false;
    }
}
