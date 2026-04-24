import java.util.*;

public class FCFS_NoArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter Burst Times:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        ct[0] = bt[0];
        for (int i = 1; i < n; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }

        for (int i = 0; i < n; i++) {
            tat[i] = ct[i];      // AT = 0
            wt[i] = tat[i] - bt[i];
        }

        System.out.println("\nP\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + i + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        sc.close();
    }
}