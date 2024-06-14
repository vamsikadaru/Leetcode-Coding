import java.util.Arrays;

public class MinIncrementToMakeArUnq {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array first
        int moves = 0;

        // Start from the second element and ensure each element is greater than the previous one
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
                moves += increment;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        MinIncrementToMakeArUnq sol = new MinIncrementToMakeArUnq();
        int[] nums = {3, 2, 1, 2, 1, 7};
        System.out.println(sol.minIncrementForUnique(nums)); // Output: 6
    }
}

