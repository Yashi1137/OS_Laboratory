import java.util.*;

class Paging {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input page size
        System.out.print("Enter page size: ");
        int pageSize = sc.nextInt();

        // Input number of pages
        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        int pageTable[] = new int[n];

        // Input page table
        System.out.println("Enter frame numbers for each page:");
        for (int i = 0; i < n; i++) {
            pageTable[i] = sc.nextInt();
        }

        // Input logical address
        System.out.print("Enter logical address: ");
        int logicalAddress = sc.nextInt();

        // Step 1: Find page number
        int pageNumber = logicalAddress / pageSize;

        // Step 2: Find offset
        int offset = logicalAddress % pageSize;

        // Check for valid page number
        if (pageNumber >= n) {
            System.out.println("Invalid logical address!");
            return;
        }

        // Step 3: Find frame number
        int frameNumber = pageTable[pageNumber];

        // Step 4: Physical address
        int physicalAddress = frameNumber * pageSize + offset;

        // Output
        System.out.println("Page Number: " + pageNumber);
        System.out.println("Offset: " + offset);
        System.out.println("Frame Number: " + frameNumber);
        System.out.println("Physical Address: " + physicalAddress);
    }
}
