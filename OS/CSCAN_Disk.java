import java.util.*;

public class CSCAN_Disk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        int[] req = new int[n];
        System.out.println("Enter request sequence:");
        for (int i = 0; i < n; i++) {
            req[i] = sc.nextInt();
        }

        System.out.print("Enter initial head position: ");
        int head = sc.nextInt();

        System.out.print("Enter disk size: ");
        int diskSize = sc.nextInt();

        Arrays.sort(req);

        int seekCount = 0;
        List<Integer> sequence = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (req[i] >= head) {
                index = i;
                break;
            }
        }

        // Move right
        for (int i = index; i < n; i++) {
            sequence.add(req[i]);
        }

        // Go to end
        sequence.add(diskSize - 1);

        // Jump to start
        sequence.add(0);

        // Continue from start
        for (int i = 0; i < index; i++) {
            sequence.add(req[i]);
        }

        System.out.print("\nSeek Sequence: " + head);

        for (int track : sequence) {
            seekCount += Math.abs(track - head);
            head = track;
            System.out.print(" -> " + head);
        }

        System.out.println("\nTotal Seek Operations: " + seekCount);
        sc.close();
    }
}