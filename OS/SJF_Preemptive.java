import java.util.*;

class ProcessP {
    int id, at, bt, rt, ct, tat, wt;
}

public class SJF_Preemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        ProcessP[] p = new ProcessP[n];

        for (int i = 0; i < n; i++) {
            p[i] = new ProcessP();
            p[i].id = i;
            System.out.print("Enter AT and BT for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
            p[i].rt = p[i].bt;
        }

        int time = 0, completed = 0;

        while (completed < n) {
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
            } else {
                p[idx].rt--;
                time++;

                if (p[idx].rt == 0) {
                    p[idx].ct = time;
                    p[idx].tat = p[idx].ct - p[idx].at;
                    p[idx].wt = p[idx].tat - p[idx].bt;
                    completed++;
                }
            }
        }

        System.out.println("\nP\tAT\tBT\tCT\tTAT\tWT");
        for (ProcessP x : p) {
            System.out.println("P" + x.id + "\t" + x.at + "\t" + x.bt +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);
        }

        sc.close();
    }
}