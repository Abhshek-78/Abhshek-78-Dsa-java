/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode insertionSortList(ListNode head) {

     
        ListNode dummy = new ListNode(0);

       
        ListNode current = head;

        while (current != null) {


            ListNode next = current.next;

            ListNode prev = dummy;

        
            while (prev.next != null &&
                   prev.next.val <= current.val) {
                prev = prev.next;
            }

            current.next = prev.next;
            prev.next = current;

            
            current = next;
        }

        return dummy.next;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna