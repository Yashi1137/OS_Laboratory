import java.util.*;

class P {
    int id, at, bt, pr, rt, ct, tat, wt;
}

public class PriorityPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        P[] p = new P[n];

        for (int i = 0; i < n; i++) {
            p[i] = new P();
            p[i].id = i;
            System.out.print("AT BT Priority for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
            p[i].pr = sc.nextInt();
            p[i].rt = p[i].bt;
        }

        int time = 0, completed = 0;

        while (completed < n) {
            int idx = -1;
            int minPr = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (p[i].at <= time && p[i].rt > 0) {
                    if (p[i].pr < minPr) {
                        minPr = p[i].pr;
                        idx = i;
                    }
                }
            }

            if (idx != -1) {
                p[idx].rt--;
                time++;

                if (p[idx].rt == 0) {
                    p[idx].ct = time;
                    p[idx].tat = p[idx].ct - p[idx].at;
                    p[idx].wt = p[idx].tat - p[idx].bt;
                    completed++;
                }
            } else {
                time++;
            }
        }

        System.out.println("\nP\tAT\tBT\tPR\tCT\tTAT\tWT");
        for (P x : p) {
            System.out.println(x.id + "\t" + x.at + "\t" + x.bt + "\t" + x.pr +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);
        }

        sc.close();
    }
}