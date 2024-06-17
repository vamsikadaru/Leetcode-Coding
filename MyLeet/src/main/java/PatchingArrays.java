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
