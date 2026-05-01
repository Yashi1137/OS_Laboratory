import java.util.*;

class Process {
    int id, bt, rt, ct, tat, wt;
}

public class RR_Without_Arrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            p[i].id = i + 1;

            System.out.print("Burst Time of P" + p[i].id + ": ");
            p[i].bt = sc.nextInt();

            p[i].rt = p[i].bt;
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        int time = 0, completed = 0;
        Queue<Process> q = new LinkedList<>();

        // initially all are ready
        for (int i = 0; i < n; i++) {
            q.add(p[i]);
        }

        while (completed < n) {
            Process curr = q.poll();

            int execTime = Math.min(tq, curr.rt);
            curr.rt -= execTime;
            time += execTime;

            if (curr.rt > 0) {
                q.add(curr);
            } else {
                curr.ct = time;
                completed++;
            }
        }

        // calculate TAT and WT
        for (Process pr : p) {
            pr.tat = pr.ct;       // AT = 0
            pr.wt = pr.tat - pr.bt;
        }

        // output
        System.out.println("\nP\tBT\tCT\tTAT\tWT");
        for (Process pr : p) {
            System.out.println("P" + pr.id + "\t" + pr.bt + "\t" +
                    pr.ct + "\t" + pr.tat + "\t" + pr.wt);
        }

        sc.close();
    }
}
