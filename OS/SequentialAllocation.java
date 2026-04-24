import java.util.*;

public class SequentialAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        int[] start = new int[n];
        int[] length = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter starting block of file " + (i + 1) + ": ");
            start[i] = sc.nextInt();

            System.out.print("Enter length of file " + (i + 1) + ": ");
            length[i] = sc.nextInt();
        }

        System.out.println("\nFile Allocation Table:");
        for (int i = 0; i < n; i++) {
            System.out.print("File " + (i + 1) + ": ");
            for (int j = 0; j < length[i]; j++) {
                System.out.print((start[i] + j) + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
