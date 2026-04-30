import java.util.*;

public class FCFS_NoArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];  // Burst Time
        int[] wt = new int[n];  // Waiting Time
        int[] tat = new int[n]; // Turnaround Time

        System.out.println("Enter Burst Times:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        wt[0] = 0;

        // Calculate Waiting Time
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        // Calculate Turnaround Time
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

        // Output
        System.out.println("Process\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}
