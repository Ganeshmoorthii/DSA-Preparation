// 1. Standard Iterative (Most Common)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}

// 2. Recursive Approach
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}

// 3. Using HashSet (Not taking advantage of sorted property)
import java.util.*;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null) {
            if (!seen.contains(head.val)) {
                seen.add(head.val);
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null; // cut off remaining
        return dummy.next;
    }
}

// 4. Two-Pointer Technique (prev & curr)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode prev = head, curr = head.next;

        while (curr != null) {
            if (prev.val == curr.val) {
                prev.next = curr.next; // skip duplicate
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}

// 5. Dummy Head Technique
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // remove duplicate
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
