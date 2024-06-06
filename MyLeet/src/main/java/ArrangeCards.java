import java.util.*;

public class ArrangeCards {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // If total cards cannot be evenly divided into groups
        }

        // Step 1: Sort the hand
        Arrays.sort(hand);

        // Step 2: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Step 3: Form groups
        for (int card : hand) {
            if (freq.get(card) == 0) {
                continue; // This card has already been used in a group
            }

            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (freq.getOrDefault(currentCard, 0) == 0) {
                    return false; // If the current card is not available
                }
                freq.put(currentCard, freq.get(currentCard) - 1); // Use the current card
            }
        }

        return true; // Successfully formed all groups
    }

    public static void main(String[] args) {
        ArrangeCards sol = new ArrangeCards();
        System.out.println(sol.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3)); // Output: true
        System.out.println(sol.isNStraightHand(new int[]{1,2,3,4,5}, 4)); // Output: false
    }
}
