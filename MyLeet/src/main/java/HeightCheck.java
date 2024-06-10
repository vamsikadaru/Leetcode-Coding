import java.util.Arrays;

class HeightCheck {
    public int heightChecker(int[] heights) {
        // Create a sorted copy of the original heights array
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);

        int count = 0;

        // Compare the original array with the sorted array
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HeightCheck solution = new HeightCheck();

        // Test cases
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println(solution.heightChecker(heights1));  // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println(solution.heightChecker(heights2));  // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println(solution.heightChecker(heights3));  // Output: 0
    }
}
