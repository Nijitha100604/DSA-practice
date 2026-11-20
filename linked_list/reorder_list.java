package linked_list;

/*

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

*/

public class reorder_list {
    
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        // middle element
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        ListNode temp;
        while(second != null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        return;
    }

    public static void display(ListNode head){

        ListNode curr = head;

        while(curr != null){
            System.out.print(curr.val);

            if(curr.next != null)
                System.out.print(" -> ");

            curr = curr.next;
        }

        System.out.println(" -> null");
    }

    public static void main(String[] args){

        // Example 1: head = [1,2,3,4]

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.println("Example 1 - Original List:");
        display(head1);

        reorderList(head1);

        System.out.println("Example 1 - Reordered List:");
        display(head1);


        // Example 2: head = [1,2,3,4,5]

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("\nExample 2 - Original List:");
        display(head2);

        reorderList(head2);

        System.out.println("Example 2 - Reordered List:");
        display(head2);
    }

}
