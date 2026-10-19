package common;

import java.util.ArrayList;
import java.util.List;

public class PrintList {

    public static void display(ListNode head) {

        if(null == head) {
            return;
        }

        ListNode current  = head;

        while (current != null) {

            System.out.print(current.val );

            current = current.next;

            if(current != null ) {
                System.out.print( " -> ");
            }
            else {
                System.out.print(" -> None \n ");
            }
        }
    }

    public static void displayLoop(ListNode head) {

        if(null == head) {
            return;
        }

        ListNode current  = head;

        while (current != null) {

            System.out.print(current.val );

            current = current.next;

            if(current != null ) {
                System.out.print( " -> ");
            }

        }

    }

    public static int[] linkedListToArray(ListNode head) {

        if(head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        do {

            list.add(curr.val);

            curr = curr.next;
        }
        while (curr != null && curr != head);

        int[] result = new int[list.size()];

        for( int i = 0; i < list.size(); i++ ) {

            result[i] = list.get(i);
        }

        return result;

    }
}
