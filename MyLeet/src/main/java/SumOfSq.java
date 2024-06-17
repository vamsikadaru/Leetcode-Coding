public class SumOfSq {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SumOfSq solution = new SumOfSq();

        // Example 1
        int c1 = 5;
        System.out.println(solution.judgeSquareSum(c1));  // Output: true

        // Example 2
        int c2 = 3;
        System.out.println(solution.judgeSquareSum(c2));  // Output: false
    }
}
/*
To determine if there are two integers aa and bb such that a2+b2=ca2+b2=c, we can use a two-pointer technique. This approach involves iterating over possible values for aa and bb to check if their squares sum up to cc.

Here’s the step-by-step approach:

    1. Initialize two pointers: one starting from a=0 and the other from b=sqrt(c)
    2. Use a while loop to adjust a and b based on the comparison of a2+b2 with c.
    3. If a2+b2=c, return true.
    4. If a2+b2<c, increment a to increase the sum.
    5, If a2+b2>c, decrement b to decrease the sum.
    6. If the two pointers cross each other, return false as no such pair (a,b)(a,b) was found.
 */