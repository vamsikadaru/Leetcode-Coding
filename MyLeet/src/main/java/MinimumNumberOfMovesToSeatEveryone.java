/*class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n=seats.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += Math.abs(seats[i]-students[i]);
        }
        return sum;
    }
}*/
import java.util.*;

public class MinimumNumberOfMovesToSeatEveryone {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Create a map to store the position of each element in arr2
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            positionMap.put(arr2[i], i);
        }

        // Step 2: Define a custom comparator
        Comparator<Integer> customComparator = (a, b) -> {
            if (positionMap.containsKey(a) && positionMap.containsKey(b)) {
                return Integer.compare(positionMap.get(a), positionMap.get(b));
            } else if (positionMap.containsKey(a)) {
                return -1;
            } else if (positionMap.containsKey(b)) {
                return 1;
            } else {
                return Integer.compare(a, b);
            }
        };

        // Step 3: Sort arr1 using the custom comparator
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, customComparator);

        // Convert the sorted Integer array back to an int array
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Integer[i];
        }

        return arr1;
    }

    public static void main(String[] args) {
        MinimumNumberOfMovesToSeatEveryone solution = new MinimumNumberOfMovesToSeatEveryone();

        // Test cases
        int[] arr1_1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2_1 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1_1, arr2_1))); // Output: [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]

        int[] arr1_2 = {28, 6, 22, 8, 44, 17};
        int[] arr2_2 = {22, 28, 8, 6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1_2, arr2_2))); // Output: [22, 28, 8, 6, 17, 44]
    }
}
