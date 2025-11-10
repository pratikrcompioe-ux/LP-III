// PR-1 : Non-Recursive
import java.util.Scanner;
public class NonRecursiveFibonacci {
	
	static void fibonacci(int n) {
		int a = 0, b = 1, c;
		
		if (n <= 0) {
			System.out.println("Please enter a positive integer..");
			return;
		}
		
		System.out.println("Fibonacci Series : ");
		
		if (n == 1) {
			System.out.print(a);
			return;
		}
		
		System.out.print(a + " " + b + " ");
		
		for (int i = 2; i < n; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of terms : ");
		int n = sc.nextInt();

		fibonacci(n);
		
		sc.close();
	}

}
