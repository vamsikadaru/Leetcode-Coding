class PatchingArrays {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, patches = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        PatchingArrays solution = new PatchingArrays();

        // Example 1
        int[] nums1 = {1, 3};
        int n1 = 6;
        System.out.println(solution.minPatches(nums1, n1));  // Output: 1

        // Example 2
        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        System.out.println(solution.minPatches(nums2, n2));  // Output: 2

        // Example 3
        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        System.out.println(solution.minPatches(nums3, n3));  // Output: 0
    }
}
/*
To solve the problem of adding the minimum number of patches to a sorted integer array nums such that any number in the range [1, n] can be formed by the sum of some elements in the array, we can follow a greedy approach. The main idea is to iteratively ensure that we can form every number up to a certain target value using the current elements in nums and any additional patches.

Here’s a step-by-step approach:

    1. Initialize a variable miss to 1, which represents the smallest number that cannot be formed with the current set of numbers.
    2. Use a variable i to iterate through the array nums and a variable patches to count the number of patches added.
    3. While miss is less than or equal to n:
        If the current element in nums (if any) is less than or equal to miss, add this element to the range that can be formed and move to the next element in nums.
        If the current element in nums is greater than miss or if there are no more elements in nums to process, add miss as a patch to cover the current gap.
    4. Increment miss by its current value to extend the range that can be formed.

This approach ensures that the number of patches added is minimized.
 */