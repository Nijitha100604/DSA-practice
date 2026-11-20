package linked_list;

/* 
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.


Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/

public class reverse_nodes_in_k_group {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while(true){

            ListNode kth = prevGroup;
            for(int i=0; i<k && kth != null; i++)
                kth = kth.next;

            if(kth == null)
                break;

            ListNode curr = prevGroup.next;
            ListNode nextGroup = kth.next;
            ListNode prev = nextGroup;

            while(curr != nextGroup){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
        return dummy.next; 
    }

    public static void display(ListNode head){
        if(head == null){
            System.out.println("null");
            return;
        }
        
        ListNode curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode reverse = reverseKGroup(head, k);

        display(reverse);
        
    }
}
