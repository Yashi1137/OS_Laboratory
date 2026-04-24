import java.util.*;

public class IndexedAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number of blocks for file " + (i + 1) + ": ");
            int blocks = sc.nextInt();

            int[] indexBlock = new int[blocks];

            System.out.println("Enter block numbers:");
            for (int j = 0; j < blocks; j++) {
                indexBlock[j] = sc.nextInt();
            }

            System.out.print("File " + (i + 1) + " Index Block: ");
            for (int j = 0; j < blocks; j++) {
                System.out.print(indexBlock[j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}