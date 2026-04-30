import java.util.*;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of processes and resources
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of resources: ");
        int m = sc.nextInt();

        int[][] allocation = new int[n][m];
        int[][] max = new int[n][m];
        int[][] need = new int[n][m];
        int[] available = new int[m];

        // Input Allocation Matrix
        System.out.println("Enter Allocation Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                allocation[i][j] = sc.nextInt();
            }
        }

        // Input Max Matrix
        System.out.println("Enter Max Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = sc.nextInt();
            }
        }

        // Input Available Resources
        System.out.println("Enter Available Resources:");
        for (int j = 0; j < m; j++) {
            available[j] = sc.nextInt();
        }

        // Calculate Need Matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        // Safety Algorithm
        boolean[] finish = new boolean[n];
        int[] safeSequence = new int[n];
        int[] work = new int[m];

        // Initialize work = available
        for (int i = 0; i < m; i++) {
            work[i] = available[i];
        }

        int count = 0;

        while (count < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (!finish[i]) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > work[j]) {
                            break;
                        }
                    }

                    // If all needs can be satisfied
                    if (j == m) {
                        for (int k = 0; k < m; k++) {
                            work[k] += allocation[i][k];
                        }

                        safeSequence[count++] = i;
                        finish[i] = true;
                        found = true;
                    }
                }
            }

            // If no process can be allocated
            if (!found) {
                System.out.println("System is NOT in a safe state (Deadlock possible)");
                return;
            }
        }

        // Safe state
        System.out.println("System is in SAFE state");
        System.out.print("Safe sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + safeSequence[i] + " ");
        }
    }
}
