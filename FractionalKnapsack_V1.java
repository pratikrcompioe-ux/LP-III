import java.util.*;

// Class to represent each item
class KnapsackItem {
    int value, weight;
    double ratio;

    KnapsackItem(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack_V1 {

    // Method to calculate max value using Greedy method
    static double getMaxValue(KnapsackItem[] items, int capacity) {
        // Sort items by descending ratio (value/weight)
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        double remainingCapacity = capacity;

        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Item\tValue\tWeight\tRatio\tTaken\tRemainingCap\tTotalValue");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < items.length; i++) {
            if (remainingCapacity <= 0) break;

            KnapsackItem item = items[i];

            if (item.weight <= remainingCapacity) {
                // Take the full item
                remainingCapacity -= item.weight;
                totalValue += item.value;

                System.out.printf("%d\t%d\t%d\t%.2f\tFULL\t%.2f\t\t%.2f\n",
                        i + 1, item.value, item.weight, item.ratio,
                        remainingCapacity, totalValue);
            } else {
                // Take fractional part
                double fraction = remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                System.out.printf("%d\t%d\t%d\t%.2f\t%.2f%%\t%.2f\t\t%.2f\n",
                        i + 1, item.value, item.weight, item.ratio,
                        fraction * 100, 0.0, totalValue);
                remainingCapacity = 0;
            }
        }

        System.out.println("--------------------------------------------------------------");
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        KnapsackItem[] items = new KnapsackItem[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            items[i] = new KnapsackItem(value, weight);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(items, capacity);

        System.out.printf("\nMaximum value obtainable = %.2f\n", maxValue);
        sc.close();
    }
}