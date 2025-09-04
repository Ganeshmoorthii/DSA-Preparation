// 1. Iterative (Classic)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// 2. Recursive (Top-Down)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

// 3. Recursive (Helper + Tail Reference)
class Solution {
    private ListNode helper(ListNode prev, ListNode curr) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return helper(curr, next);
    }
    public ListNode reverseList(ListNode head) {
        return helper(null, head);
    }
}

// 4. Using Stack
import java.util.*;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
    }
}

// 5. Using ArrayList / Rebuild
import java.util.*;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        Collections.reverse(vals);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }
}
