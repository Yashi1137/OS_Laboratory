import java.util.*;

class SJF_P_NoCT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] at = new int[n];
        int[] bt = new int[n];
        int[] rt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        System.out.println("Enter Arrival Time:");
        for (int i = 0; i < n; i++)
            at[i] = sc.nextInt();

        System.out.println("Enter Burst Time:");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        int time = 0, completed = 0;

        while (completed < n) {
            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < minRT) {
                    minRT = rt[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
            } else {
                rt[idx]--;
                time++;

                if (rt[idx] == 0) {
                    completed++;

                    int finish = time; // internal only
                    tat[idx] = finish - at[idx];
                    wt[idx] = tat[idx] - bt[idx];
                }
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
