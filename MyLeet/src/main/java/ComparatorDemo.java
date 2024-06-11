import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorDemo {
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 4, 2, 1, 7};

        // Define the position map
        Map<Integer, Integer> positionMap = new HashMap<>();
        positionMap.put(3, 1);
        positionMap.put(8, 2);
        positionMap.put(2, 3);

        // Define the custom comparator
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

        // Sort the array using the custom comparator
        Arrays.sort(numbers, customComparator);

        // Print the sorted array
        System.out.println(Arrays.toString(numbers)); // Output will depend on the positionMap and the array
    }
}
