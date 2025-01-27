package Collections_Lists;

import java.util.Scanner;


public class List_merger {

    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static ListNode createListFromInput(Scanner scanner, int n) {
        if (n == 0) return null;

        System.out.print("Enter value 1: ");
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter value " + i + ": ");
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in first sorted list: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter elements in sorted order:");
        ListNode l1 = createListFromInput(scanner, n1);

        System.out.print("Enter number of elements in second sorted list: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter elements in sorted order:");
        ListNode l2 = createListFromInput(scanner, n2);

        ListNode mergedList = mergeSortedLists(l1, l2);
        System.out.println("Merged Sorted List:");
        printList(mergedList);

        scanner.close();
    }
}
