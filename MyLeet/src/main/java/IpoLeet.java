import java.util.*;

class IpoLeet {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Create a list of projects with their capital requirements and profits
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort the projects by their capital requirements
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));

        // Min-heap to manage the capital requirements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Max-heap to manage the profits of the projects we can afford
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Current capital
        int currentCapital = w;
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {
            // Add all projects that can be afforded with the current capital to the max-heap
            while (projectIndex < n && projects[projectIndex][0] <= currentCapital) {
                maxHeap.add(projects[projectIndex]);
                projectIndex++;
            }

            // If there are no affordable projects, break
            if (maxHeap.isEmpty()) {
                break;
            }

            // Pop the most profitable project from the max-heap
            currentCapital += maxHeap.poll()[1];
        }

        return currentCapital;
    }

    public static void main(String[] args) {
        IpoLeet solution = new IpoLeet();

        // Example 1
        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k1, w1, profits1, capital1));  // Output: 4

        // Example 2
        int k2 = 3;
        int w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        System.out.println(solution.findMaximizedCapital(k2, w2, profits2, capital2));  // Output: 6
    }
}
