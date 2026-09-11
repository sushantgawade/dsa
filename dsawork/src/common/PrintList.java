package common;

public class PrintList {

    public static void display(ListNode head) {

        if(null == head) {
            return;
        }

        ListNode current  = head;

        while (current != null) {

            System.out.print(current.val + " -> ");

            current = current.next;
        }

        System.out.println("None");
    }
}
