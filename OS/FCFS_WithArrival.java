import java.util.*;

class P1 {
    int id, at, bt, ct, tat, wt;
}

public class FCFS_WithArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        P1[] p = new P1[n];

        for (int i = 0; i < n; i++) {
            p[i] = new P1();
            p[i].id = i;
            System.out.print("AT BT for P" + i + ": ");
            p[i].at = sc.nextInt();
            p[i].bt = sc.nextInt();
        }

        Arrays.sort(p, Comparator.comparingInt(x -> x.at));

        int time = 0;

        for (int i = 0; i < n; i++) {
            if (time < p[i].at) {
                time = p[i].at;
            }

            time += p[i].bt;
            p[i].ct = time;
            p[i].tat = p[i].ct - p[i].at;
            p[i].wt = p[i].tat - p[i].bt;
        }

        System.out.println("\nP\tAT\tBT\tCT\tTAT\tWT");
        for (P1 x : p) {
            System.out.println("P" + x.id + "\t" + x.at + "\t" + x.bt +
                    "\t" + x.ct + "\t" + x.tat + "\t" + x.wt);
        }

        sc.close();
    }
}