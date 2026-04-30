import java.util.*;

public class FCFS_NoArrival_CT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];  // Burst Time
        int[] ct = new int[n];  // Completion Time
        int[] wt = new int[n];  // Waiting Time
        int[] tat = new int[n]; // Turnaround Time

        System.out.println("Enter Burst Times:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        // Calculate Completion Time
        ct[0] = bt[0];
        for (int i = 1; i < n; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }

        // Calculate TAT and WT
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i];          // since AT = 0
            wt[i] = tat[i] - bt[i];
        }

        // Output
        System.out.println("Process\tBT\tCT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i+1) + "\t" + bt[i] + "\t" + ct[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}
