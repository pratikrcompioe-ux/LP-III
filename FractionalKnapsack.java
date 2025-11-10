import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Class representing each item
class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Method to get maximum value in knapsack
    static double getMaxValue(Item[] items, int capacity) {
        // Sort items by descending value/weight ratio
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                if (r1 < r2) return 1;
                else if (r1 > r2) return -1;
                else return 0;
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity - item.weight >= 0) {
                // Take whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fraction of remaining capacity
                double fraction = ((double) capacity / item.weight);
                totalValue += (item.value * fraction);
                capacity = 0;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        double maxValue = getMaxValue(items, capacity);

        System.out.println("\nMaximum value we can obtain = " + maxValue);

        sc.close();
    }
}