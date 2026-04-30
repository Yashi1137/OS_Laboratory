import java.util.*;

class SJF_NonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] at = new int[n];
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        boolean[] done = new boolean[n];

        System.out.println("Enter Arrival Time:");
        for (int i = 0; i < n; i++)
            at[i] = sc.nextInt();

        System.out.println("Enter Burst Time:");
        for (int i = 0; i < n; i++)
            bt[i] = sc.nextInt();

        int time = 0, completed = 0;

        while (completed < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && !done[i] && bt[i] < minBT) {
                    minBT = bt[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
            } else {
                wt[idx] = time - at[idx];
                time += bt[idx];
                tat[idx] = wt[idx] + bt[idx];
                done[idx] = true;
                completed++;
            }
        }

        System.out.println("\nP\tAT\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + "\t" + at[i] + "\t" + bt[i] + "\t" +
                               wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}
