import java.util.*;

class Process {
    int id, bt, ct, tat, wt;
    boolean done;
}

public class SJF_NP_NoAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            p[i].id = i + 1;

            System.out.print("Enter BT for P" + (i + 1) + ": ");
            p[i].bt = sc.nextInt();
            p[i].done = false;
        }

        int time = 0, completed = 0;

        while (completed != n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!p[i].done && p[i].bt < minBT) {
                    minBT = p[i].bt;
                    idx = i;
                }
            }

            time += p[idx].bt;
            p[idx].ct = time;
            p[idx].tat = p[idx].ct;  // AT = 0
            p[idx].wt = p[idx].tat - p[idx].bt;

            p[idx].done = true;
            completed++;
        }

        System.out.println("\nPID\tBT\tCT\tTAT\tWT");
        for (Process pr : p) {
            System.out.println(pr.id + "\t" + pr.bt + "\t" +
                               pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }
    }
}
