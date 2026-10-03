package Searching;

public class LinearSearch {
    public static void main(String args[]) {
        System.out.println();
        System.out.println("Linear Search : ");
        System.out.println();

        // Array to search in. Linear search works on sorted AND unsorted arrays.
        int[] num = { 10, 20, 30, 40, 50 };
        // Value we are looking for.
        int target = 20;
        // Time: O(n) - every element is checked once in the worst case.
        // Space: O(1) - only the loop index is used.
        // Visit every index from left to right.
        for (int i = 0; i < num.length; i++) {
            // Compare the current element with the target.
            if (num[i] == target) {
            // Match: print the value and its index. There is no break, so the
            // loop continues and prints every index where the target appears.
            System.out.printf("Found : %d at %d%n",num[i],i);
           }
        }

    }
}
