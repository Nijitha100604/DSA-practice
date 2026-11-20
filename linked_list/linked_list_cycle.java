package linked_list;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

*/

public class linked_list_cycle {
    
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr)
                return true;
        }

        return false;
    }

    public static void main(String[] args){
    
        // Example 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        // Connect last node to node at index 1
        head1.next.next.next.next = head1.next;

        System.out.println("Example 1: " + hasCycle(head1));

        // Example 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        // Connect last node to node at index 0
        head2.next.next = head2;

        System.out.println("Example 2: " + hasCycle(head2));


        // Example 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);

        // No cycle
        System.out.println("Example 3: " + hasCycle(head3));
        }

}
