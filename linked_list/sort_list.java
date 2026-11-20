package linked_list;

/* 
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:

Input: head = []
Output: []
*/

public class sort_list {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ptr.next = l1;
                l1 = l1.next;
            } else{
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if(l1 != null)
            ptr.next = l1;

        if(l2 != null)
            ptr.next = l2;

        return dummy.next;
    }

    public static void display(ListNode head) {

        ListNode curr = head;

        while(curr != null) {
            System.out.print(curr.val);

            if(curr.next != null)
                System.out.print(" -> ");

            curr = curr.next;
        }

        System.out.println(" -> null");
    }

    public static void main(String[] args) {

        // Example 1: [4,2,1,3]

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);

        System.out.println("Original List 1:");
        display(head1);

        head1 = sortList(head1);

        System.out.println("Sorted List 1:");
        display(head1);


        // Example 2: [-1,5,3,4,0]

        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        System.out.println("\nOriginal List 2:");
        display(head2);

        head2 = sortList(head2);

        System.out.println("Sorted List 2:");
        display(head2);
    }
}
