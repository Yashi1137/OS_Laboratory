import java.util.*;

public class SSTF_Disk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];
        boolean[] visited = new boolean[n];

        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        int seekCount = 0;

        System.out.print("\nSeek Sequence: " + head);

        for (int i = 0; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(req[j] - head);
                    if (dist < minDist) {
                        minDist = dist;
                        index = j;
                    }
                }
            }

            visited[index] = true;
            seekCount += minDist;
            head = req[index];

            System.out.print(" -> " + head);
        }

        System.out.println("\nTotal Seek Operations: " + seekCount);
        sc.close();
    }
}