package Searching.BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        // We want the first index whose value is STRICTLY > target.
        int target = 4;
        // Sorted array (duplicates allowed). Answer here is 6 (arr[6] = 5).
        int[] arr = { 1, 2, 3, 4, 4, 4, 5, 6 };
        // Left end of the search range (inclusive).
        int low=0;
        // Right end (exclusive), so the range is [low, high).
        // Starting at arr.length allows "no element > target" to return arr.length.
        int high=arr.length;
        // Upper bound index: also the count of elements <= target.
        // upperBound - 1 is the last occurrence; upperBound - lowerBound is the count of target.
        int result = upperbound(low,high,arr,target);
        System.out.println(result);
    }

    // Time: O(log n) - the range [low, high) is halved on every step.
    // Space: O(1)
    public static int upperbound(int low, int high, int[] arr, int target) {
        // The array splits into [ values <= target | values > target ].
        // Loop until low == high, which is the boundary between the two parts.
        while(low<high){
            // Middle index without int overflow.
            int mid=low+(high-low)/2;
            // mid is in the "> target" part, so the answer is mid or to its left.
            // (The only difference from lowerBound is > instead of >=.)
            if(arr[mid]>target){
                // Keep mid in the range because it might be the first such index.
                high=mid;
            }else{
                // mid is <= target, so the answer is right of mid.
                low=mid+1;
            }
        }
        // First index whose value is > target (arr.length if none).
        return low;
    }
}
