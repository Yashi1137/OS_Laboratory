import java.util.*;

class Process {
    int id, at, bt, rt, ct, tat, wt;
}

public class RR_With_Arrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            p[i].id = i + 1;

            System.out.print("Arrival Time of P" + p[i].id + ": ");
            p[i].at = sc.nextInt();

            System.out.print("Burst Time of P" + p[i].id + ": ");
            p[i].bt = sc.nextInt();

            p[i].rt = p[i].bt; // remaining time
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        int time = 0, completed = 0;
        Queue<Process> q = new LinkedList<>();
        boolean[] inQueue = new boolean[n];

        while (completed < n) {

            // add processes to queue
            for (int i = 0; i < n; i++) {
                if (p[i].at <= time && !inQueue[i] && p[i].rt > 0) {
                    q.add(p[i]);
                    inQueue[i] = true;
                }
            }

            if (q.isEmpty()) {
                time++;
                continue;
            }

            Process curr = q.poll();

            int execTime = Math.min(tq, curr.rt);
            curr.rt -= execTime;
            time += execTime;

            // check new arrivals during execution
            for (int i = 0; i < n; i++) {
                if (p[i].at <= time && !inQueue[i] && p[i].rt > 0) {
                    q.add(p[i]);
                    inQueue[i] = true;
                }
            }

            if (curr.rt > 0) {
                q.add(curr);
            } else {
                curr.ct = time;
                completed++;
            }
        }

        // calculate TAT and WT
        for (Process pr : p) {
            pr.tat = pr.ct - pr.at;
            pr.wt = pr.tat - pr.bt;
        }

        // output
        System.out.println("\nP\tAT\tBT\tCT\tTAT\tWT");
        for (Process pr : p) {
            System.out.println("P" + pr.id + "\t" + pr.at + "\t" + pr.bt + "\t" +
                    pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }

        sc.close();
    }
}
