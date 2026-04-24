import java.util.*;

public class LinkedAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of blocks for file " + (i + 1) + ": ");
            int blocks = sc.nextInt();

            int[] fileBlocks = new int[blocks];

            System.out.println("Enter block sequence:");
            for (int j = 0; j < blocks; j++) {
                fileBlocks[j] = sc.nextInt();
            }

            System.out.print("File " + (i + 1) + ": ");
            for (int j = 0; j < blocks; j++) {
                System.out.print(fileBlocks[j]);

                if (j != blocks - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}