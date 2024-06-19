public class BloomDay {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1; // Not enough flowers

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, flowers = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // reset the flower count after making a bouquet
                }
            } else {
                flowers = 0; // reset if the flower has not bloomed by the day
            }
            if (bouquets >= m) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BloomDay sol = new BloomDay();
        System.out.println(sol.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1)); // Output: 3
        System.out.println(sol.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2)); // Output: -1
        System.out.println(sol.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3)); // Output: 12
    }
}
