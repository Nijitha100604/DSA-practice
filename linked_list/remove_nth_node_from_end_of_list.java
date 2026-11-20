package linked_list;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1] 
*/

public class remove_nth_node_from_end_of_list {

    public static class ListNode{
        int val;
        ListNode next;
        
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i=1; i<=n; i++){
            second = second.next;
        }

        while(second.next != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

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

        head = removeNthFromEnd(head, 3);
        display(head);
    }
}
