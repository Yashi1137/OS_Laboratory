import java.util.*;

class RRProcess {
    int id, at, bt, rt, ct, tat, wt;
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        RRProcess[] p = new RRProcess[n];

        for (int i = 0; i < n; i++) {
            p[i] = new RRProcess();
            p[i].id = i;
            System.out.print("AT BT for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
            p[i].rt = p[i].bt;
        }

        Queue<Integer> q = new LinkedList<>();
        int time = 0, completed = 0;

        boolean[] inQueue = new boolean[n];

        q.add(0);
        inQueue[0] = true;

        while (completed < n) {
            int i = q.poll();

            int exec = Math.min(tq, p[i].rt);
            p[i].rt -= exec;
            time += exec;

            for (int j = 0; j < n; j++) {
                if (!inQueue[j] && p[j].at <= time) {
                    q.add(j);
                    inQueue[j] = true;
                }
            }

            if (p[i].rt > 0) {
                q.add(i);
            } else {
                p[i].ct = time;
                p[i].tat = p[i].ct - p[i].at;
                p[i].wt = p[i].tat - p[i].bt;
                completed++;
            }
        }

        System.out.println("\nP\tAT\tBT\tCT\tTAT\tWT");
        for (RRProcess x : p) {
            System.out.println(x.id + "\t" + x.at + "\t" + x.bt +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);
        }

        sc.close();
    }
}