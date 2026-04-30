import java.util.*;

public class Optimal {
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

        List<Integer> frames = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < n; i++) {
            int page = pages[i];

            if (!frames.contains(page)) {
                pageFaults++;

                if (frames.size() < capacity) {
                    frames.add(page);
                } else {
                    int farthest = i;
                    int index = -1;

                    for (int j = 0; j < frames.size(); j++) {
                        int k;
                        for (k = i + 1; k < n; k++) {
                            if (frames.get(j) == pages[k])
                                break;
                        }

                        if (k > farthest) {
                            farthest = k;
                            index = j;
                        }
                    }

                    if (index == -1)
                        frames.set(0, page);
                    else
                        frames.set(index, page);
                }
            }

            System.out.println("Frames: " + frames);
        }

        System.out.println("Total Page Faults (Optimal): " + pageFaults);
    }
}
