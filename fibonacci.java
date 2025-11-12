class FibonacciExample {
    
    // 🔹 Non-Recursive (Iterative) Fibonacci
    static void fibonacciIterative(int count) {
        int n1 = 0, n2 = 1, n3;
        System.out.print("Iterative Fibonacci Series: " + n1 + " " + n2);
        
        for (int i = 2; i < count; i++) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    // 🔹 Recursive Fibonacci Function
    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 🔹 Function to print recursive series
    static void printFibonacciRecursive(int count) {
        System.out.print("Recursive Fibonacci Series: ");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    // 🔹 Main method
    public static void main(String[] args) {
        int count = 10;

        // ✅ Call ONE of the following lines:

        //fibonacciIterative(count);          // Non-recursive version
         printFibonacciRecursive(count);  // Recursive version
    }
}
