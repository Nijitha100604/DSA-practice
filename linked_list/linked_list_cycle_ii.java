package linked_list;

/* 

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.


Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.

*/

public class linked_list_cycle_ii {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                fast = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args){
        // Example 1: head = [3,2,0,-4], pos = 1

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        // Connect last node to node at index 1
        head1.next.next.next.next = head1.next;

        ListNode result1 = detectCycle(head1);

        if(result1 != null)
            System.out.println("Example 1: Cycle starts at node " + result1.val);
        else
            System.out.println("Example 1: No cycle");

        // Example 2: head = [1,2], pos = 0

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        // Connect last node to head (index 0)
        head2.next.next = head2;

        ListNode result2 = detectCycle(head2);

        if(result2 != null)
            System.out.println("Example 2: Cycle starts at node " + result2.val);
        else
            System.out.println("Example 2: No cycle");


        // Example 3: head = [1], pos = -1

        ListNode head3 = new ListNode(1);

        // No cycle

        ListNode result3 = detectCycle(head3);

        if(result3 != null)
            System.out.println("Example 3: Cycle starts at node " + result3.val);
        else
            System.out.println("Example 3: No cycle");
        }
}
