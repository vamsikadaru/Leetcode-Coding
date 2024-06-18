import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Pair jobs with their profits and sort by difficulty
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // Sort workers by their abilities
        Arrays.sort(worker);

        int maxProfit = 0, totalProfit = 0, jobIndex = 0;

        // For each worker, find the maximum profit job they can do
        for (int ability : worker) {
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork sol = new MostProfitAssigningWork();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};

        System.out.println(sol.maxProfitAssignment(difficulty, profit, worker));  // Output: 100

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};

        System.out.println(sol.maxProfitAssignment(difficulty2, profit2, worker2));  // Output: 0
    }
}
