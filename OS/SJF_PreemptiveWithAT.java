import java.util.*;

class Process {
    int id, at, bt, rt, ct, tat, wt;
}

public class SJF_Preemptive_WithAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            p[i].id = i + 1;

            System.out.print("Enter AT and BT for P" + (i + 1) + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
            p[i].rt = p[i].bt; // remaining time
        }

        int time = 0, completed = 0;

        while (completed != n) {
            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (p[i].at <= time && p[i].rt > 0 && p[i].rt < minRT) {
                    minRT = p[i].rt;
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
                continue;
            }

            p[idx].rt--;
            time++;

            if (p[idx].rt == 0) {
                completed++;
                p[idx].ct = time;
                p[idx].tat = p[idx].ct - p[idx].at;
                p[idx].wt = p[idx].tat - p[idx].bt;
            }
        }

        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (Process pr : p) {
            System.out.println(pr.id + "\t" + pr.at + "\t" + pr.bt + "\t" +
                               pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }
    }
}
