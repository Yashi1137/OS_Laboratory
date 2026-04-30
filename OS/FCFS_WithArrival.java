import java.util.*;

public class FCFS_WithArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];  // Burst Time
        int[] at = new int[n];  // Arrival Time
        int[] wt = new int[n];  // Waiting Time
        int[] tat = new int[n]; // Turnaround Time
        int[] p = new int[n];   // Process IDs

        System.out.println("Enter Arrival Times:");
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
            p[i] = i;
        }

        System.out.println("Enter Burst Times:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        // Sort based on arrival time
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (at[i] > at[j]) {
                    // swap arrival time
                    int temp = at[i];
                    at[i] = at[j];
                    at[j] = temp;

                    // swap burst time
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    // swap process id
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
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
        System.out.println("Process\tAT\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (p[i]+1) + "\t" + at[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}
