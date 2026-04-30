import java.util.*;

public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int[] pages = new int[n];
        System.out.println("Enter page reference string:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int capacity = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        int pageFaults = 0;

        for (int page : pages) {
            if (!set.contains(page)) {
                pageFaults++;

                if (queue.size() == capacity) {
                    int removed = queue.poll();
                    set.remove(removed);
                }

                queue.add(page);
                set.add(page);
            }

            System.out.println("Frames: " + queue);
        }

        System.out.println("Total Page Faults (FIFO): " + pageFaults);
    }
}
