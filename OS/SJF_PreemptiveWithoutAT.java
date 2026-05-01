import java.util.*;

class Process {
    int id, bt, rt, ct, tat, wt;
}

public class SJF_Preemptive_NoAT {
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
            p[i].rt = p[i].bt;
        }

        int time = 0, completed = 0;

        while (completed != n) {
            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (p[i].rt > 0 && p[i].rt < minRT) {
                    minRT = p[i].rt;
                    idx = i;
                }
            }

            p[idx].rt--;
            time++;

            if (p[idx].rt == 0) {
                completed++;
                p[idx].ct = time;
                p[idx].tat = p[idx].ct;   // AT = 0
                p[idx].wt = p[idx].tat - p[idx].bt;
            }
        }

        System.out.println("\nPID\tBT\tCT\tTAT\tWT");
        for (Process pr : p) {
            System.out.println(pr.id + "\t" + pr.bt + "\t" +
                               pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }
    }
}
