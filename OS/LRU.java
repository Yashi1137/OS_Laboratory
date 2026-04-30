import java.util.*;

public class LRU {
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

        List<Integer> list = new ArrayList<>();
        int pageFaults = 0;

        for (int page : pages) {
            if (!list.contains(page)) {
                pageFaults++;

                if (list.size() == capacity) {
                    list.remove(0);
                }
            } else {
                list.remove((Integer) page);
            }

            list.add(page);
            System.out.println("Frames: " + list);
        }

        System.out.println("Total Page Faults (LRU): " + pageFaults);
    }
}
