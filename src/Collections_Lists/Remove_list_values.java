package Collections_Lists;

import java.util.Scanner;


public class Remove_list_values {
    public static ListNode removeAllOccurrences(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == target) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
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
        System.out.print("Enter number of elements in the linked list: ");
        int n = scanner.nextInt();
        System.out.println("Enter elements:");
        ListNode head = createListFromInput(scanner, n);
        System.out.print("Enter the value to remove: ");
        int target = scanner.nextInt();
        head = removeAllOccurrences(head, target);
        System.out.println("Updated Linked List:");
        printList(head);
        scanner.close();
    }
}
