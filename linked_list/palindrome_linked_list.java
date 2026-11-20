package linked_list;

/* 
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false
*/

public class palindrome_linked_list {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        ListNode l1 = reverse(slow);
        ListNode l2 = head;

        while(l1 != null){
            if(l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args){
        
        // Example 1: head = [1,2,2,1]

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println("Example 1: " + isPalindrome(head1));


        // Example 2: head = [1,2]

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("Example 2: " + isPalindrome(head2));


        // Example 3: head = [1,2,3,2,1]

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(2);
        head3.next.next.next.next = new ListNode(1);

        System.out.println("Example 3: " + isPalindrome(head3));
    }
}
