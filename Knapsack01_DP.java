import java.util.Scanner;

public class Knapsack01_DP {

    // Function to solve 0/1 Knapsack problem using DP
    public static int knapsack(int[] values, int[] weights, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Print the DP table
        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                System.out.printf("%4d", dp[i][w]);
            }
            System.out.println();
        }

        // Return the last cell of table which is the answer
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            values[i] = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        int maxValue = knapsack(values, weights, capacity, n);

        System.out.println("\nMaximum value obtainable = " + maxValue);
        sc.close();
    }
}
