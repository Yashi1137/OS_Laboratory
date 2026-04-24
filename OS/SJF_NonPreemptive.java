import java.util.*;

class ProcessNP {
    int id, at, bt, ct, tat, wt;
}

public class SJF_NonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        ProcessNP[] p = new ProcessNP[n];
        boolean[] done = new boolean[n];

        for (int i = 0; i < n; i++) {
            p[i] = new ProcessNP();
            p[i].id = i;
            System.out.print("Enter AT and BT for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
        }

        int time = 0, completed = 0;

        while (completed < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && p[i].at <= time && p[i].bt < minBT) {
                    minBT = p[i].bt;
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
            } else {
                time += p[idx].bt;
                p[idx].ct = time;
                p[idx].tat = p[idx].ct - p[idx].at;
                p[idx].wt = p[idx].tat - p[idx].bt;

                done[idx] = true;
                completed++;
            }
        }

        System.out.println("\nP\tAT\tBT\tCT\tTAT\tWT");
        for (ProcessNP x : p) {
            System.out.println("P" + x.id + "\t" + x.at + "\t" + x.bt +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);
        }

        sc.close();
    }
}