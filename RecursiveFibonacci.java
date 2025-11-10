// PR-1 : Recursive
import java.util.Scanner;

public class RecursiveFibonacci {

	static int fibonacci(int n) {
		if (n <= 1) {
			return n; // base case
		}
		return fibonacci(n - 1) + fibonacci(n - 2); // recursive call
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of terms : ");
		int n = sc.nextInt();
		
		System.out.println("Fibonacci Series : ");
		for (int i = 0; i < n; i++)
		{
			System.out.print(fibonacci(i) + " ");
		}
		
		sc.close();
	}

}
