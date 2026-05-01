import java.util.*;

class Proc {
    int id, at, bt, pr, ct, tat, wt;
}

public class PriorityNonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Proc[] p = new Proc[n];

        // Input
        for (int i = 0; i < n; i++) {
            p[i] = new Proc();
            p[i].id = i;

            System.out.print("Enter AT BT Priority for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
            p[i].pr = sc.nextInt();
        }

        int time = 0, completed = 0;
        boolean[] done = new boolean[n];
        List<Integer> order = new ArrayList<>();

        while (completed < n) {
            int idx = -1;
            int minPr = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!done[i] && p[i].at <= time) {

                    if (idx == -1 || 
                        p[i].pr < minPr || 
                        (p[i].pr == minPr && p[i].at < p[idx].at)) {
                        
                        minPr = p[i].pr;
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                time++; // CPU idle
            } else {
                order.add(idx);

                time += p[idx].bt;
                p[idx].ct = time;
                p[idx].tat = p[idx].ct - p[idx].at;
                p[idx].wt = p[idx].tat - p[idx].bt;

                done[idx] = true;
                completed++;
            }
        }

        // 🔹 Execution Order
        System.out.print("\nExecution Order: ");
        for (int i = 0; i < order.size(); i++) {
            System.out.print("P" + order.get(i));
            if (i != order.size() - 1) System.out.print(" -> ");
        }

        // 🔹 Table Output
        System.out.println("\n\nP\tAT\tBT\tPR\tCT\tTAT\tWT");

        double totalTAT = 0, totalWT = 0;

        for (Proc x : p) {
            System.out.println("P" + x.id + "\t" + x.at + "\t" + x.bt + "\t" + x.pr +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);

            totalTAT += x.tat;
            totalWT += x.wt;
        }

        // 🔹 Averages
        System.out.println("\nAverage TAT = " + (totalTAT / n));
        System.out.println("Average WT  = " + (totalWT / n));

        sc.close();
    }
}
